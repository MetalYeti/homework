package ru.geekbrains.lists;

public interface ArrayList<E> {

    void add(E item);

    void add(E item, int idx);

    E remove(int idx);

    E get(int idx);

    boolean contains(E item);

    boolean isEmpty();

    int size();
}
