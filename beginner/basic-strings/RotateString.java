/** Rotate String (LC 796): can s become goal after some number of left shifts? */
public class RotateString {

    // Every rotation of s is a substring of s + s, and the lengths must match. O(n) with KMP; String.contains is O(n^2) worst case but fine
    static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    // Brute force: try every shift. O(n^2)
    static boolean rotateStringBrute(String s, String goal) {
        if (s.length() != goal.length()) return false;
        for (int shift = 0; shift < Math.max(1, s.length()); shift++) {
            if ((s.substring(shift) + s.substring(0, shift)).equals(goal)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab") + " " + rotateStringBrute("abcde", "cdeab"));   // true true
        System.out.println(rotateString("abcde", "abced") + " " + rotateStringBrute("abcde", "abced"));   // false false
        System.out.println(rotateString("a", "a"));                  // true
        System.out.println(rotateString("ab", "abc"));               // false (different lengths)
        System.out.println(rotateString("aa", "a"));                 // false (a naive contains check on s + s would say true)
        System.out.println(rotateString("", ""));                    // true
    }
}
