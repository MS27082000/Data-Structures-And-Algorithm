/** Burst Balloons (LC 312): bursting balloon i earns nums[i-1] * nums[i] * nums[i+1] (neighbours at that moment; outside = 1). Maximise coins */
public class BurstBalloons {

    // Think in REVERSE: let k be the LAST balloon burst in the range (i, j). Then its neighbours are the borders i and j (not yet burst), and the
    // left and right parts are independent. dp[i][j] = max over k of dp[i][k] + dp[k][j] + a[i]*a[k]*a[j], with a = [1, nums..., 1].
    // O(n^3) time, O(n^2) space
    static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = a[n + 1] = 1;
        for (int i = 0; i < n; i++) a[i + 1] = nums[i];
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n + 1; len++) {                // gap between borders i and j
            for (int i = 0; i + len <= n + 1; i++) {
                int j = i + len;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + a[i] * a[k] * a[j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));        // 167
        System.out.println(maxCoins(new int[]{1, 5}));              // 10
        System.out.println(maxCoins(new int[]{7}));                 // 7
        System.out.println(maxCoins(new int[]{}));                  // 0
        System.out.println(maxCoins(new int[]{9, 76, 64, 21}));     // 116718
    }
}
