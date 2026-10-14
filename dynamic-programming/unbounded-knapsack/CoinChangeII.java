/** Coin Change II (LC 518): number of COMBINATIONS (order does not matter) of coins that make `amount`; unlimited supply */
public class CoinChangeII {

    // dp[a] = ways to make a. Loop COINS OUTSIDE and amounts inside: each coin type is considered once in a fixed order, so [1,2] and [2,1]
    // are not counted twice (combinations). Swapping the loops would count permutations (that is "Combination Sum IV").
    // O(coins * amount) time, O(amount) space
    static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c : coins) {
            for (int a = c; a <= amount; a++) dp[a] += dp[a - c];
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));        // 4  (5 | 2+2+1 | 2+1+1+1 | 1x5)
        System.out.println(change(3, new int[]{2}));              // 0
        System.out.println(change(10, new int[]{10}));            // 1
        System.out.println(change(0, new int[]{7}));              // 1  (use no coins)
        System.out.println(change(4, new int[]{1, 2, 3}));        // 4
    }
}
