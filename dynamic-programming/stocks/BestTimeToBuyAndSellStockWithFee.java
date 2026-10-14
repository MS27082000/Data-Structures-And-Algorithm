/** Best Time to Buy and Sell Stock with Transaction Fee (LC 714): unlimited transactions; pay `fee` for each transaction (charged on the sale) */
public class BestTimeToBuyAndSellStockWithFee {

    // Two states: cash (not holding) and hold. Selling pays the fee. O(n) time, O(1) space
    //   cash = max(cash, hold + price - fee)      hold = max(hold, cash - price)
    static int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = Integer.MIN_VALUE / 2;
        for (int p : prices) {
            int newCash = Math.max(cash, hold + p - fee);
            int newHold = Math.max(hold, cash - p);
            cash = newCash;
            hold = newHold;
        }
        return cash;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));      // 8  (buy 1, sell 8: 7 - 2 = 5; buy 4, sell 9: 5 - 2 = 3)
        System.out.println(maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));     // 6
        System.out.println(maxProfit(new int[]{1, 2, 3}, 10));              // 0  (the fee exceeds any gain)
        System.out.println(maxProfit(new int[]{5}, 1));                     // 0
        System.out.println(maxProfit(new int[]{1, 4, 6, 2, 8, 3, 10, 14}, 3)); // 13
    }
}
