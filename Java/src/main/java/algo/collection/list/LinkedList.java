package algo.collection.list;

import java.util.Iterator;

/**
 * LinkedList
 */
public class LinkedList<T> implements List<T>, Iterable<T> {
    protected Node head;
    protected Node tail;
    protected int size;

    protected class Node {
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
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        Node node = getNodeAt(index);
        return node == null ? null : node.value;
    }

    @Override
    public void set(int index, T value) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Invalid index: " + index);
        if (index == 0) {
            addFirst(value);
        } else if (index == size-1) {
            add(value);
        } else {
            Node node = new Node(value);
            Node prev = getNodeAt(index-1);
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }

    public void addFirst(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    @Override
    public void add(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node removedNode;
        if (index == 0) {
            removedNode = head;
            head = removedNode.next;
            if (head == null) tail = null;
        } else {
            Node prev = getNodeAt(index-1);
            removedNode = prev.next;
            prev.next = removedNode.next;
            if (removedNode == tail) tail = prev;
        }
        size--;
        return removedNode.value;
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