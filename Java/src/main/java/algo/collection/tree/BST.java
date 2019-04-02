package algo.collection.tree;

import algo.collection.list.LinkedList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        int height;

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
        return size(root);
    }

    private int size(Node<K, V> node) {
        if (node == null) return 0;
        return node.size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node<K, V> node) {
        if (node == null) return -1;
        return node.height;
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

    private Node<K,V> put(K key, V value, Node<K,V> node) {
        if (node == null) {
            Node<K, V> newNode = new Node<>(key, value);
            return newNode;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(key, value, node.left);
        } else if (cmp > 0) {
            node.right = put(key, value, node.right);
        } else {
            node.value = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

    public Node<K, V> min() {
        return min(root);
    }

    private Node<K, V> min(Node<K, V> node) {
        if (node == null) return null;
        if (node.left == null) return node;
        return min(node.left);
    }

    public Node<K, V> max() {
        return max(root);
    }

    private Node<K, V> max(Node<K, V> node) {
        if (node == null) return null;
        if (node.right == null) return node;
        return max(node.right);
    }

    public void delete(K key) {
        root = delete(key, root);
    }

    private Node<K, V> delete(K key, Node<K, V> node) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(key, node.left);
            node.size = 1 + size(node.left) + size(node.right);
            node.height = 1 + Math.max(height(node.left), height(node.right));
            return node;
        }
        if (cmp > 0) {
            node.right = delete(key, node.right);
            node.size = 1 + size(node.left) + size(node.right);
            node.height = 1 + Math.max(height(node.left), height(node.right));
            return node;
        }
        if (node.left == null && node.right == null) {
            return null;
        } else if (node.left == null && node.right != null) {
            return node.right;
        } else if (node.left != null && node.right == null) {
            return node.left;
        } else {
            Node<K, V> minRight = min(node.right);
            node.key = minRight.key;
            node.value = minRight.value;
            node.right = deleteMin(node.right);
            node.size = 1 + size(node.left) + size(node.right);
            node.height = 1 + Math.max(height(node.left), height(node.right));
            return node;
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = 1 + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

    public void  deleteMax() {
        root = deleteMax(root);
    }

    private Node<K, V> deleteMax(Node<K, V> node) {
        if (node == null) return null;
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.size = 1 + size(node.left) + size(node.right);
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return node;
    }

    public boolean isBST() {
        return isBST(root);
    }

    private boolean isBST(Node<K, V> root) {
        if (root == null) return true;
        if (root.key == null) return false;
        if (!isBST(root.left)) return false;
        if (!isBST(root.right)) return false;
        if (root.left != null && root.left.key != null && root.key.compareTo(root.left.key) < 0) return false;
        if (root.right != null && root.right.key != null && root.key.compareTo(root.right.key) > 0) return false;
        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<K, V> node) {
        if (node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 &&
                isBalanced(node.left) &&
                isBalanced(node.right);
    }

    public String toJsonString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(root);
        return json;
    }
}
