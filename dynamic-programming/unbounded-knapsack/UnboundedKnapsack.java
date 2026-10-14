/** Unbounded Knapsack: like 0/1 knapsack but every item has an unlimited supply */
public class UnboundedKnapsack {

    // The only change from 0/1: iterate capacity UPWARDS so the same item can be picked again (dp[w - wt] may already include it).
    // O(n * W) time, O(W) space
    static int unboundedKnapsack(int[] wt, int[] val, int W) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < wt.length; i++) {
            for (int w = wt[i]; w <= W; w++) {
                dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(new int[]{2, 4, 6}, new int[]{5, 11, 13}, 10));    // 27  (4 + 4 + 2 = 11 + 11 + 5)
        System.out.println(unboundedKnapsack(new int[]{1, 3, 4, 5}, new int[]{10, 40, 50, 70}, 8));   // 110 (weights 3 + 5 = 40 + 70; 4 + 4 gives only 100)
        System.out.println(unboundedKnapsack(new int[]{5}, new int[]{10}, 4));                    // 0
        System.out.println(unboundedKnapsack(new int[]{1}, new int[]{3}, 7));                     // 21
        System.out.println(unboundedKnapsack(new int[]{3, 7}, new int[]{4, 10}, 0));              // 0
    }
}
