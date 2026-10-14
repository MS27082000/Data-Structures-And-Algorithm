/** Check if a string is a palindrome (recursive) */
public class PalindromeStringRecursive {

    // Compare the two ends; if equal recurse on the inside. Base: pointers crossed -> true. O(n) time, O(n) stack
    static boolean isPalindrome(String s, int l, int r) {
        if (l >= r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return isPalindrome(s, l + 1, r - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam", 0, 4));       // true
        System.out.println(isPalindrome("abba", 0, 3));        // true
        System.out.println(isPalindrome("abc", 0, 2));         // false
        System.out.println(isPalindrome("", 0, -1));           // true
        System.out.println(isPalindrome("a", 0, 0));           // true
    }
}
