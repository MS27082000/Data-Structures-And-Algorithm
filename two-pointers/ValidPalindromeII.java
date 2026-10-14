/** LC 680 - Valid Palindrome II (can delete at most one char) */
public class ValidPalindromeII {

    // O(n) time, O(1) space. On first mismatch, try skipping left OR right char.
    static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalin(s, left + 1, right) || isPalin(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));      // true
        System.out.println(validPalindrome("abca"));     // true
        System.out.println(validPalindrome("abc"));      // false
        System.out.println(validPalindrome("deeee"));    // true
        System.out.println(validPalindrome("a"));        // true
    }
}
