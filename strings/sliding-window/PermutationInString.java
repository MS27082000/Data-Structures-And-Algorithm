/** Permutation in String (LC 567): does s2 contain a permutation of s1? */
public class PermutationInString {

    // Fixed window of size s1.length() with a 26-array diff. O(n) time, O(1) space
    static boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        if (k > s2.length()) return false;

        int[] need = new int[26];
        for (char c : s1.toCharArray()) need[c - 'a']++;

        for (int i = 0; i < s2.length(); i++) {
            need[s2.charAt(i) - 'a']--;
            if (i >= k) need[s2.charAt(i - k) - 'a']++;
            if (i >= k - 1 && allZero(need)) return true;
        }
        return false;
    }

    static boolean allZero(int[] a) {
        for (int x : a) if (x != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo")); // true
        System.out.println(checkInclusion("ab", "eidboaoo")); // false
        System.out.println(checkInclusion("abc", "ab"));      // false
    }
}
