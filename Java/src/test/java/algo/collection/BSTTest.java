package algo.collection;

import algo.sorting.QuickSort;
import algo.sorting.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Test
    public void testBSTValidation() {
        String[] data = {
                "A", "B", "C", "D", "E", "F", "G"
        };
        Utils.shuffle(data);

        BST<String, String> bst = new BST<>();
        assertTrue(bst.isBST());

        for(String e : data) {
            bst.put(e, e);
            assertTrue(bst.isBST());
        }
    }

    @Test
    public void testFindMinAndDeleteMin() {
        String[] data = {
                "A", "B", "C", "D", "E", "F", "G"
        };
        Utils.shuffle(data);

        BST<String, String> bst = new BST<>();
        for(String e : data) {
            bst.put(e, e);
        }

        int size = data.length;
        assertEquals(size, bst.size());

        QuickSort.sort(data);
        for (String e : data) {
            assertEquals(e, bst.min().key);
            bst.deleteMin();
            assertNull(bst.get(e));
            assertEquals(--size, bst.size());
        }
    }

    @Test
    public void testFindMaxAndDeleteMax() {
        String[] data = {
                "A", "B", "C", "D", "E", "F", "G"
        };
        Utils.shuffle(data);

        BST<String, String> bst = new BST<>();
        for(String e : data) {
            bst.put(e, e);
        }

        int size = data.length;
        assertEquals(size, bst.size());

        QuickSort.sort(data);
        Utils.reverse(data);
        for (String e : data) {
            assertEquals(e, bst.max().key);
            bst.deleteMax();
            assertNull(bst.get(e));
            assertEquals(--size, bst.size());
        }
    }

    @Test
    public void testDeletion() {
        String[] data = {
                "A", "B", "C", "D", "E", "F", "G"
        };
        Utils.shuffle(data);

        BST<String, String> bst = new BST<>();
        for(String e : data) {
            bst.put(e, e);
        }

        int size = data.length;
        assertEquals(size, bst.size());

        Utils.shuffle((data));
        for(String e : data) {
            bst.delete(e);
            assertNull(bst.get(e));
            assertEquals(--size, bst.size());
        }
    }

    @Test
    public void testGettingTreeHeight() {
        String[] data = {
                "A", "B", "C", "D", "E", "F", "G"
        };
        Utils.shuffle(data);

        BST<String, String> bst = new BST<>();
        for(String e : data) {
            bst.put(e, e);
        }

        assertEquals(bstHeight(bst.root), bst.height());
    }

    private int bstHeight(BST.Node node) {
        if (node == null) return -1;
        return 1 + Math.max(bstHeight(node.left), bstHeight(node.right));
    }
}