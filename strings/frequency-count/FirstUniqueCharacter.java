/** First Unique Character in a String (LC 387): index of first non-repeating char, else -1. */
public class FirstUniqueCharacter {

    // Pass 1: count. Pass 2: first char with count 1. O(n) time, O(1) space
    static int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));     // 0
        System.out.println(firstUniqChar("loveleetcode")); // 2
        System.out.println(firstUniqChar("aabb"));         // -1
    }
}
