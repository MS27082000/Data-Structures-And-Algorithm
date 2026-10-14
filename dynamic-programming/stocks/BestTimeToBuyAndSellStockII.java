/** Best Time to Buy and Sell Stock II (LC 122): UNLIMITED transactions (hold at most one share at a time). Maximum profit */
public class BestTimeToBuyAndSellStockII {

    // Greedy: add EVERY upward step (prices[i] - prices[i-1] when positive). Any profitable multi-day trade equals the sum of its daily gains.
    // O(n) time, O(1) space
    static int maxProfitGreedy(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    // DP view (this is the framework for every stock problem): two states per day - HOLDING a share or NOT holding one.
    //   notHold = max(notHold, hold + price)  (sell today)      hold = max(hold, notHold - price)  (buy today)
    static int maxProfitDP(int[] prices) {
        int notHold = 0, hold = Integer.MIN_VALUE / 2;
        for (int p : prices) {
            int newNotHold = Math.max(notHold, hold + p);
            int newHold = Math.max(hold, notHold - p);
            notHold = newNotHold;
            hold = newHold;
        }
        return notHold;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitGreedy(new int[]{7, 1, 5, 3, 6, 4}) + " " + maxProfitDP(new int[]{7, 1, 5, 3, 6, 4}));   // 7 7   (1->5, 3->6)
        System.out.println(maxProfitGreedy(new int[]{1, 2, 3, 4, 5}) + " " + maxProfitDP(new int[]{1, 2, 3, 4, 5}));         // 4 4
        System.out.println(maxProfitGreedy(new int[]{7, 6, 4, 3, 1}) + " " + maxProfitDP(new int[]{7, 6, 4, 3, 1}));         // 0 0
        System.out.println(maxProfitGreedy(new int[]{5}));                                                                    // 0
        System.out.println(maxProfitGreedy(new int[]{1, 5, 1, 5}) + " " + maxProfitDP(new int[]{1, 5, 1, 5}));               // 8 8
    }
}
