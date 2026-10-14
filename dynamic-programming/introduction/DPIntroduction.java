import java.util.Arrays;

/** Introduction to DP using Fibonacci: the same problem solved four ways, from exponential to O(n) time and O(1) space */
public class DPIntroduction {

    static long calls;                                                  // counts recursive calls to SHOW the repeated work

    // 1) Plain recursion: fib(n) = fib(n-1) + fib(n-2). The SAME subproblems are solved again and again => O(2^n) time
    static long fibNaive(int n) {
        calls++;
        if (n <= 1) return n;
        return fibNaive(n - 1) + fibNaive(n - 2);
    }

    // 2) Memoisation (top-down DP): recursion + a cache. Each n is computed ONCE => O(n) time, O(n) space (+ O(n) stack)
    static long fibMemo(int n, long[] memo) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];                              // already solved: reuse
        return memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    }

    // 3) Tabulation (bottom-up DP): fill a table from the base cases upwards. No recursion => O(n) time, O(n) space
    static long fibTab(int n) {
        if (n <= 1) return n;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // 4) Space optimisation: dp[i] needs only the previous TWO values => O(n) time, O(1) space
    static long fibOptimised(int n) {
        if (n <= 1) return n;
        long prev2 = 0, prev = 1;
        for (int i = 2; i <= n; i++) {
            long cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(fibTab(10) + " " + fibOptimised(10));        // 55 55
        calls = 0;
        System.out.println(fibNaive(20) + " calls=" + calls);           // 6765 calls=21891  (exponential growth)
        calls = 0;
        System.out.println(fibNaive(30) + " calls=" + calls);           // 832040 calls=2692537
        long[] memo = new long[51];
        Arrays.fill(memo, -1);
        System.out.println(fibMemo(50, memo));                          // 12586269025  (instant; naive would take forever)
        System.out.println(fibTab(50) + " " + fibOptimised(50));        // 12586269025 12586269025
        System.out.println(fibOptimised(0) + " " + fibOptimised(1));    // 0 1
        // DP recipe: 1) define the state  2) write the recurrence  3) base cases  4) order of computation  5) optimise space
    }
}
