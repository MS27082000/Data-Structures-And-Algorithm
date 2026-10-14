import java.util.Arrays;

/** Valid Anagram (LC 242): do s and t contain exactly the same letters with the same counts? */
public class ValidAnagram {

    // Count letters: +1 for s, -1 for t; all counts must return to zero. O(n) time, O(1) space (26 counters)
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) if (c != 0) return false;
        return true;
    }

    // Brute force: sort both. O(n log n)
    static boolean isAnagramSort(String s, String t) {
        char[] a = s.toCharArray(), b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram") + " " + isAnagramSort("anagram", "nagaram"));   // true true
        System.out.println(isAnagram("rat", "car"));        // false
        System.out.println(isAnagram("a", "ab"));           // false
        System.out.println(isAnagram("", ""));              // true
        System.out.println(isAnagram("aacc", "ccac"));      // false  (same letters, different counts)
    }
}
