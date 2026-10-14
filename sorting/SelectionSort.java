import java.util.Arrays;

/** Selection Sort */
public class SelectionSort {

    // Each pass: find the minimum of the unsorted part and put it at position i.
    // O(n^2) time (always), O(1) space, not stable
    static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) min = j;
            }
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    public static void main(String[] args) {
        int[][] tests = {{13, 46, 24, 52, 20, 9}, {5, 4, 3, 2, 1}, {1}, {}, {3, 3, 1, 1}};
        for (int[] t : tests) {
            selectionSort(t);
            System.out.println(Arrays.toString(t));
        }
        // [9, 13, 20, 24, 46, 52] [1, 2, 3, 4, 5] [1] [] [1, 1, 3, 3]
    }
}
