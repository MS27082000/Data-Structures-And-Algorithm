import java.util.Arrays;

/** Insertion Sort */
public class InsertionSort {

    // Take a[i] and shift larger elements of the sorted prefix right to make room.
    // Worst/avg O(n^2), best O(n) (already sorted), O(1) space, stable
    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[][] tests = {{13, 46, 24, 52, 20, 9}, {5, 4, 3, 2, 1}, {1, 2, 3}, {}, {3, 3, 1, 1}};
        for (int[] t : tests) {
            insertionSort(t);
            System.out.println(Arrays.toString(t));
        }
        // [9, 13, 20, 24, 46, 52] [1, 2, 3, 4, 5] [1, 2, 3] [] [1, 1, 3, 3]
    }
}
