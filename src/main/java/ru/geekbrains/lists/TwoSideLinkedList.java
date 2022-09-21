package ru.geekbrains.lists;

import java.util.Iterator;

public class TwoSideLinkedList<E> implements LinkedList<E>, Iterable<E> {

    protected Node<E> first;
    protected Node<E> last;
    protected int size;

    @Override
    public void insertFirst(E item) {
        Node<E> currentFirst = first;
        first = new Node<>(item, currentFirst, null);
        size++;

        if (size == 1) {
            last = first;
        } else {
            currentFirst.previous = first;
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> current = first;
        first = current.next;
        size--;
        if (size == 0) {
            last = null;
        } else {
            first.previous = null;
        }
        current.next = null;
        return current.value;
    }

    @Override
    public void insertLast(E item) {
        Node<E> currentLast = last;
        last = new Node<>(item, null, currentLast);
        size++;
        if (size == 1) {
            first = last;
        } else {
            currentLast.next = last;
        }
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node<E> currentLast = last;
        last = currentLast.previous;
        size--;
        if (size == 0) {
            first = null;
        } else {
            currentLast.previous.next = null;
        }
        currentLast.previous = null;
        return currentLast.value;
    }

    @Override
    public E get(int idx) {
        return getNode(idx).value;
    }

    @Override
    public void add(E item) {
        insertLast(item);
    }

    private Node<E> getNode(int idx) {
        if (idx < 0 || idx >= size) throw new IllegalArgumentException("Illegal index");
        if (isEmpty()) throw new IllegalStateException("List is empty");

        Node<E> current = first;
        int i = 0;

        while (idx > i) {
            current = current.next;
            i++;
        }

        return current;
    }

    @Override
    public void add(E item, int idx) {
        if (idx == 0) {
            insertFirst(item);
            return;
        }

        Node<E> target = getNode(idx);

        Node<E> current = new Node<>(item, target, target.previous);
        target.previous.next = current;
        target.previous = current;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E item) {
        Node<E> current = first;
        while (current != null) {
            if (current.value.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void remove(E item) {
        Node<E> current = first;

        while (current != null) {

            if (current.value.equals(item)) {

                if (current == first) {
                    removeFirst();
                    break;
                } else if (current == last) {
                    removeLast();
                    break;
                }

                current.previous.next = current.next;
                current.next.previous = current.previous;
                current.next = null;
                current.previous = null;
                size--;
                break;
            }
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        Node<E> current = first;

        while (current != null) {
            sb.append(current.value);

            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E currentValue = current.value;
                current = current.next;
                return currentValue;
            }

            public void reset() {
                current = first;
            }
        };
    }
}
