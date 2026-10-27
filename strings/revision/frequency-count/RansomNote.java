/** Ransom Note (LC 383): can ransomNote be built from the letters of magazine? */
public class RansomNote {

    // Count magazine letters, then use them up. O(n + m) time, O(1) space
    static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) count[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));      // false
        System.out.println(canConstruct("aa", "ab"));    // false
        System.out.println(canConstruct("aa", "aab"));   // true
    }
}
