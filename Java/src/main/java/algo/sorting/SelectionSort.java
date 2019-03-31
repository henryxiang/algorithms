package algo.sorting;

import static algo.sorting.Utils.swap;

public class SelectionSort {
    public static void sort(Comparable[] input) {
        int end = input.length - 1;
        for (int i = 0; i < end; i++) {
            int minIndex = findMin(input, i, end);
            swap(input, i, minIndex);
        }
    }

    private static int findMin(Comparable[] input, int start, int end) {
        int minIndex = start;
        Comparable minValue = input[start];
        for (int i = start + 1; i <= end; i++) {
            if (input[i].compareTo(minValue) < 0) {
                minIndex = i;
                minValue = input[i];
            }
        }
        return minIndex;
    }

}
