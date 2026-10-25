import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Most K Distinct Characters (LC 340, premium).
 * Same as Fruit Into Baskets, with k instead of 2 and characters instead of fruit types.
 *
 *   State to track      : map of character -> count inside the window
 *   Window is invalid   : map.size() > k
 *   When left leaves    : decrease its count, and REMOVE the key when the count reaches 0
 *
 * Order inside the loop: add -> shrink while invalid -> update answer.
 *
 * Time O(n), space O(k).
 */
public class LongestSubstringKDistinct {

    static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;                        // no character is allowed, so no valid window

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. add the new character to the window
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);

            // 2. too many distinct characters: shrink from the left
            while (map.size() > k) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                if (map.get(l) == 0) {
                    map.remove(l);                   // remove the key at 0, or size() overcounts
                }
                left++;
            }

            // 3. the window is valid here, so update the answer
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));      // 3  ("ece")
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));         // 2
        System.out.println(lengthOfLongestSubstringKDistinct("abc", 0));        // 0
        System.out.println(lengthOfLongestSubstringKDistinct("abcadcacacaca", 3)); // 11
        System.out.println(lengthOfLongestSubstringKDistinct("a", 5));          // 1 (k larger than the alphabet)
        System.out.println(lengthOfLongestSubstringKDistinct("", 2));           // 0
    }
}
