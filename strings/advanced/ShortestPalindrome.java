/** Shortest Palindrome (LC 214): add characters only IN FRONT of s to make the shortest possible palindrome */
public class ShortestPalindrome {

    // Find the longest palindromic PREFIX of s; the remaining suffix, reversed, goes in front. To find it in O(n): build t = s + '#' + reverse(s)
    // and take the LPS value of its last position (the longest prefix of s that equals a suffix of reverse(s), i.e. a palindromic prefix).
    // O(n) time, O(n) space
    static String shortestPalindrome(String s) {
        if (s.isEmpty()) return s;
        String rev = new StringBuilder(s).reverse().toString();
        String t = s + "#" + rev;
        int[] lps = new int[t.length()];
        int len = 0;
        for (int i = 1; i < t.length(); ) {
            if (t.charAt(i) == t.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        int palPrefix = lps[t.length() - 1];
        return new StringBuilder(s.substring(palPrefix)).reverse().toString() + s;
    }

    // Brute force: shrink the end until s[0..end] is a palindrome. O(n^2)
    static String shortestPalindromeBrute(String s) {
        for (int end = s.length(); end >= 0; end--) {
            if (isPal(s, 0, end - 1)) return new StringBuilder(s.substring(end)).reverse().toString() + s;
        }
        return s;
    }

    private static boolean isPal(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa") + " " + shortestPalindromeBrute("aacecaaa"));   // aaacecaaa aaacecaaa
        System.out.println(shortestPalindrome("abcd") + " " + shortestPalindromeBrute("abcd"));           // dcbabcd dcbabcd
        System.out.println(shortestPalindrome("a"));                    // a
        System.out.println("[" + shortestPalindrome("") + "]");         // []
        System.out.println(shortestPalindrome("racecar"));              // racecar  (already a palindrome)
        System.out.println(shortestPalindrome("aaaaab"));               // baaaaab
    }
}
