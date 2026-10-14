import java.util.PriorityQueue;

/** Minimum Cost to Connect Sticks (LC 1167): joining two sticks costs the sum of their lengths. Join them all into one at minimum cost */
public class MinCostToConnectSticks {

    // Huffman-style greedy: always join the TWO SHORTEST sticks (their sum gets re-added to later costs the fewest times).
    // O(n log n) time, O(n) space. long: the total cost can exceed int
    static long connectSticks(int[] sticks) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        for (int s : sticks) heap.offer((long) s);
        long cost = 0;
        while (heap.size() > 1) {
            long joined = heap.poll() + heap.poll();
            cost += joined;
            heap.offer(joined);                                    // the new stick goes back into the pool
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(connectSticks(new int[]{2, 4, 3}));                 // 14  (2+3=5, then 5+4=9)
        System.out.println(connectSticks(new int[]{1, 8, 3, 5}));              // 30
        System.out.println(connectSticks(new int[]{5}));                       // 0
        System.out.println(connectSticks(new int[]{}));                        // 0
        System.out.println(connectSticks(new int[]{1, 1, 1, 1}));              // 8
        System.out.println(connectSticks(new int[]{1000000000, 1000000000, 1000000000}));   // 5000000000 (needs long)
    }
}
