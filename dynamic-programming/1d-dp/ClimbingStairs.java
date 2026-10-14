import java.util.Arrays;

/** Climbing Stairs (LC 70): n steps, climb 1 or 2 at a time. In how many distinct ways can you reach the top? */
public class ClimbingStairs {

    // State: ways(i) = number of ways to reach step i. Recurrence: ways(i) = ways(i-1) + ways(i-2) (arrive from one or two steps below).
    // Base: ways(0) = 1, ways(1) = 1. It IS the Fibonacci sequence.
    static int memo(int n, int[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = memo(n - 1, dp) + memo(n - 2, dp);
    }

    static int tabulation(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // O(n) time, O(1) space
    static int climbStairs(int n) {
        int prev2 = 1, prev = 1;
        for (int i = 2; i <= n; i++) {
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));                       // 2  (1+1, 2)
        System.out.println(climbStairs(3));                       // 3  (1+1+1, 1+2, 2+1)
        System.out.println(climbStairs(5));                       // 8
        System.out.println(climbStairs(45));                      // 1836311903  (the largest n whose answer fits in int)
        int[] dp = new int[11];
        Arrays.fill(dp, -1);
        System.out.println(memo(10, dp) + " " + tabulation(10) + " " + climbStairs(10));   // 89 89 89
        System.out.println(climbStairs(1) + " " + climbStairs(0)); // 1 1
    }
}
