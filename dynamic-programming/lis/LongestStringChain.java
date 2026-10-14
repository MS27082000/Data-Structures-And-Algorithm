import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Longest String Chain (LC 1048): w1 -> w2 if w2 is w1 with exactly one letter inserted anywhere. Longest chain of words */
public class LongestStringChain {

    // Sort by length. dp[word] = longest chain ending at word = 1 + max(dp[word with one char removed]) over all single-char deletions that are
    // in the map. O(n * L^2) time (L = word length: L deletions, each building a string of length L), O(n * L) space
    static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int best = 1;
        for (String w : words) {
            int cur = 1;
            for (int i = 0; i < w.length(); i++) {
                String prev = w.substring(0, i) + w.substring(i + 1);
                cur = Math.max(cur, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(w, cur);
            best = Math.max(best, cur);
        }
        return best;
    }

    // The same idea written as an explicit LIS with a "differs by exactly one insertion" check (what many interviewers expect to see first)
    static boolean isPredecessor(String a, String b) {                 // can a become b by inserting one char?
        if (b.length() != a.length() + 1) return false;
        int i = 0, j = 0;
        while (j < b.length()) {
            if (i < a.length() && a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == a.length();
    }

    static int longestStrChainLIS(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length, best = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) if (isPredecessor(words[j], words[i])) dp[i] = Math.max(dp[i], dp[j] + 1);
            best = Math.max(best, dp[i]);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));                    // 4  (a -> ba -> bda -> bdca)
        System.out.println(longestStrChainLIS(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));                 // 4
        System.out.println(longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));                  // 5
        System.out.println(longestStrChain(new String[]{"abcd", "dbqca"}));                                         // 1
        System.out.println(longestStrChain(new String[]{"a"}));                                                     // 1
    }
}
