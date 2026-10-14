import java.util.Arrays;

/** Quick Sort (Lomuto-style partition, middle element as pivot to avoid the sorted-input worst case) */
public class QuickSort {

    // Avg O(n log n), worst O(n^2), O(log n) recursion stack, not stable
    static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low >= high) return;
        int p = partition(a, low, high);
        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);
    }

    private static int partition(int[] a, int low, int high) {
        int mid = low + (high - low) / 2;
        swap(a, mid, high);                // move pivot to the end
        int pivot = a[high];
        int i = low;                       // next slot for an element < pivot
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) swap(a, i++, j);
        }
        swap(a, i, high);                  // pivot goes to its final position
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[][] tests = {{4, 6, 2, 5, 7, 9, 1, 3}, {5, 4, 3, 2, 1}, {1}, {}, {3, 3, 1, 1}, {2, 2, 2, 2}};
        for (int[] t : tests) {
            quickSort(t);
            System.out.println(Arrays.toString(t));
        }
        // [1, 2, 3, 4, 5, 6, 7, 9] [1, 2, 3, 4, 5] [1] [] [1, 1, 3, 3] [2, 2, 2, 2]
    }
}
