package algo.sorting;

public class MergeSort {
    private static Comparable[] aux;

    public static void sort(Comparable[] input) {
        aux = new Comparable[input.length];
        sort(input, 0, input.length - 1);
    }

    private static void sort(Comparable[] input, int start, int end) {
        if (end <= start) return;
        int mid = (start + end) / 2;
        sort(input, start, mid);
        sort(input, mid + 1, end);
        merge(input, start, end, mid);
    }

    private static void merge(Comparable[] input, int start, int end, int mid) {
        for (int i = start; i <= end; i++) {
            aux[i] = input[i];
        }
        int p1 = start;
        int p2 = mid + 1;
        int k = start;
        while (k <= end) {
            if (p1 > mid) {
                input[k++] = aux[p2++];
            } else if (p2 > end) {
                input[k++] = aux[p1++];
            } else if (aux[p1].compareTo(aux[p2]) < 0) {
                input[k++] = aux[p1++];
            } else {
                input[k++] = aux[p2++];
            }
        }
    }
}
