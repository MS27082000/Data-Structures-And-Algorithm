/** Minimum Window Substring (LC 76): smallest substring of s that contains every character of t (with multiplicity) */
public class MinimumWindowSubstring {

    // need[c] = how many of c we still require; `missing` = total characters still required.
    // Expand right until the window covers t (missing == 0), then shrink left as far as possible. O(n + m) time, O(1) space
    static String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) return "";
        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;
        int missing = t.length(), left = 0, bestStart = 0, bestLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (need[s.charAt(right)]-- > 0) missing--;          // this character was genuinely needed
            while (missing == 0) {                                // window is valid: try to shrink it
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }
                if (++need[s.charAt(left)] > 0) missing++;        // we just removed a needed character
                left++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));    // BANC
        System.out.println(minWindow("a", "a"));                  // a
        System.out.println("[" + minWindow("a", "aa") + "]");     // []  (not enough 'a's)
        System.out.println(minWindow("aa", "aa"));                // aa
        System.out.println(minWindow("ab", "b"));                 // b
        System.out.println(minWindow("bba", "ab"));               // ba
    }
}
