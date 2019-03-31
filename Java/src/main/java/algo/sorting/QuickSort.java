package algo.sorting;

import static algo.sorting.Utils.swap;

public class QuickSort {
    public static void sort(Comparable[] input) {
        sort(input, 0, input.length - 1);
    }

    private static void sort(Comparable[] input, int start, int end) {
        if (end <= start) return;
        int[] pivots = partition(input, start, end);
        sort(input, start, pivots[0]);
        sort(input, pivots[1], end);
    }

    private static int[] partition(Comparable[] input, int start, int end) {
        Comparable key = input[start];
        int i = start, l = start, h = end;
        while (i <= h) {
            if (input[i].compareTo(key) < 0) {
                swap(input, l++, i++);
            } else if (input[i].compareTo(key) > 0) {
                swap(input, i, h--);
            } else {
                i++;
            }
        }
        int[] pivots = {l-1, h+1};
        return pivots;
    }
}
