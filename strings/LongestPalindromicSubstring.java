/** Longest Palindromic Substring (LC 5) */
public class LongestPalindromicSubstring {

    // Expand around every centre (n odd centres + n-1 even centres). O(n^2) time, O(1) space
    static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int start = 0, maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);          // odd length, centre at i
            int len2 = expand(s, i, i + 1);      // even length, centre between i and i+1
            int len = Math.max(len1, len2);
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;                 // length of the palindrome found
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));       // bab (aba is also valid)
        System.out.println(longestPalindrome("cbbd"));        // bb
        System.out.println(longestPalindrome("a"));           // a
        System.out.println(longestPalindrome("ac"));          // a
        System.out.println(longestPalindrome("racecar"));     // racecar
        System.out.println(longestPalindrome("forgeeksskeegfor")); // geeksskeeg
    }
}
