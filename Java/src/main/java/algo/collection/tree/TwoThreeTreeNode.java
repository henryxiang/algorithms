package algo.collection.tree;

import java.util.ArrayList;
import java.util.List;

public class TwoThreeTreeNode<K extends Comparable<K>, V> {

//    protected List<K> keys;
//    protected List<V> values;
//    protected List<TwoThreeTreeNode<K, V>> children;

    protected List<K> keys;
    protected List<V> values;
    protected List<TwoThreeTreeNode<K, V>> children;
    protected int nKey;

    public TwoThreeTreeNode() {
//        keys = new ArrayList<>(3);
//        values = new ArrayList<>(3);
//        children = new ArrayList<>(4);
//        keys = new LinkedList<>();
//        values = new LinkedList<>();
//        children = new LinkedList<>();
        keys = new ArrayList<>();
        values = new ArrayList<>();
        children = new ArrayList<>();
    }

    public void addKeyValue(K key, V value) {
        int i = 0;
        while(i < keys.size() && key.compareTo(keys.get(i)) > 0) {
            i++;
        }
        keys.add(i, key);
        values.add(i, value);
    }

    public boolean isFourNode() {
        return keys.size() == 3;
    }

    public boolean isLeaf() {
        return children.size() == 0;
    }

    public TwoThreeTreeNode<K, V> split() {
        if (!isFourNode()) throw new UnsupportedOperationException();

        TwoThreeTreeNode<K, V> left = new TwoThreeTreeNode<>();
        left.addKeyValue(keys.get(0), values.get(0));


        TwoThreeTreeNode<K, V> right = new TwoThreeTreeNode<>();
        right.addKeyValue(keys.get(2), values.get(2));

        if (!isLeaf()) {
            left.children.add(children.get(0));
            left.children.add(children.get(1));
            right.children.add(children.get(2));
            right.children.add(children.get(3));
        }

        TwoThreeTreeNode<K, V> root = new TwoThreeTreeNode<>();
        root.addKeyValue(keys.get(1), values.get(1));
        root.children.add(left);
        root.children.add(right);

        return root;
    }

}
