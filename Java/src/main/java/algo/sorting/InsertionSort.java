package algo.sorting;

import static algo.sorting.Utils.swap;

public class InsertionSort {
    public static void sort (Comparable[] input) {
        for (int i = 1; i < input.length; i++) {
            int j = i;
            while(j > 0 && input[j].compareTo(input[j-1]) < 0) {
                swap(input, j-1, j);
                j = j -1;
            }
        }
    }
}
