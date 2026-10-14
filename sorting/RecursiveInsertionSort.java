import java.util.Arrays;

/** Recursive Insertion Sort */
public class RecursiveInsertionSort {

    // Sort the first i elements recursively, then insert a[i] into the sorted prefix.
    // O(n^2) time, O(n) recursion stack
    static void insertionSort(int[] a, int i) {
        if (i >= a.length) return;
        int key = a[i];
        int j = i - 1;
        while (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = key;
        insertionSort(a, i + 1);
    }

    public static void main(String[] args) {
        int[][] tests = {{13, 46, 24, 52, 20, 9}, {5, 4, 3, 2, 1}, {1}, {}, {3, 3, 1, 1}};
        for (int[] t : tests) {
            insertionSort(t, 1);
            System.out.println(Arrays.toString(t));
        }
        // [9, 13, 20, 24, 46, 52] [1, 2, 3, 4, 5] [1] [] [1, 1, 3, 3]
    }
}
