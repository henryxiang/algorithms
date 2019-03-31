package algo.collection;

import algo.collection.list.LinkedList;

import java.util.Iterator;

public class BST<K extends Comparable, V> implements Iterable<BST.Node> {
    @Override
    public Iterator<BST.Node> iterator() {
        LinkedList<BST.Node> list = new LinkedList<>();
        inOrderTraverse(root, list);
        return list.iterator();
    }

    private void inOrderTraverse(Node root, LinkedList<BST.Node> list) {
        if(root == null) return;
        inOrderTraverse(root.left, list);
        list.add(root);
        inOrderTraverse(root.right, list);
    }

    protected class Node<K, V> {
        K key;
        V value;
        Node<K, V> left;
        Node<K, V> right;
        int size;

        public Node() {
            this.size = 1;
        }

        public Node(K key, V value) {
            this();
            this.key = key;
            this.value = value;
        }
    }

    protected Node<K, V> root;

    public int size() {
        if (root == null) {
            return 0;
        } else {
            return root.size;
        }
    }

    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, Node<K,V> root) {
        if (root == null) return null;

        if (key.compareTo(root.key) == 0) {
            return root.value;
        } else if (key.compareTo(root.key) < 0) {
            return get(key, root.left);
        } else {
            return get(key, root.right);
        }
    }

    public void put(K key, V value) {
        root = put(key, value, root);
    }

    private Node<K,V> put(K key, V value, Node<K,V> root) {
        if (root == null) {
            Node<K, V> node = new Node<>(key, value);
            return node;
        }

        if (key.compareTo(root.key) == 0) {
            root.value = value;
        } else if (key.compareTo(root.key) < 0) {
            root.left = put(key, value, root.left);
        } else {
            root.right = put(key, value, root.right);
        }
        int sizeLeft = root.left == null ? 0 : root.left.size;
        int sizeRight = root.right == null ? 0 : root.right.size;
        root.size = sizeLeft + sizeRight + 1;
        return root;
    }
}
