import java.util.PriorityQueue;

/** Kth Largest Element in a Stream (LC 703): after every add(), return the k-th largest element seen so far */
public class KthLargestInStream {

    private final int k;
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();    // holds the k largest elements; root = k-th largest

    KthLargestInStream(int k, int[] nums) {
        this.k = k;
        for (int x : nums) add(x);
    }

    // O(log k) per call, O(k) space
    int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) minHeap.poll();                // evict the smallest of the k+1
        return minHeap.peek();                                 // assumes at least k elements have been added (LeetCode guarantees it)
    }

    public static void main(String[] args) {
        KthLargestInStream s = new KthLargestInStream(3, new int[]{4, 5, 8, 2});
        System.out.println(s.add(3));       // 4
        System.out.println(s.add(5));       // 5
        System.out.println(s.add(10));      // 5
        System.out.println(s.add(9));       // 8
        System.out.println(s.add(4));       // 8
        KthLargestInStream one = new KthLargestInStream(1, new int[]{});
        System.out.println(one.add(-3) + " " + one.add(-2) + " " + one.add(-4));   // -3 -2 -2  (k = 1 tracks the maximum)
    }
}
