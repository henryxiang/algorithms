package algo.sorting;

import java.util.Random;

public class Utils {
    public static void shuffle(Comparable[] input) {
        int end = input.length - 1;
        for (int i = 0; i < end; i++) {
            int r = getRandomInt(i, end);
            swap(input, i, r);
        }
    }

    private static int getRandomInt(int start, int end) {
        Random r = new Random();
        return start + r.nextInt(end - start + 1);
    }

    public static boolean isSorted(Comparable[] input) {
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i].compareTo(input[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void swap(Comparable[] input, int i, int j) {
        Comparable temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
