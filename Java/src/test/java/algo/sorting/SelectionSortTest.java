package algo.sorting;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import static org.junit.Assert.*;
import static algo.sorting.Utils.*;

public class SelectionSortTest {
    Stopwatch stopwatch = Stopwatch.createUnstarted();
    @Test
    public void testSorting() {
        int n = 500;
        Integer[] input = new Integer[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.valueOf(i+1);
        }

        shuffle(input);
        assertFalse(isSorted(input));

        stopwatch.start();
        SelectionSort.sort(input);
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());

        assertTrue(isSorted(input));
    }
}