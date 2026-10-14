/** Longest Repeating Character Replacement (LC 424): replace at most k characters to get the longest run of one letter */
public class LongestRepeatingCharacterReplacement {

    // A window is valid if (window length - count of its most frequent char) <= k. We only ever need maxFreq to GROW,
    // so it is never decreased when shrinking (a stale larger maxFreq can't produce a wrong, longer answer). O(n), O(26)
    static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxFreq = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            maxFreq = Math.max(maxFreq, ++count[s.charAt(right) - 'A']);
            if (right - left + 1 - maxFreq > k) {            // needs more than k replacements: slide the window by one
                count[s.charAt(left) - 'A']--;
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    // Straightforward version: recompute the max frequency on each check (26 steps). O(26 n)
    static int characterReplacementSimple(String s, int k) {
        int[] count = new int[26];
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            while (right - left + 1 - maxOf(count) > k) count[s.charAt(left++) - 'A']--;
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    private static int maxOf(int[] a) {
        int m = 0;
        for (int x : a) m = Math.max(m, x);
        return m;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));            // 4
        System.out.println(characterReplacement("AABABBA", 1));         // 4
        System.out.println(characterReplacement("AAAA", 0));            // 4
        System.out.println(characterReplacement("ABCDE", 1));           // 2
        System.out.println(characterReplacement("A", 0));               // 1
        System.out.println(characterReplacementSimple("AABABBA", 1));   // 4
    }
}
