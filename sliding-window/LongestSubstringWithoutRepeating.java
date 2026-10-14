/** Longest Substring Without Repeating Characters (LC 3) */
public class LongestSubstringWithoutRepeating {

    // Remember the LAST index of each character. On a repeat inside the window, jump `left` just past the old copy.
    // O(n) time, O(1) space (256 slots)
    static int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[256];
        java.util.Arrays.fill(lastIndex, -1);
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (lastIndex[c] >= left) left = lastIndex[c] + 1;       // only if the old copy is INSIDE the window
            lastIndex[c] = right;
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));    // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));       // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));      // 3
        System.out.println(lengthOfLongestSubstring(""));            // 0
        System.out.println(lengthOfLongestSubstring("abba"));        // 2 (the stale index of 'a' must not move left backwards)
        System.out.println(lengthOfLongestSubstring("dvdf"));        // 3
        System.out.println(lengthOfLongestSubstring(" "));           // 1
    }
}
