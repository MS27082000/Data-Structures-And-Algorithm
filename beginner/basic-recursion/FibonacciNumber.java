/** Fibonacci number (LC 509): F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) */
public class FibonacciNumber {

    // Plain recursion: two calls per level => O(2^n) time, O(n) stack
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    // Memoised recursion: each n is computed once => O(n) time, O(n) space
    static long fibMemo(int n, long[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        return memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
    }

    // Iterative with two variables: O(n) time, O(1) space
    static long fibIterative(int n) {
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) { long t = a + b; a = b; b = t; }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(fib(10) + " " + fibMemo(10, new long[11]) + " " + fibIterative(10));    // 55 55 55
        System.out.println(fib(0) + " " + fib(1));                                                  // 0 1
        System.out.println(fib(30));                                                                // 832040
        System.out.println(fibMemo(90, new long[91]));                                              // 2880067194370816120
        System.out.println(fibIterative(92));                                                       // 7540113804746346429 (the largest that fits in long)
    }
}
