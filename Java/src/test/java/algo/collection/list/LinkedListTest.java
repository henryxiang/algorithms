package algo.collection.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<Integer> list;

    @Test
    public void testAppendToList() {
        list = new LinkedList<>();
        assertEquals(0, list.size());

        int n = 5;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        assertEquals(5, list.size());

        for (int i = 0; i < n; i++) {
            Node<Integer> node = list.get(i);
            assertEquals(Integer.valueOf(i), node.value);
        }
    }

    @Test
    public void testRemoveElementInList() {
        list = new LinkedList<>();
        Integer[] initialValues = {1, 2, 3, 4, 5};
        Integer[] finalValues = {1, 2, 4, 5};

        for(int v : initialValues) {
            list.add(v);
        }

        for (int i = 0; i < initialValues.length; i++) {
            assertEquals(initialValues[i], list.get(i).value);
        }

        list.remove(2);
        for (int i = 0; i < finalValues.length; i++) {
            assertEquals(finalValues[i], list.get(i).value);
        }
    }

    @Test
    public void testIteration() {
        list = new LinkedList<>();

        int n = 5;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer e : list) {
            stringBuilder.append(e);
        }
        assertEquals("01234", stringBuilder.toString());
    }
}