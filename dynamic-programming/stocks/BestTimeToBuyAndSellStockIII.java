/** Best Time to Buy and Sell Stock III (LC 123): AT MOST TWO transactions */
public class BestTimeToBuyAndSellStockIII {

    // Four rolling states, updated day by day (each uses the PREVIOUS state of the earlier step in the same day):
    //   buy1  = best balance after the 1st buy        sell1 = best profit after the 1st sell
    //   buy2  = best balance after the 2nd buy        sell2 = best profit after the 2nd sell
    // O(n) time, O(1) space
    static int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE / 2, sell1 = 0, buy2 = Integer.MIN_VALUE / 2, sell2 = 0;
        for (int p : prices) {
            buy1 = Math.max(buy1, -p);
            sell1 = Math.max(sell1, buy1 + p);
            buy2 = Math.max(buy2, sell1 - p);                     // the second buy is paid with the profit of the first sale
            sell2 = Math.max(sell2, buy2 + p);
        }
        return sell2;
    }

    // Straightforward table: dp[i][hold][transactionsLeft] solved top-down (shows the general idea used by Stock IV)
    static int memo(int i, int hold, int cap, int[] prices, int[][][] dp) {
        if (i == prices.length || cap == 0) return 0;
        if (dp[i][hold][cap] != -1) return dp[i][hold][cap];
        int res;
        if (hold == 1) {
            res = Math.max(memo(i + 1, 1, cap, prices, dp), prices[i] + memo(i + 1, 0, cap - 1, prices, dp));   // keep, or sell (a transaction completes)
        } else {
            res = Math.max(memo(i + 1, 0, cap, prices, dp), -prices[i] + memo(i + 1, 1, cap, prices, dp));       // skip, or buy
        }
        return dp[i][hold][cap] = res;
    }

    static int maxProfitMemo(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int[][] a : dp) for (int[] b : a) java.util.Arrays.fill(b, -1);
        return memo(0, 0, 2, prices, dp);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}) + " " + maxProfitMemo(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));   // 6 6  (0->3 = 3, then 1->4 = 3)
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}) + " " + maxProfitMemo(new int[]{1, 2, 3, 4, 5}));                       // 4 4  (one long transaction)
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}) + " " + maxProfitMemo(new int[]{7, 6, 4, 3, 1}));                       // 0 0
        System.out.println(maxProfit(new int[]{1}));                                                                                   // 0
        System.out.println(maxProfit(new int[]{1, 4, 2, 7}));                                                                          // 8  (1->4, 2->7)
    }
}
