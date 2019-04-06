package algo.collection.tree;

public class TwoThreeTree<K extends Comparable<K>, V> {

    private TwoThreeTreeNode<K, V> root;

    public V get(K key) {
        return get(key, root);
    }

    private V get(K key, TwoThreeTreeNode<K, V> node) {
        int i = 0;
        for (K k : node.keys) {
            if (key.compareTo(k) > 0) i++;
        }
        if (key.compareTo(node.keys.get(i)) == 0) {
            return node.values.get(i);
        }
        return get(key, node.children.get(i));
    }

    public void put(K key, V value) {
        root = put(key, value, root);
        if (root.isFourNode()) {
            TwoThreeTreeNode<K, V> x = root.split();
            root = new TwoThreeTreeNode<>();
            root.addKeyValue(x.keys.get(0), x.values.get(0));
            root.children.add(x.children.get(0));
            root.children.add(x.children.get(1));
        }
    }

    private TwoThreeTreeNode put(K key, V value, TwoThreeTreeNode<K, V> node) {
        if (node == null) {
            TwoThreeTreeNode newNode = new TwoThreeTreeNode();
            newNode.addKeyValue(key, value);
            return newNode;
        }
        if (node.isLeaf()) {
            node.addKeyValue(key, value);
            return node;
        }
        int i = 0;
        for (K k : node.keys) {
            if (key.compareTo(k) > 0) i++;
        }
        if (key.compareTo(node.keys.get(i)) == 0) {
            node.values.add(i, value);
            return node;
        }
        node.children.add(i, put(key, value, node.children.get(i)));
        if (node.children.get(i).isFourNode()) {
            TwoThreeTreeNode<K, V> x = node.children.get(i).split();
            node.addKeyValue(x.keys.get(0), x.values.get(0));
            node.children.add(i, x.children.get(0));
            node.children.add(i+1, x.children.get(1));
        }
        return node;
    }

    public int height() {
        return height(root);
    }

    private int height(TwoThreeTreeNode<K, V> node) {
        if (node == null) return -1;
        if (node.isLeaf()) return 0;
        return height(node.children.get(0)) + 1;
    }

    public int size() {
        return size(root);
    }

    private int size(TwoThreeTreeNode<K, V> node) {
        if (node.isLeaf()) return node.keys.size();
        int size = node.keys.size();
        for (int i = 0; i <= node.nKey; i++) {
            size += size(node.children.get(0));
        }
        return size;
    }
}
