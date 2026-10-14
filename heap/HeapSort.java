import java.util.Arrays;

/** Heap Sort: in place, O(n log n) worst case, O(1) extra space, NOT stable */
public class HeapSort {

    private static void maxHeapify(int[] a, int n, int i) {
        while (true) {
            int largest = i, l = 2 * i + 1, r = 2 * i + 2;
            if (l < n && a[l] > a[largest]) largest = l;
            if (r < n && a[r] > a[largest]) largest = r;
            if (largest == i) return;
            int t = a[i];
            a[i] = a[largest];
            a[largest] = t;
            i = largest;
        }
    }

    // 1) Build a MAX heap in O(n).  2) Repeatedly swap the root (the maximum) with the last element of the heap, shrink the heap
    // by one, and sift the new root down. The sorted part grows at the END of the array.
    static void heapSort(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) maxHeapify(a, n, i);       // build
        for (int end = n - 1; end > 0; end--) {
            int t = a[0];
            a[0] = a[end];
            a[end] = t;                                                 // max goes to its final position
            maxHeapify(a, end, 0);                                      // restore the heap on the remaining `end` elements
        }
    }

    public static void main(String[] args) {
        int[][] tests = {{12, 11, 13, 5, 6, 7}, {5, 4, 3, 2, 1}, {1}, {}, {3, 3, 1, 1}, {-2, 5, 0, -7, 5}};
        for (int[] t : tests) {
            heapSort(t);
            System.out.println(Arrays.toString(t));
        }
        // [5, 6, 7, 11, 12, 13] [1, 2, 3, 4, 5] [1] [] [1, 1, 3, 3] [-7, -2, 0, 5, 5]
        int[] big = new int[1000];
        for (int i = 0; i < big.length; i++) big[i] = (i * 7919) % 1009;
        int[] expected = big.clone();
        Arrays.sort(expected);
        heapSort(big);
        System.out.println(Arrays.equals(big, expected));                // true (checked against Arrays.sort)
    }
}
