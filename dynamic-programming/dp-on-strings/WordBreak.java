import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Word Break (LC 139): can s be split into a sequence of dictionary words? */
public class WordBreak {

    // dp[i] = can the prefix s[0..i) be segmented. dp[0] = true. dp[i] = true if some j < i has dp[j] and s[j..i) is a word.
    // Limit j by the longest word length. O(n * L) substring checks (L = max word length), each O(L) to hash => O(n * L^2); O(n) space
    static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String w : wordDict) maxLen = Math.max(maxLen, w.length());
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0 && i - j <= maxLen; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) { dp[i] = true; break; }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));                        // true
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));                   // true  (words can repeat)
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));  // false
        System.out.println(wordBreak("a", Arrays.asList("a")));                                          // true
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));                          // true  (4 + 3)
        System.out.println(wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));                     // true  (a b cd)
        System.out.println(wordBreak("cars", Arrays.asList("car", "ca", "rs")));                         // true  (ca rs)
    }
}
