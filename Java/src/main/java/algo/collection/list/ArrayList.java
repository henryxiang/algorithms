package algo.collection.list;

import org.checkerframework.checker.units.qual.A;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 100;
    private T[] data;
    private int lastIndex = -1;

    public ArrayList() {
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    public ArrayList(int size) {
        data = (T[]) new Object[size];
    }

    @Override
    public void add(T item) {
        data[lastIndex++] = item;
    }

    @Override
    public void add(int index, T item) {
        shiftRight(index);
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
}
