package algo.collection.list;

import java.util.Iterator;

/**
 * LinkedList
 */
public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size;

    public Node<T> get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node<T> node = head;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node;
    }

    public void add(int index, T value) {
        Node<T> node = new Node<>(value);
        if (index == 0) {
            Node<T> temp = head;
            head = node;
            node.next = temp;
        } else {
            Node<T> prev = get(index-1);
            Node<T> temp = prev.next;
            prev.next = node;
            node.next = temp;
        }
        size++;
    }

    public void add(T value) {
        add(size, value);
    }

    public Node<T> remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node;
        if (index == 0) {
            node = head;
            head = node.next;
        } else {
            Node<T> prev = get(index-1);
            node = prev.next;
            prev.next = node.next;
        }
        node.next = null;
        size--;
        return node;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(head);
    }

    private class ListIterator<T> implements Iterator<T> {
        Node<T> current;

        public ListIterator(Node<T> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}