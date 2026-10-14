import java.util.PriorityQueue;
import java.util.Random;

/** Kth Largest Element in an Array (LC 215): the k-th largest in sorted order (duplicates count) */
public class KthLargestInArray {

    // Min-heap of size k: it always holds the k largest seen so far, and its root is the k-th largest.
    // O(n log k) time, O(k) space
    static int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : nums) {
            minHeap.offer(x);
            if (minHeap.size() > k) minHeap.poll();            // drop the smallest: it can't be among the top k
        }
        return minHeap.peek();
    }

    // Quickselect: partition around a pivot; the answer is at index n - k of the sorted order, so recurse into ONE side only.
    // O(n) average, O(n^2) worst case (mitigated by a random pivot), O(1) space. Modifies a copy of the array
    static int findKthLargestQuickselect(int[] nums, int k) {
        int[] a = nums.clone();
        int target = a.length - k;
        int lo = 0, hi = a.length - 1;
        Random rnd = new Random();
        while (lo < hi) {
            int p = partition(a, lo, hi, lo + rnd.nextInt(hi - lo + 1));
            if (p == target) return a[p];
            if (p < target) lo = p + 1;
            else hi = p - 1;
        }
        return a[lo];
    }

    private static int partition(int[] a, int lo, int hi, int pivotIndex) {
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, hi);
        int store = lo;
        for (int i = lo; i < hi; i++) {
            if (a[i] < pivot) swap(a, i, store++);
        }
        swap(a, store, hi);                                    // pivot lands in its final sorted position
        return store;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargestHeap(a, 2) + " " + findKthLargestQuickselect(a, 2));     // 5 5
        int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargestHeap(b, 4) + " " + findKthLargestQuickselect(b, 4));     // 4 4
        System.out.println(findKthLargestHeap(new int[]{1}, 1));                                   // 1
        System.out.println(findKthLargestHeap(new int[]{7, 7, 7}, 2));                             // 7
        System.out.println(findKthLargestQuickselect(new int[]{-1, -5, -3}, 3));                   // -5
        System.out.println(findKthLargestHeap(a, 6) + " " + findKthLargestQuickselect(a, 6));      // 1 1 (k = n: the minimum)
    }
}
