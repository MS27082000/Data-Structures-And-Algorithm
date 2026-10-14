import java.util.Arrays;

/** Heapify: restore the heap property at ONE node whose two subtrees are already heaps (sift down), plus sift up */
public class HeapifyAlgorithm {

    // MAX-heapify at index i for a heap of size n: if a child is bigger, swap with the BIGGEST child and keep sinking.
    // O(log n) time (the height), O(1) space (iterative)
    static void maxHeapify(int[] a, int n, int i) {
        while (true) {
            int largest = i, l = 2 * i + 1, r = 2 * i + 2;
            if (l < n && a[l] > a[largest]) largest = l;
            if (r < n && a[r] > a[largest]) largest = r;
            if (largest == i) return;                  // heap property holds here: stop
            int t = a[i];
            a[i] = a[largest];
            a[largest] = t;
            i = largest;                               // the swapped-down value may violate the property below
        }
    }

    // MIN-heapify: mirror image (swap with the SMALLEST child)
    static void minHeapify(int[] a, int n, int i) {
        while (true) {
            int smallest = i, l = 2 * i + 1, r = 2 * i + 2;
            if (l < n && a[l] < a[smallest]) smallest = l;
            if (r < n && a[r] < a[smallest]) smallest = r;
            if (smallest == i) return;
            int t = a[i];
            a[i] = a[smallest];
            a[smallest] = t;
            i = smallest;
        }
    }

    // SIFT UP (used after inserting at the end of a max-heap): swap with the parent while bigger. O(log n)
    static void siftUpMax(int[] a, int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (a[p] >= a[i]) return;
            int t = a[p];
            a[p] = a[i];
            a[i] = t;
            i = p;
        }
    }

    static boolean isMaxHeap(int[] a, int n) {
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int l = 2 * i + 1, r = 2 * i + 2;
            if (l < n && a[i] < a[l]) return false;
            if (r < n && a[i] < a[r]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Root 1 violates the max-heap property; both subtrees (rooted at 14 and 10) are valid heaps
        int[] a = {1, 14, 10, 8, 7, 9, 3, 2, 4, 6};
        System.out.println(isMaxHeap(a, a.length));            // false
        maxHeapify(a, a.length, 0);
        System.out.println(Arrays.toString(a));                // [14, 8, 10, 4, 7, 9, 3, 2, 1, 6]
        System.out.println(isMaxHeap(a, a.length));            // true

        int[] m = {9, 2, 3, 5, 4};                              // min-heapify the root of a tree whose subtrees are min-heaps
        minHeapify(m, m.length, 0);
        System.out.println(Arrays.toString(m));                // [2, 4, 3, 5, 9]

        int[] s = {10, 8, 9, 4, 5, 20};                         // a new element 20 was just added at the end of a max-heap
        siftUpMax(s, s.length - 1);
        System.out.println(Arrays.toString(s));                // [20, 8, 10, 4, 5, 9]
        System.out.println(isMaxHeap(s, s.length));            // true
    }
}
