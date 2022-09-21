package ru.geekbrains.lists;

import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayListImpl<E> implements ArrayList<E> {

    private E[] array;
    private int elementsCount;
    private int lastIndex = -1;

    public ArrayListImpl(int maxSize) {
        this.array = (E[]) new Object[maxSize];
    }

    @Override
    public void add(E item) {
        if (elementsCount == array.length) {
            array = Arrays.copyOf(array, elementsCount * 2);
        }
        array[++lastIndex] = item;
        elementsCount++;
    }

    @Override
    public void add(E item, int idx) {
        if (idx > lastIndex)
            throw new IndexOutOfBoundsException("Index " + idx + " is out of bound, last index = " + lastIndex);
        if (idx < 0)
            throw new IllegalArgumentException("Index must be positive");

        E[] subArrayBeforeItem = Arrays.copyOfRange(array, 0, idx);
        E[] subArrayAfterItem = Arrays.copyOfRange(array, idx, array.length);

        array = (E[]) Stream.of(subArrayBeforeItem, new Object[]{item}, subArrayAfterItem).flatMap(Stream::of).toArray();

        elementsCount++;
        lastIndex++;
    }

    @Override
    public E remove(int idx) {
        if (idx > lastIndex)
            throw new IndexOutOfBoundsException("Index " + idx + " is out of bound, last index = " + lastIndex);
        if (idx < 0)
            throw new IllegalArgumentException("Index must be positive");
        E removedItem = array[idx];

        E[] subArrayBeforeItem = Arrays.copyOfRange(array, 0, idx);
        E[] subArrayAfterItem = Arrays.copyOfRange(array, idx + 1, array.length + 2);

        array = (E[]) Stream.of(subArrayBeforeItem, subArrayAfterItem).flatMap(Stream::of).toArray();

        elementsCount--;
        lastIndex--;
        return removedItem;
    }

    @Override
    public E get(int idx) {
        if (idx > lastIndex)
            throw new IndexOutOfBoundsException("Index " + idx + " is out of bound, last index = " + lastIndex);
        if (idx < 0)
            throw new IllegalArgumentException("Index must be positive");

        return array[idx];
    }

    @Override
    public boolean contains(E item) {
        for (E o : array) {
            if (o != null && o.equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public int size() {
        return elementsCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (E el : array) {
            if (el != null) {
                sb.append(el).append(",");
            }
        }
        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }
}
