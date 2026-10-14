/** Longest Common Subsequence (LC 1143) - also prints one LCS */
public class LongestCommonSubsequence {

    // dp[i][j] = LCS of s1[0..i) and s2[0..j). If the chars match: 1 + dp[i-1][j-1]; else max(dp[i-1][j], dp[i][j-1]). O(m*n) time and space
    static int lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    // Space-optimised to two rows (only the length, no string). O(n) space
    static int lcsTwoRows(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] prev = new int[n + 1], cur = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cur[j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + prev[j - 1] : Math.max(prev[j], cur[j - 1]);
            }
            int[] tmp = prev; prev = cur; cur = tmp;
        }
        return prev[n];
    }

    // Build the table, then walk back from dp[m][n]: equal chars => part of the answer, move diagonally; else move toward the larger neighbour.
    static String printLCS(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) { sb.append(s1.charAt(i - 1)); i--; j--; }
            else if (dp[i - 1][j] >= dp[i][j - 1]) i--;
            else j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcde", "ace") + " " + lcsTwoRows("abcde", "ace") + " " + printLCS("abcde", "ace"));   // 3 3 ace
        System.out.println(lcs("abc", "abc"));                         // 3
        System.out.println(lcs("abc", "def"));                         // 0
        System.out.println(lcs("", "abc"));                            // 0
        System.out.println(printLCS("AGGTAB", "GXTXAYB"));             // GTAB
        System.out.println(lcs("bl", "yby"));                          // 1
    }
}
