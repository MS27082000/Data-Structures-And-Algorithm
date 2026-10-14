import java.util.Arrays;

/** Convert a Min Heap to a Max Heap (array form) */
public class ConvertMinHeapToMaxHeap {

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

    // A min heap's ordering is useless for a max heap, so simply BUILD a max heap from scratch (bottom-up). O(n) time, O(1) space
    static void convert(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) maxHeapify(a, a.length, i);
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
        int[] minHeap = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int[] copy = minHeap.clone();
        convert(minHeap);
        System.out.println(Arrays.toString(minHeap));                           // [20, 18, 10, 12, 9, 9, 3, 5, 6, 8]
        System.out.println(isMaxHeap(minHeap));                                 // true
        int[] x = copy.clone(), y = minHeap.clone();
        Arrays.sort(x);
        Arrays.sort(y);
        System.out.println(Arrays.equals(x, y));                                // true: same elements, only rearranged
        int[] small = {1, 2, 3};
        convert(small);
        System.out.println(Arrays.toString(small));                             // [3, 2, 1]
        int[] one = {7};
        convert(one);
        System.out.println(Arrays.toString(one));                               // [7]
    }
}
