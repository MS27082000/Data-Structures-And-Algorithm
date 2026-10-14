/** Best Time to Buy and Sell Stock IV (LC 188): AT MOST k transactions */
public class BestTimeToBuyAndSellStockIV {

    // buy[t] = best balance while holding a share during the t-th transaction; sell[t] = best profit after completing t transactions.
    // O(n * k) time, O(k) space. If k >= n / 2 the limit never binds (a transaction needs 2 days) => same as unlimited transactions
    static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 2 || k == 0) return 0;
        if (k >= n / 2) {
            int profit = 0;                                          // unlimited: sum every upward step
            for (int i = 1; i < n; i++) if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
            return profit;
        }
        int[] buy = new int[k + 1], sell = new int[k + 1];
        java.util.Arrays.fill(buy, Integer.MIN_VALUE / 2);
        for (int p : prices) {
            for (int t = 1; t <= k; t++) {
                buy[t] = Math.max(buy[t], sell[t - 1] - p);          // start transaction t using the profit of t-1 transactions
                sell[t] = Math.max(sell[t], buy[t] + p);
            }
        }
        return sell[k];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2, 4, 1}));                     // 2
        System.out.println(maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));            // 7  (2->6 = 4, 0->3 = 3)
        System.out.println(maxProfit(1, new int[]{3, 2, 6, 5, 0, 3}));            // 4
        System.out.println(maxProfit(0, new int[]{1, 5}));                        // 0
        System.out.println(maxProfit(100, new int[]{1, 5, 2, 8}));                // 10 (k is huge: unlimited)
        System.out.println(maxProfit(3, new int[]{1, 2, 3, 4, 5}));               // 4
    }
}
