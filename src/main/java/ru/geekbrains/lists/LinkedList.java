package ru.geekbrains.lists;

public interface LinkedList<E> {

    E removeFirst();

    E removeLast();

    int size();

    void display();

    void insertFirst(E item);

    void insertLast(E item);

    boolean isEmpty();

    boolean contains(E item);

    void remove(E item);

    E get(int idx);

    void add(E item);

    void add(E item, int idx);

    class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;

        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
