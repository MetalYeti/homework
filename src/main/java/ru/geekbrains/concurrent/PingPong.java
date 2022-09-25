package ru.geekbrains.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PingPong implements Runnable {

    private final String text;
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();


    public PingPong(String text) {
        this.text = text;
    }

    public static void main(String[] args) {
        Thread ping = new Thread(new PingPong("Ping"));
        Thread pong = new Thread(new PingPong("Pong"));

        ping.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pong.start();
    }

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                condition.await(1, TimeUnit.SECONDS);
                System.out.println(text);
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

