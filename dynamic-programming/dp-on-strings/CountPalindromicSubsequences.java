/** Count Palindromic Subsequences (GfG "Count Palindromic Subsequences": count all non-empty palindromic subsequences, counted by position) */
public class CountPalindromicSubsequences {

    // dp[i][j] = number of palindromic subsequences inside s[i..j].
    //   dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]           (inclusion-exclusion; the two overlap in s[i+1..j-1])
    //   if s[i] == s[j]: add dp[i+1][j-1] + 1                        (wrap every inner palindrome with s[i], s[j]; +1 for the pair "s[i]s[j]" itself)
    // Single char: 1. Counts different index sets separately even when they give the same text. O(n^2) time and space
    static int countPS(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int inner = len > 2 ? dp[i + 1][j - 1] : 0;
                dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - inner;
                if (s.charAt(i) == s.charAt(j)) dp[i][j] += inner + 1;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countPS("abcd"));        // 4   (a, b, c, d)
        System.out.println(countPS("aab"));         // 4   (a, a, b, aa)
        System.out.println(countPS("aaa"));         // 7   (a x3, aa x3, aaa)
        System.out.println(countPS("a"));           // 1
        System.out.println(countPS("abcba"));       // 13
        System.out.println(countPS(""));            // 0
    }
}
