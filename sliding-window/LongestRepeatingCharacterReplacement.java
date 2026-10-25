/**
 * Longest Repeating Character Replacement (LC 424).
 *
 * In a window, keep the most frequent letter and change all the others:
 *      changes needed = window length - maxFreq
 * The window is valid when changes needed <= k. We want the longest valid window.
 *
 *   State to track      : freq[26] and maxFreq of the window
 *   Window is invalid   : (right - left + 1) - maxFreq > k
 *   When left leaves    : freq[s[left]]--
 *
 * Time O(n), space O(26).
 */
public class LongestRepeatingCharacterReplacement {

    // Sliding window
    static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // 1. add the new letter
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // 2. invalid: more than k changes needed, so shrink from the left
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            // maxFreq is never decreased. A stale (too big) value cannot give a wrong, longer answer,
            // because the answer only grows when maxFreq gets a new bigger value.

            // 3. the window is valid here
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // Brute force: every start i, extend j, keep counts. O(n^2) time.
    static int characterReplacementBrute(String s, int k) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'A']++;
                maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);
                if ((j - i + 1) - maxFreq <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;                         // adding more letters only makes it worse
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));            // 4
        System.out.println(characterReplacement("AABABBA", 1));         // 4
        System.out.println(characterReplacement("AAAA", 0));            // 4
        System.out.println(characterReplacement("ABCDE", 1));           // 2
        System.out.println(characterReplacement("A", 0));               // 1
        System.out.println(characterReplacementBrute("AABABBA", 1));    // 4
    }
}
