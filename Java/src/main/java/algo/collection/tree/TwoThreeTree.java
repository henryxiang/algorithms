package algo.collection.tree;

public class TwoThreeTree<K extends Comparable<K>, V> {
    protected class Node {
        K[] keys;
        V[] values;
        Node[] children;
    }
}
