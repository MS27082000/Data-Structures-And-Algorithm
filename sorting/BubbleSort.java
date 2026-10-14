import java.util.Arrays;

/** Bubble Sort (with early exit when already sorted) */
public class BubbleSort {

    // Each pass bubbles the largest of the unsorted part to the end.
    // Worst/avg O(n^2), best O(n) with the swapped flag, O(1) space, stable
    static void bubbleSort(int[] a) {
        for (int end = a.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int j = 0; j < end; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;   // no swap in a full pass => already sorted
        }
    }

    public static void main(String[] args) {
        int[][] tests = {{13, 46, 24, 52, 20, 9}, {5, 4, 3, 2, 1}, {1, 2, 3}, {}, {3, 3, 1, 1}};
        for (int[] t : tests) {
            bubbleSort(t);
            System.out.println(Arrays.toString(t));
        }
        // [9, 13, 20, 24, 46, 52] [1, 2, 3, 4, 5] [1, 2, 3] [] [1, 1, 3, 3]
    }
}
