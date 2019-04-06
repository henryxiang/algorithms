package algo.collection.list;

import algo.sorting.QuickSort;
import algo.sorting.Utils;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortedListTest {
    private SortedList<Integer> list;

    @Test
    public void testSorting() {
        int n = 50;
        Integer[] data = new Integer[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
        Utils.shuffle(data);

        list = new SortedList<>();
        for (int i = 0; i < data.length; i++) {
            list.add(i);
        }
        assertEquals(n, list.size());

        QuickSort.sort(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(Integer.valueOf(i), list.get(i));
        }
    }

}