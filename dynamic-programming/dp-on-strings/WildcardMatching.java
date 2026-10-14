/** Wildcard Matching (LC 44): '?' matches any single char, '*' matches any sequence (including empty). The whole string must match */
public class WildcardMatching {

    // dp[i][j] = does s[0..i) match p[0..j). Base: dp[0][0] = true; dp[0][j] = true only if p[0..j) is all '*'.
    // p[j-1] is '*': dp[i][j-1] (matches empty) || dp[i-1][j] (absorbs one more char of s).
    // p[j-1] is '?' or equal to s[i-1]: dp[i-1][j-1]. O(m*n) time, O(n) space
    static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] prev = new boolean[n + 1], cur = new boolean[n + 1];
        prev[0] = true;
        for (int j = 1; j <= n; j++) prev[j] = prev[j - 1] && p.charAt(j - 1) == '*';
        for (int i = 1; i <= m; i++) {
            cur[0] = false;
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') cur[j] = cur[j - 1] || prev[j];
                else cur[j] = prev[j - 1] && (pc == '?' || pc == s.charAt(i - 1));
            }
            boolean[] tmp = prev; prev = cur; cur = tmp;
        }
        return prev[n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));            // false
        System.out.println(isMatch("aa", "*"));            // true
        System.out.println(isMatch("cb", "?a"));           // false
        System.out.println(isMatch("adceb", "*a*b"));      // true
        System.out.println(isMatch("acdcb", "a*c?b"));     // false
        System.out.println(isMatch("", "***"));            // true
        System.out.println(isMatch("", "?"));              // false
        System.out.println(isMatch("abc", "abc"));         // true
    }
}
