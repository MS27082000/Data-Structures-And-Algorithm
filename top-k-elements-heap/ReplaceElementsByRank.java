import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/** Replace Elements by Their Rank: the smallest value gets rank 1; equal values share the same rank (rank counts DISTINCT smaller values + 1) */
public class ReplaceElementsByRank {

    // Heap version: poll values in ascending order; bump the rank only when the value changes. O(n log n) time, O(n) space
    static int[] rankWithHeap(int[] a) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));   // {value, index}
        for (int i = 0; i < a.length; i++) heap.offer(new int[]{a[i], i});
        int[] res = new int[a.length];
        int rank = 0;
        Integer prev = null;
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            if (prev == null || cur[0] != prev) rank++;       // a new distinct value
            res[cur[1]] = rank;
            prev = cur[0];
        }
        return res;
    }

    // Sort-based version: sort a copy, give each distinct value its rank in a map, then look every element up. O(n log n)
    static int[] rankWithSort(int[] a) {
        int[] sorted = a.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int x : sorted) rank.putIfAbsent(x, rank.size() + 1);
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) res[i] = rank.get(a[i]);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rankWithHeap(new int[]{20, 15, 26, 2, 98, 6})));   // [4, 3, 5, 1, 6, 2]
        System.out.println(Arrays.toString(rankWithHeap(new int[]{1, 5, 8, 15, 8, 25, 9})));  // [1, 2, 3, 5, 3, 6, 4]
        System.out.println(Arrays.toString(rankWithSort(new int[]{40, 10, 20, 30})));          // [4, 1, 2, 3]
        System.out.println(Arrays.toString(rankWithSort(new int[]{100, 100, 100})));           // [1, 1, 1]
        System.out.println(Arrays.toString(rankWithHeap(new int[]{-5, 0, -5, 7})));            // [1, 2, 1, 3]
        System.out.println(Arrays.toString(rankWithHeap(new int[]{})));                        // []
    }
}
