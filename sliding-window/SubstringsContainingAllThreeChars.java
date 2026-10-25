import java.util.HashMap;
import java.util.Map;

/**
 * Number of Substrings Containing All Three Characters (LC 1358): s contains only 'a', 'b', 'c'.
 *
 * Main approach: "exactly 3 distinct" = atMost(3) - atMost(2).
 * Since s has only a, b, c, a substring that contains all three has exactly 3 distinct characters.
 *
 * Time O(n), space O(1).
 */
public class SubstringsContainingAllThreeChars {

    // Approach 1 (main): count substrings with at most k distinct characters, then subtract.
    static int numberOfSubstringsAtMost(String s) {
        int k = 3;
        return numberOfSubstringsAtMostK(s, k) - numberOfSubstringsAtMostK(s, k - 1);
    }

    // Counts substrings with at most k distinct characters.
    private static int numberOfSubstringsAtMostK(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. add the new character
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            // 2. too many distinct characters: shrink from the left
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);            // remove the key at 0, or size() overcounts
                }
                left++;
            }

            // 3. every substring ending at right and starting at left..right is valid
            count += right - left + 1;
        }
        return count;
    }

    // Approach 2: last seen. For each right end, the valid starts are 0..min(lastSeen[a], lastSeen[b], lastSeen[c]). Add min + 1. O(n) time, O(1) space
    static int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            int earliest = Math.min(last[0], Math.min(last[1], last[2]));   // -1 if some letter hasn't appeared yet
            count += earliest + 1;                                            // starts 0..earliest all work (0 if -1)
        }
        return count;
    }

    // Approach 3: classic window version: for each left, find the smallest right that completes the set; everything after also works
    static int numberOfSubstringsWindow(String s) {
        int[] freq = new int[3];
        int left = 0, count = 0, n = s.length();
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += n - right;                                           // [left..right], [left..right+1], ... [left..n-1]
                freq[s.charAt(left++) - 'a']--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstringsAtMost("abcabc"));    // 10
        System.out.println(numberOfSubstringsAtMost("aaacb"));     // 3
        System.out.println(numberOfSubstringsAtMost("abc"));       // 1
        System.out.println(numberOfSubstringsAtMost("aabb"));      // 0
        System.out.println(numberOfSubstrings("abcabc"));          // 10
        System.out.println(numberOfSubstrings("aaacb"));           // 3
        System.out.println(numberOfSubstrings("abc"));             // 1
        System.out.println(numberOfSubstrings("aabb"));            // 0
        System.out.println(numberOfSubstringsWindow("abcabc"));    // 10
        System.out.println(numberOfSubstringsWindow("aaacb"));     // 3
    }
}
