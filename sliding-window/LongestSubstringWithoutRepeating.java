import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters (LC 3).
 *
 *   State to track      : map of character -> count inside the window (it is always 1, since no repeats are allowed)
 *   Window is invalid   : the incoming character is already in the map
 *   When left leaves    : decrease its count, and REMOVE the key when the count reaches 0
 *
 * Order inside the loop: shrink while the incoming character is a duplicate -> add it -> update answer.
 * (Here we may shrink BEFORE adding, because the condition only needs the incoming character.)
 *
 * Time O(n), space O(min(n, alphabet size)).
 */
public class LongestSubstringWithoutRepeating {

    // Approach 1: sliding window with a map, shrinking one step at a time.
    static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // the incoming character is already in the window: remove from the left until it is gone
            while (map.containsKey(ch)) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            map.put(ch, map.getOrDefault(ch, 0) + 1);       // now it is safe to add
            maxLen = Math.max(maxLen, right - left + 1);    // window has no repeats
        }
        return maxLen;
    }

    // Approach 2: remember the LAST index of each character. On a repeat inside the window,
    // jump `left` just past the old copy (no step-by-step shrinking). O(n) time, O(1) space (256 slots).
    static int lengthOfLongestSubstringJump(String s) {
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
        System.out.println(lengthOfLongestSubstring("abba"));        // 2
        System.out.println(lengthOfLongestSubstring("dvdf"));        // 3
        System.out.println(lengthOfLongestSubstring(" "));           // 1
        System.out.println(lengthOfLongestSubstringJump("abba"));    // 2 (the stale index of 'a' must not move left backwards)
        System.out.println(lengthOfLongestSubstringJump("abcabcbb")); // 3
    }
}
