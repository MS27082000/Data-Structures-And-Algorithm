/** Distinct Subsequences (LC 115): number of distinct subsequences of s that equal t */
public class DistinctSubsequences {

    // dp[i][j] = ways for s[0..i) to form t[0..j). dp[i][0] = 1 (the empty target is always formed once by taking nothing).
    // If s[i-1] == t[j-1]: either use it (dp[i-1][j-1]) or skip it (dp[i-1][j]); else only skip. O(m*n) time, O(n) space
    // Iterate j DOWNWARDS in the 1D version so dp[j-1] still refers to the previous row. Use long: counts can be huge in the general case.
    static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) return 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = Math.min(i, n); j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[j] += dp[j - 1];
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));        // 3
        System.out.println(numDistinct("babgbag", "bag"));           // 5
        System.out.println(numDistinct("abc", "abcd"));              // 0  (t is longer than s)
        System.out.println(numDistinct("aaa", "a"));                 // 3
        System.out.println(numDistinct("abc", ""));                  // 1
        System.out.println(numDistinct("aaaa", "aa"));               // 6
    }
}
