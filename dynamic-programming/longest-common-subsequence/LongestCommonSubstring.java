/** Longest Common Substring (contiguous!) of two strings (GfG; LC 718 is the array version) */
public class LongestCommonSubstring {

    // dp[i][j] = length of the common substring ENDING at s1[i-1] and s2[j-1]. If the chars match: 1 + dp[i-1][j-1]; else it resets to 0
    // (the run is broken). The answer is the maximum cell anywhere, not the corner. O(m*n) time, O(n) space with a rolling row
    static int longestCommonSubstring(String s1, String s2) {
        int m = s1.length(), n = s2.length(), best = 0;
        int[] prev = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int[] cur = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cur[j] = 1 + prev[j - 1];
                    best = Math.max(best, cur[j]);
                }
            }
            prev = cur;
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstring("abcde", "abfce"));       // 2  ("ab")
        System.out.println(longestCommonSubstring("abcdxyz", "xyzabcd"));   // 4  ("abcd")
        System.out.println(longestCommonSubstring("abc", "def"));           // 0
        System.out.println(longestCommonSubstring("aaaa", "aa"));           // 2
        System.out.println(longestCommonSubstring("", "abc"));              // 0
        System.out.println(longestCommonSubstring("GeeksforGeeks", "GeeksQuiz"));   // 5  ("Geeks")
    }
}
