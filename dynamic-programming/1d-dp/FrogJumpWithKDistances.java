import java.util.Arrays;

/** Frog Jump with K Distances: the frog may jump 1..k stones ahead; a jump costs |height[i] - height[j]|. Minimum total energy to reach the last stone */
public class FrogJumpWithKDistances {

    // f(i) = min over j in 1..k of ( f(i - j) + |h[i] - h[i - j]| ), for i - j >= 0. Base f(0) = 0. O(n * k) time, O(n) space
    static int frogJump(int[] h, int k) {
        int n = h.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k && i - j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(h[i] - h[i - j]));
            }
        }
        return dp[n - 1];
    }

    // Top-down with memoisation (same recurrence)
    static int memo(int i, int[] h, int k, int[] dp) {
        if (i == 0) return 0;
        if (dp[i] != -1) return dp[i];
        int best = Integer.MAX_VALUE;
        for (int j = 1; j <= k && i - j >= 0; j++) {
            best = Math.min(best, memo(i - j, h, k, dp) + Math.abs(h[i] - h[i - j]));
        }
        return dp[i] = best;
    }

    public static void main(String[] args) {
        System.out.println(frogJump(new int[]{10, 30, 40, 50, 20}, 3));          // 30  (10 -> 30 costs 20, then 30 -> 20 jumping 3 stones from index 1 to 4 costs 10)
        System.out.println(frogJump(new int[]{10, 20, 10}, 1));                  // 20  (k = 1: forced to walk)
        System.out.println(frogJump(new int[]{10, 20, 10}, 2));                  // 0   (jump 0 -> 2)
        System.out.println(frogJump(new int[]{3}, 5));                           // 0
        System.out.println(frogJump(new int[]{10, 5, 20, 30, 40, 10}, 4));       // 10  (10 -> 5 costs 5, then index 1 -> 5 (5 -> 10) costs 5)
        int[] h = {10, 30, 40, 50, 20};
        int[] dp = new int[h.length];
        Arrays.fill(dp, -1);
        System.out.println(memo(h.length - 1, h, 3, dp));                        // same as the first line
    }
}
