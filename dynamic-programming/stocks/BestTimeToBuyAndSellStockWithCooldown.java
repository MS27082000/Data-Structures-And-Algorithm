/** Best Time to Buy and Sell Stock with Cooldown (LC 309): unlimited transactions, but after SELLING you must wait one day before buying again */
public class BestTimeToBuyAndSellStockWithCooldown {

    // Three states each day:
    //   hold   = best balance holding a share                       -> max(hold, rest - price)       (buy only from a "rest" day)
    //   sold   = best balance having just sold TODAY (cooldown next) -> hold + price
    //   rest   = best balance not holding and free to buy           -> max(rest, previous sold)
    // O(n) time, O(1) space
    static int maxProfit(int[] prices) {
        int hold = Integer.MIN_VALUE / 2, sold = 0, rest = 0;
        for (int p : prices) {
            int prevSold = sold;
            sold = hold + p;
            hold = Math.max(hold, rest - p);
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));            // 3  (buy 1, sell 3, cooldown, buy 0, sell 2)
        System.out.println(maxProfit(new int[]{1}));                        // 0
        System.out.println(maxProfit(new int[]{1, 2, 4}));                  // 3
        System.out.println(maxProfit(new int[]{2, 1}));                     // 0
        System.out.println(maxProfit(new int[]{6, 1, 3, 2, 4, 7}));         // 6  (buy at 1, sell at 7)
    }
}
