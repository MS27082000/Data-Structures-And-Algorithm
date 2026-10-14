import java.util.Arrays;

/** Merge Sort (divide and conquer) */
public class MergeSort {

    // O(n log n) time in all cases, O(n) extra space, stable
    static void mergeSort(int[] a) {
        if (a.length < 2) return;
        mergeSort(a, 0, a.length - 1, new int[a.length]);
    }

    private static void mergeSort(int[] a, int low, int high, int[] tmp) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(a, low, mid, tmp);
        mergeSort(a, mid + 1, high, tmp);
        merge(a, low, mid, high, tmp);
    }

    private static void merge(int[] a, int low, int mid, int high, int[] tmp) {
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];   // <= keeps it stable
            else tmp[k++] = a[j++];
        }
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= high) tmp[k++] = a[j++];
        for (k = low; k <= high; k++) a[k] = tmp[k];
    }

    public static void main(String[] args) {
        int[][] tests = {{13, 46, 24, 52, 20, 9}, {5, 4, 3, 2, 1}, {1}, {}, {3, 3, 1, 1}, {-2, 5, 0, -7}};
        for (int[] t : tests) {
            mergeSort(t);
            System.out.println(Arrays.toString(t));
        }
        // [9, 13, 20, 24, 46, 52] [1, 2, 3, 4, 5] [1] [] [1, 1, 3, 3] [-7, -2, 0, 5]
    }
}
