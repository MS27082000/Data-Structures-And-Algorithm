import java.util.Arrays;

/** Minimum Coins / Coin Change (LC 322): fewest coins (unlimited supply of each) to make `amount`; -1 if impossible */
public class MinimumCoins {

    // dp[a] = fewest coins to make amount a. dp[0] = 0. dp[a] = 1 + min(dp[a - coin]). "Unbounded": a coin can be reused, so a simple
    // forward loop over amounts works. O(amount * coins) time, O(amount) space
    static int coinChange(int[] coins, int amount) {
        int INF = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (c <= a) dp[a] = Math.min(dp[a], dp[a - c] + 1);
            }
        }
        return dp[amount] >= INF ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));       // 3  (5 + 5 + 1)
        System.out.println(coinChange(new int[]{2}, 3));              // -1
        System.out.println(coinChange(new int[]{1}, 0));              // 0
        System.out.println(coinChange(new int[]{186, 419, 83, 408}, 6249));   // 20
        System.out.println(coinChange(new int[]{1, 3, 4}, 6));        // 2  (3 + 3; greedy 4 + 1 + 1 gives 3 - greedy FAILS here)
    }
}
