/** Palindrome check for a string: plain, and the LeetCode 125 version (ignore case and non-alphanumeric characters) */
public class PalindromeCheck {

    // Two pointers from both ends. O(n) time, O(1) space
    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    // LC 125: skip anything that is not a letter or digit and compare case-insensitively
    static boolean isPalindromeClean(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));                                  // true
        System.out.println(isPalindrome("abca"));                                   // false
        System.out.println(isPalindrome(""));                                       // true
        System.out.println(isPalindromeClean("A man, a plan, a canal: Panama"));    // true
        System.out.println(isPalindromeClean("race a car"));                        // false
        System.out.println(isPalindromeClean(" "));                                 // true
        System.out.println(isPalindromeClean("0P"));                                // false   ('0' and 'p' differ)
    }
}
