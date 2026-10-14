/** Best Time to Buy and Sell Stock (LC 121): at most ONE transaction. Maximum profit (0 if no profit is possible) */
public class BestTimeToBuyAndSellStock {

    // For each day treat it as the SELL day: the best buy day is the cheapest price seen before it. Track the running minimum and the
    // best profit. O(n) time, O(1) space
    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            best = Math.max(best, p - minPrice);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));      // 5  (buy at 1, sell at 6)
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));         // 0  (prices only fall: do nothing)
        System.out.println(maxProfit(new int[]{1}));                     // 0
        System.out.println(maxProfit(new int[]{}));                      // 0
        System.out.println(maxProfit(new int[]{2, 4, 1}));               // 2  (you cannot sell before you buy: 1 then 4 is not allowed)
        System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 4
    }
}
