/** Longest Palindromic Subsequence (LC 516) */
public class LongestPalindromicSubsequence {

    // A palindrome reads the same reversed, so LPS(s) = LCS(s, reverse(s)). O(n^2) time, O(n) space
    static int lps(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[] prev = new int[n + 1], cur = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cur[j] = s.charAt(i - 1) == r.charAt(j - 1) ? 1 + prev[j - 1] : Math.max(prev[j], cur[j - 1]);
            }
            int[] tmp = prev; prev = cur; cur = tmp;
        }
        return prev[n];
    }

    // Direct interval DP: dp[i][j] = LPS of s[i..j]. Equal ends: 2 + dp[i+1][j-1]; else max(dp[i+1][j], dp[i][j-1]). O(n^2) time and space
    static int lpsInterval(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = 2 + (i + 1 <= j - 1 ? dp[i + 1][j - 1] : 0);
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return n == 0 ? 0 : dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(lps("bbbab") + " " + lpsInterval("bbbab"));       // 4 4  ("bbbb")
        System.out.println(lps("cbbd") + " " + lpsInterval("cbbd"));         // 2 2  ("bb")
        System.out.println(lps("a"));                                         // 1
        System.out.println(lps("abcd"));                                      // 1
        System.out.println(lps("agbcba"));                                    // 5  ("abcba")
        System.out.println(lps(""));                                          // 0
    }
}
