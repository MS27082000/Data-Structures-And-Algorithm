/** Palindrome Number (LC 9) */
public class PalindromeNumber {

    // Reverse and compare. Negative numbers are never palindromes ("-121" != "121-"). O(log10 n) time, O(1) space
    static boolean isPalindrome(int x) {
        if (x < 0) return false;
        long rev = 0;
        int n = x;
        while (n > 0) { rev = rev * 10 + n % 10; n /= 10; }
        return rev == x;
    }

    // Reverse only HALF the number: stop when the reversed half is >= the remaining half. Avoids overflow completely
    static boolean isPalindromeHalf(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;       // a trailing zero would need a leading zero
        int rev = 0;
        while (x > rev) { rev = rev * 10 + x % 10; x /= 10; }
        return x == rev || x == rev / 10;                          // even length || odd length (drop the middle digit)
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121) + " " + isPalindromeHalf(121));      // true true
        System.out.println(isPalindrome(-121) + " " + isPalindromeHalf(-121));    // false false
        System.out.println(isPalindrome(10) + " " + isPalindromeHalf(10));        // false false
        System.out.println(isPalindrome(0) + " " + isPalindromeHalf(0));          // true true
        System.out.println(isPalindrome(1221) + " " + isPalindromeHalf(1221));    // true true
        System.out.println(isPalindrome(123) + " " + isPalindromeHalf(123));      // false false
    }
}
