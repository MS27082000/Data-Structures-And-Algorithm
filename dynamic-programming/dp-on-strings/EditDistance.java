/** Edit Distance (LC 72): min operations (insert, delete, replace one char) to convert word1 into word2 */
public class EditDistance {

    // dp[i][j] = edit distance between word1[0..i) and word2[0..j). Base: dp[i][0] = i (delete all), dp[0][j] = j (insert all).
    // Equal chars: dp[i-1][j-1]. Else 1 + min(dp[i-1][j] delete, dp[i][j-1] insert, dp[i-1][j-1] replace). O(m*n) time, O(n) space
    static int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] prev = new int[n + 1], cur = new int[n + 1];
        for (int j = 0; j <= n; j++) prev[j] = j;
        for (int i = 1; i <= m; i++) {
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) cur[j] = prev[j - 1];
                else cur[j] = 1 + Math.min(prev[j - 1], Math.min(prev[j], cur[j - 1]));
            }
            int[] tmp = prev; prev = cur; cur = tmp;
        }
        return prev[n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));              // 3
        System.out.println(minDistance("intention", "execution"));    // 5
        System.out.println(minDistance("", "abc"));                   // 3
        System.out.println(minDistance("abc", ""));                   // 3
        System.out.println(minDistance("same", "same"));              // 0
        System.out.println(minDistance("a", "b"));                    // 1
    }
}
