/** Partition a Set Into Two Subsets With Minimum Absolute Sum Difference (like LC 2035 without the equal-size rule) */
public class MinimumSubsetSumDifference {

    // If one subset sums to s1, the other is total - s1 and the difference is |total - 2*s1|. So find every reachable subset sum s1 <= total/2
    // (subset-sum table) and take the largest one. O(n * total) time, O(total) space
    static int minDifference(int[] arr) {
        int total = 0;
        for (int x : arr) total += x;
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        for (int x : arr) {
            for (int s = total; s >= x; s--) dp[s] |= dp[s - x];
        }
        int best = Integer.MAX_VALUE;
        for (int s = 0; s <= total / 2; s++) {
            if (dp[s]) best = Math.min(best, total - 2 * s);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(minDifference(new int[]{1, 6, 11, 5}));        // 1  (12 vs 11)
        System.out.println(minDifference(new int[]{1, 2, 3, 4}));         // 0  (1 + 4 vs 2 + 3)
        System.out.println(minDifference(new int[]{8, 6, 5}));            // 3  (8 vs 11)
        System.out.println(minDifference(new int[]{10}));                 // 10 (the other subset is empty)
        System.out.println(minDifference(new int[]{3, 9, 7, 3}));         // 2  (3+9 = 12 vs 7+3 = 10)
        System.out.println(minDifference(new int[]{0, 0}));               // 0
    }
}
