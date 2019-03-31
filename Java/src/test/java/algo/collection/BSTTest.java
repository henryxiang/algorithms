package algo.collection;

import algo.sorting.QuickSort;
import algo.sorting.Utils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BSTTest {

    @Test
    public void testBasicPutAndGet() {
        int n = 9;
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        Utils.shuffle(a);
        BST<Integer, Integer> bst = new BST<>();
        assertEquals(0, bst.size());

        for (Integer i : a) {
            bst.put(i, i);
        }
        assertEquals(n, bst.size());

        for (Integer i : a) {
            assertEquals(i, bst.get(i));
        }
    }

    @Test
    public void testIteration() {
        String[] data = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
        };
        Utils.shuffle(data);

        BST<String, String> bst = new BST<>();
        for(String e : data) {
            bst.put(e, e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (BST.Node node : bst) {
            stringBuilder.append(node.key);
        }
        QuickSort.sort(data);
        assertEquals(String.join("", data), stringBuilder.toString());
    }
}