import java.util.Arrays;

/** Recursive Bubble Sort */
public class RecursiveBubbleSort {

    // One pass bubbles the max to index n-1, then recurse on the first n-1 elements.
    // O(n^2) time, O(n) recursion stack
    static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        boolean swapped = false;
        for (int j = 0; j < n - 1; j++) {
            if (a[j] > a[j + 1]) {
                int t = a[j];
                a[j] = a[j + 1];
                a[j + 1] = t;
                swapped = true;
            }
        }
        if (!swapped) return;       // already sorted
        bubbleSort(a, n - 1);
    }

    public static void main(String[] args) {
        int[][] tests = {{13, 46, 24, 52, 20, 9}, {5, 4, 3, 2, 1}, {1}, {}, {3, 3, 1, 1}};
        for (int[] t : tests) {
            bubbleSort(t, t.length);
            System.out.println(Arrays.toString(t));
        }
        // [9, 13, 20, 24, 46, 52] [1, 2, 3, 4, 5] [1] [] [1, 1, 3, 3]
    }
}
