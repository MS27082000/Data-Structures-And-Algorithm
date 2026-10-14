import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/** Top K Frequent Elements (LC 347): the k most frequent values (any order) */
public class TopKFrequentElements {

    // Count with a HashMap, then keep a MIN-heap of size k ordered by frequency. O(n log k) time, O(n) space
    static int[] topKFrequentHeap(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            heap.offer(e);
            if (heap.size() > k) heap.poll();                   // drop the least frequent of the k + 1
        }
        int[] res = new int[heap.size()];
        for (int i = res.length - 1; i >= 0; i--) res[i] = heap.poll().getKey();
        return res;
    }

    // Bucket sort: a frequency is at most n, so bucket[f] = the values that occur f times; read buckets from the highest.
    // O(n) time, O(n) space
    static int[] topKFrequentBucket(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);
        List<List<Integer>> bucket = new ArrayList<>();          // bucket.get(f) = values that occur exactly f times
        for (int f = 0; f <= nums.length; f++) bucket.add(new ArrayList<>());
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) bucket.get(e.getValue()).add(e.getKey());
        int[] res = new int[Math.min(k, freq.size())];
        int idx = 0;
        for (int f = bucket.size() - 1; f >= 1 && idx < res.length; f--) {
            for (int v : bucket.get(f)) {
                if (idx == res.length) break;
                res[idx++] = v;
            }
        }
        return res;
    }

    static String sorted(int[] a) {                              // the result order is unspecified, so sort it before printing
        int[] c = a.clone();
        Arrays.sort(c);
        return Arrays.toString(c);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        System.out.println(sorted(topKFrequentHeap(a, 2)) + " " + sorted(topKFrequentBucket(a, 2)));   // [1, 2] [1, 2]
        System.out.println(sorted(topKFrequentHeap(new int[]{1}, 1)));                                  // [1]
        int[] b = {4, 4, 4, 5, 5, 6, 6, 6, 6, 7};
        System.out.println(sorted(topKFrequentHeap(b, 3)) + " " + sorted(topKFrequentBucket(b, 3)));   // [4, 5, 6] [4, 5, 6]
        System.out.println(sorted(topKFrequentBucket(new int[]{-1, -1, 2, 2, 2, 3}, 1)));               // [2]
        System.out.println(sorted(topKFrequentHeap(new int[]{1, 2}, 2)));                               // [1, 2]
    }
}
