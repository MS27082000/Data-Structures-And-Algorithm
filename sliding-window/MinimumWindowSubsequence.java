/** Minimum Window Subsequence (LC 727, premium): smallest substring of s1 in which t is a SUBSEQUENCE (order matters, gaps allowed) */
public class MinimumWindowSubsequence {

    // For each place where t can be completed (forward pass), walk BACKWARDS to find the latest start. Then restart the
    // scan from start + 1. O(n * m) worst case, O(1) space
    static String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int bestStart = -1, bestLen = Integer.MAX_VALUE;
        int i = 0;
        while (i < n) {
            int j = 0;
            while (i < n) {                                      // forward: match s2 as a subsequence, greedily
                if (s1.charAt(i) == s2.charAt(j) && ++j == m) break;
                i++;
            }
            if (i == n) break;                                   // s2 can't be completed any more
            int end = i;
            j = m - 1;
            while (j >= 0) {                                     // backward: shrink to the tightest start
                if (s1.charAt(i) == s2.charAt(j)) j--;
                i--;
            }
            i++;                                                 // i is now the start of the window
            if (end - i + 1 < bestLen) {
                bestLen = end - i + 1;
                bestStart = i;
            }
            i++;                                                 // continue just after the start of this window
        }
        return bestStart == -1 ? "" : s1.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("abcdebdde", "bde"));                              // bcde
        System.out.println("[" + minWindow("jmeqksfrsdcmsiwvaovztaqenprpvnbstl", "u") + "]");   // []
        System.out.println(minWindow("abcdebdde", "de"));                               // de
        System.out.println(minWindow("fgrqsqsnodwmxzkzxwqegkndaa", "fnok"));            // fgrqsqsnodwmxzk
        System.out.println(minWindow("cnhczmccqouqadqtmjjzl", "mm"));                   // mccqouqadqtm
        System.out.println("[" + minWindow("abc", "cba") + "]");                        // []  (order matters)
    }
}
