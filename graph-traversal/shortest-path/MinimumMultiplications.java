import java.util.ArrayDeque;
import java.util.Queue;

/** Minimum Multiplications to Reach End: start with `start`; in one step multiply the current number by any value of arr[] and take it
 *  modulo 100000. Fewest steps to reach `end`, or -1. */
public class MinimumMultiplications {

    private static final int MOD = 100000;

    // The numbers 0..99999 are the NODES of an implicit graph and "multiply by arr[i]" gives the edges. Every step costs 1, so BFS.
    // At most 100000 states: O(100000 * arr.length) time, O(100000) space
    static int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0;
        int[] steps = new int[MOD];
        java.util.Arrays.fill(steps, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start % MOD);
        steps[start % MOD] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int m : arr) {
                int v = (int) ((long) u * m % MOD);                // long: u * m can exceed int
                if (steps[v] == -1) {
                    steps[v] = steps[u] + 1;
                    if (v == end) return steps[v];
                    q.offer(v);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumMultiplications(new int[]{2, 5, 7}, 3, 30));              // 2  (3*2=6, 6*5=30)
        System.out.println(minimumMultiplications(new int[]{3, 4, 65}, 7, 66175));          // 4
        System.out.println(minimumMultiplications(new int[]{2}, 1, 1));                     // 0
        System.out.println(minimumMultiplications(new int[]{2}, 2, 3));                     // -1  (only powers of two are reachable)
        System.out.println(minimumMultiplications(new int[]{10}, 1, 0));                    // 5  (1, 10, 100, 1000, 10000, 100000 mod 100000 = 0)
    }
}
