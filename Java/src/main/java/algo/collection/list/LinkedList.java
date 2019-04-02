package algo.collection.list;

import java.util.Iterator;

/**
 * LinkedList
 */
public class LinkedList<T> implements List<T>, Iterable<T> {
    private Node head;
    private int size;

    private class Node {
        protected T value;
        protected Node next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node getNodeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node node = head;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node;
    }

    @Override
    public T get(int index) {
        Node node = getNodeAt(index);
        return node == null ? null : node.value;
    }

    @Override
    public void add(int index, T value) {
        Node node = new Node(value);
        if (index == 0) {
            Node temp = head;
            head = node;
            node.next = temp;
        } else {
            Node prev = getNodeAt(index-1);
            Node temp = prev.next;
            prev.next = node;
            node.next = temp;
        }
        size++;
    }

    @Override
    public void add(T value) {
        add(size, value);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node;
        if (index == 0) {
            node = head;
            head = node.next;
        } else {
            Node prev = getNodeAt(index-1);
            node = prev.next;
            prev.next = node.next;
        }
        node.next = null;
        size--;
        return node.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(head);
    }

    private class ListIterator<T> implements Iterator<T> {
        Node current;

        public ListIterator(Node first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = (T) current.value;
            current = current.next;
            return value;
        }
    }
}