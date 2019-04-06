package algo.collection.list;

public class SortedList<T extends Comparable<T>> extends LinkedList<T> {
    @Override
    public void set(int index, T item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(T item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        if (node.value.compareTo(head.value) <= 0) {
            node.next = head;
            head = node;
            size++;
            return;
        }
        Node current = head;
        while(current.next != null && node.value.compareTo(current.value) > 0) {
            current = current.next;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }
}
