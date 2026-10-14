/** Longest Happy Prefix (LC 1392): the longest non-empty PROPER prefix that is also a suffix ("" if none) */
public class LongestHappyPrefix {

    // That is exactly lps[n - 1] of the KMP failure array. O(n) time, O(n) space
    static String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        for (int i = 1; i < n; ) {
            if (s.charAt(i) == s.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];
            else lps[i++] = 0;
        }
        return s.substring(0, n == 0 ? 0 : lps[n - 1]);
    }

    // Brute force: longest length first, compare prefix with suffix. O(n^2)
    static String longestPrefixBrute(String s) {
        for (int len = s.length() - 1; len > 0; len--) {
            if (s.startsWith(s.substring(s.length() - len))) return s.substring(0, len);
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestPrefix("level") + " " + longestPrefixBrute("level"));            // l l
        System.out.println(longestPrefix("ababab") + " " + longestPrefixBrute("ababab"));          // abab abab
        System.out.println("[" + longestPrefix("abcd") + "]");                                      // []
        System.out.println(longestPrefix("aaaa"));                                                  // aaa  (proper: the whole string is not allowed)
        System.out.println("[" + longestPrefix("a") + "]");                                         // []
        System.out.println(longestPrefix("abcabcabc"));                                             // abcabc
    }
}
