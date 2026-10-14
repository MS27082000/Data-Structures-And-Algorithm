import java.util.Arrays;
import java.util.PriorityQueue;

/** Sort a K-Sorted Array: every element is at most k positions away from its sorted position */
public class SortKSortedArray {

    // The element that belongs at index i is among the next k + 1 elements. Keep a MIN-heap of size k + 1: poll the smallest
    // into the output, slide the window. O(n log k) time, O(k) space (vs O(n log n) for a plain sort)
    static int[] sortKSorted(int[] a, int k) {
        int n = a.length;
        int[] result = new int[n];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            heap.offer(a[i]);
            if (heap.size() > k) result[idx++] = heap.poll();     // the heap now holds k + 1 elements: the minimum is final
        }
        while (!heap.isEmpty()) result[idx++] = heap.poll();      // drain the last k elements
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortKSorted(new int[]{6, 5, 3, 2, 8, 10, 9}, 3)));   // [2, 3, 5, 6, 8, 9, 10]
        System.out.println(Arrays.toString(sortKSorted(new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2)));   // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        System.out.println(Arrays.toString(sortKSorted(new int[]{1, 2, 3}, 0)));                // [1, 2, 3]  (k = 0: already sorted)
        System.out.println(Arrays.toString(sortKSorted(new int[]{3, 2, 1}, 2)));                // [1, 2, 3]
        System.out.println(Arrays.toString(sortKSorted(new int[]{}, 3)));                       // []
        System.out.println(Arrays.toString(sortKSorted(new int[]{5}, 4)));                      // [5]  (k larger than the array)
    }
}
