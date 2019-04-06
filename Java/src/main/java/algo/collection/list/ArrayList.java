package algo.collection.list;

import java.util.Iterator;

public class ArrayList<T> implements List<T>, Iterable<T> {
    private static final int DEFAULT_SIZE = 100;
    private T[] data;
    private int lastIndex = -1;

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    public ArrayList(int size) {
        data = (T[]) new Object[size];
    }

    @Override
    public void add(T item) {
        set(lastIndex+1, item);
    }

    @Override
    public void set(int index, T item) {
        if (lastIndex >= data.length - 1) expand();
        if (lastIndex >= 0) shiftRight(index);
        data[index] = item;
        lastIndex++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > lastIndex) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return data[index];
    }

    @Override
    public T remove(int index) {
        if (lastIndex < data.length / 4 && data.length >= 4) shrink();
        T value = get(index);
        shiftLeft(index+1);
        data[lastIndex--] = null;
        return value;
    }

    @Override
    public int size() {
        return lastIndex + 1;
    }

    private void shiftRight(int index) {
        for (int i = lastIndex; i >= index; i--) {
            data[i+1] = data[i];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i <= lastIndex; i++) {
            data[i-1] = data[i];
        }
    }

    private void expand() {
        T[] data = (T[]) new Object[this.data.length*2];
        copyArray(this.data, data, 0, lastIndex);
        this.data = data;
    }

    private void shrink() {
        T[] data = (T[]) new Object[this.data.length/2];
        copyArray(this.data, data, 0, lastIndex);
        this.data = data;
    }

    private void copyArray(T[] src, T[] dst, int from, int to) {
        for (int i = from; i <= to; i++) {
            dst[i] = src[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>();
    }

    private class ListIterator<T> implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index <= lastIndex;
        }

        @Override
        public T next() {
            return (T) data[index++];
        }
    }
}
