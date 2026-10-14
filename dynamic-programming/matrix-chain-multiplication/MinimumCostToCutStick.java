import java.util.Arrays;

/** Minimum Cost to Cut a Stick (LC 1547): cutting a piece costs its current length. Make all cuts in the best order */
public class MinimumCostToCutStick {

    // Add the ends 0 and n to the sorted cuts: c[0..m+1]. dp[i][j] = min cost to make all cuts strictly between c[i] and c[j]. Choose k = the FIRST
    // cut in that piece: cost = (c[j] - c[i]) + dp[i][k] + dp[k][j]. Same shape as Burst Balloons. O(m^3) time, O(m^2) space
    static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] c = new int[m + 2];
        System.arraycopy(cuts, 0, c, 1, m);
        c[m + 1] = n;
        Arrays.sort(c);
        int[][] dp = new int[m + 2][m + 2];
        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i + len <= m + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + c[j] - c[i]);
                }
            }
        }
        return dp[0][m + 1];
    }

    public static void main(String[] args) {
        System.out.println(minCost(7, new int[]{1, 3, 4, 5}));        // 16
        System.out.println(minCost(9, new int[]{5, 6, 1, 4, 2}));     // 22
        System.out.println(minCost(10, new int[]{5}));                // 10
        System.out.println(minCost(10, new int[]{}));                 // 0
        System.out.println(minCost(4, new int[]{1, 2, 3}));           // 8
    }
}
