package ru.geekbrains.concurrent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private static final Map<String, Integer> map = new LinkedHashMap<>();
    private static int counter;
    private static final Lock lock = new ReentrantLock(true);

    public static void increment(String threadName) {
        lock.lock();
        counter++;
        map.put(threadName, map.getOrDefault(threadName, 0) + 1);
        lock.unlock();
    }

    public static int getCounter() {
        return counter;
    }

    public static Map<String, Integer> getMap() {
        return map;
    }

    public static void main(String[] args) {

        class Task implements Runnable {
            private final int count;

            public Task(int count) {
                this.count = count;
            }

            @Override
            public void run() {
                for (int i = 0; i < count; i++) {
                    Counter.increment(Thread.currentThread().getName());
                }
            }
        }

        Thread[] threads = {new Thread(new Task(1000)),
                new Thread(new Task(500)),
                new Thread(new Task(2000)),
                new Thread(new Task(3250))
        };


        for (Thread t : threads) {
            t.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getMap());
        System.out.println(getCounter());
    }


}
