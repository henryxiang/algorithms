package algo.collection.tree;

import algo.sorting.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoThreeTreeTest {
    private TwoThreeTree<Integer, Integer> tree;

    @Test
    public void testSimpleAdding() {
        int n = 5;
        tree = new TwoThreeTree<>();
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = i;
        }
        Utils.shuffle(data);

        for (Integer k : data) {
            tree.put(k, k);
        }

        assertEquals(n, tree.size());
        System.out.println(tree.height());
    }

}