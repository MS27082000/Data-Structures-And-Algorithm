/** Reverse a string using recursion */
public class ReverseStringI {

    // Two-pointer recursion on a char array: swap the ends, recurse on the inside. O(n) time, O(n) stack, no new strings
    static void reverse(char[] s, int l, int r) {
        if (l >= r) return;
        char t = s[l]; s[l] = s[r]; s[r] = t;
        reverse(s, l + 1, r - 1);
    }

    // Head/tail version: reverse(s) = reverse(s[1..]) + s[0]. Easy to read but O(n^2) because of the string copies
    static String reverseHeadTail(String s) {
        if (s.length() <= 1) return s;
        return reverseHeadTail(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args) {
        char[] a = "hello".toCharArray();
        reverse(a, 0, a.length - 1);
        System.out.println(new String(a));                       // olleh
        System.out.println(reverseHeadTail("abcd"));             // dcba
        System.out.println(reverseHeadTail("a"));                // a
        System.out.println("[" + reverseHeadTail("") + "]");     // []
        char[] b = "ab".toCharArray();
        reverse(b, 0, 1);
        System.out.println(new String(b));                       // ba
    }
}
