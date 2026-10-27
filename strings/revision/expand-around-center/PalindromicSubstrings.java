/** Palindromic Substrings (LC 647): count all palindromic substrings. */
public class PalindromicSubstrings {

    // Every index is a centre (odd) and every gap is a centre (even); expand while equal. O(n^2) time, O(1) space
    static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);       // odd length
            count += expand(s, i, i + 1);   // even length
        }
        return count;
    }

    static int expand(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));   // 3
        System.out.println(countSubstrings("aaa"));   // 6
        System.out.println(countSubstrings("a"));     // 1
    }
}
