/** 0/1 Knapsack: n items with weight[i] and value[i]; a bag of capacity W. Each item is taken at most once. Maximise the total value */
public class ZeroOneKnapsack {

    // dp[w] = best value with capacity w. For each item iterate w DOWNWARDS (so the item is not reused): dp[w] = max(dp[w], dp[w - wt] + val).
    // O(n * W) time, O(W) space
    static int knapsack(int[] wt, int[] val, int W) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < wt.length; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }
        return dp[W];
    }

    // 2D table (easier to explain and to print the chosen items): dp[i][w] = best using the first i items with capacity w
    static int knapsack2D(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i - 1][w];                                                       // skip item i
                if (wt[i - 1] <= w) dp[i][w] = Math.max(dp[i][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);   // take it
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 5}, val = {5, 4, 8, 6};
        System.out.println(knapsack(wt, val, 5) + " " + knapsack2D(wt, val, 5));                               // 13 13  (weights 1 + 4)
        System.out.println(knapsack(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50));                        // 220 (20 + 30)
        System.out.println(knapsack(new int[]{3}, new int[]{100}, 2));                                           // 0   (the only item does not fit)
        System.out.println(knapsack(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7));                           // 9   (3 + 4)
        System.out.println(knapsack(new int[]{2, 3}, new int[]{10, 20}, 0));                                     // 0
    }
}
