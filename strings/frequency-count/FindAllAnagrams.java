import java.util.*;

/** Find All Anagrams in a String (LC 438): start indices of p's anagrams in s. */
public class FindAllAnagrams {

    // Fixed window of size p.length(); keep a count diff. O(n) time, O(1) space
    static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] need = new int[26];
        for (char c : p.toCharArray()) need[c - 'a']++;

        int k = p.length();
        for (int i = 0; i < s.length(); i++) {
            need[s.charAt(i) - 'a']--;                       // add right char
            if (i >= k) need[s.charAt(i - k) - 'a']++;       // drop left char
            if (i >= k - 1 && allZero(need)) res.add(i - k + 1);
        }
        return res;
    }

    static boolean allZero(int[] a) {
        for (int x : a) if (x != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(findAnagrams("abab", "ab"));        // [0, 1, 2]
        System.out.println(findAnagrams("a", "ab"));           // []
    }
}
