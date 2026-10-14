import java.util.Arrays;

/** Build a Heap from an Array: bottom-up heapify in O(n), versus n insertions in O(n log n) */
public class BuildHeap {

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

    // Leaves (indices n/2 .. n-1) are already one-element heaps, so start at the LAST INTERNAL node (n/2 - 1) and heapify upward.
    // O(n) time (most nodes are near the bottom and sink very little), O(1) space
    static void buildMaxHeap(int[] a) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) maxHeapify(a, n, i);
    }

    // Alternative: insert one by one with sift-up. O(n log n)
    static int[] buildByInsertion(int[] input) {
        int[] heap = new int[input.length];
        for (int size = 0; size < input.length; size++) {
            heap[size] = input[size];
            int i = size;
            while (i > 0 && heap[(i - 1) / 2] < heap[i]) {
                int p = (i - 1) / 2, t = heap[p];
                heap[p] = heap[i];
                heap[i] = t;
                i = p;
            }
        }
        return heap;
    }

    static boolean isMaxHeap(int[] a) {
        for (int i = 0; i <= (a.length - 2) / 2; i++) {
            int l = 2 * i + 1, r = 2 * i + 2;
            if (l < a.length && a[i] < a[l]) return false;
            if (r < a.length && a[i] < a[r]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {4, 10, 3, 5, 1};
        buildMaxHeap(a);
        System.out.println(Arrays.toString(a) + " " + isMaxHeap(a));        // [10, 5, 3, 4, 1] true
        int[] b = {1, 2, 3, 4, 5, 6, 7};
        buildMaxHeap(b);
        System.out.println(Arrays.toString(b) + " " + isMaxHeap(b));        // [7, 5, 6, 4, 2, 1, 3] true
        int[] c = buildByInsertion(new int[]{4, 10, 3, 5, 1});
        System.out.println(Arrays.toString(c) + " " + isMaxHeap(c));        // [10, 5, 3, 4, 1] true  (a different but valid heap can result)
        int[] d = {42};
        buildMaxHeap(d);
        System.out.println(Arrays.toString(d));                             // [42]
        int[] e = {};
        buildMaxHeap(e);
        System.out.println(Arrays.toString(e));                             // []
    }
}
