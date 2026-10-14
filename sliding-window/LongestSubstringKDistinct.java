import java.util.HashMap;
import java.util.Map;

/** Longest Substring with At Most K Distinct Characters (LC 340, premium) */
public class LongestSubstringKDistinct {

    // Same as Fruit Into Baskets with K instead of 2. O(n) time, O(k) space
    static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) return 0;
        Map<Character, Integer> count = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            count.merge(s.charAt(right), 1, Integer::sum);
            while (count.size() > k) {
                char c = s.charAt(left++);
                if (count.merge(c, -1, Integer::sum) == 0) count.remove(c);
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
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
