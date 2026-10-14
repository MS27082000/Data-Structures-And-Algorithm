/** Rod Cutting: a rod of length n; price[i] is the price of a piece of length i + 1. Cut it to maximise the total price */
public class RodCutting {

    // Unbounded knapsack: the "weight" of a piece is its length, the "value" its price, the capacity is n. Pieces can repeat.
    // dp[len] = max over piece p of (price[p-1] + dp[len - p]). O(n^2) time, O(n) space
    static int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];
        for (int len = 1; len <= n; len++) {
            for (int p = 1; p <= len && p <= price.length; p++) {
                dp[len] = Math.max(dp[len], price[p - 1] + dp[len - p]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 8));      // 22  (2 + 6 = 5 + 17)
        System.out.println(cutRod(new int[]{3, 5, 8, 9, 10, 17, 17, 20}, 8));      // 24  (eight pieces of length 1: 8 x 3)
        System.out.println(cutRod(new int[]{2, 5, 7, 8, 10}, 5));                  // 12  (2 + 3 = 5 + 7)
        System.out.println(cutRod(new int[]{4}, 1));                               // 4
        System.out.println(cutRod(new int[]{1, 5}, 0));                            // 0
    }
}
