/** Shortest Common Supersequence (LC 1092): the shortest string that has both str1 and str2 as subsequences */
public class ShortestCommonSupersequence {

    // Length = m + n - LCS (the common part is written once). To BUILD it, walk the LCS table backwards: on a match, write the char once and
    // go diagonally; otherwise write the char of the string we step away from. At the end, flush what remains of either string.
    // O(m*n) time and space
    static String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1)); i--; j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                sb.append(s1.charAt(i - 1)); i--;                  // dropping a char of s1 from the LCS: it still must appear in the answer
            } else {
                sb.append(s2.charAt(j - 1)); j--;
            }
        }
        while (i > 0) sb.append(s1.charAt(--i));
        while (j > 0) sb.append(s2.charAt(--j));
        return sb.reverse().toString();
    }

    static boolean isSubsequence(String small, String big) {
        int k = 0;
        for (int i = 0; i < big.length() && k < small.length(); i++) if (big.charAt(i) == small.charAt(k)) k++;
        return k == small.length();
    }

    public static void main(String[] args) {
        String[][] tests = {{"abac", "cab"}, {"geek", "eke"}, {"abc", "abc"}, {"abc", "def"}, {"", "xyz"}};
        for (String[] t : tests) {
            String r = shortestCommonSupersequence(t[0], t[1]);
            System.out.println(r + " (length " + r.length() + ", valid=" + (isSubsequence(t[0], r) && isSubsequence(t[1], r)) + ")");
        }
        // cabac (5) | gekek (5) | abc (3) | defabc (6) | xyz (3)   - several shortest answers exist; the length and validity are what matter
    }
}
