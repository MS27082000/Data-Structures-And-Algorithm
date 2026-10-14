/** Reverse String II (LC 541): for every block of 2k characters, reverse the first k. If fewer than k remain reverse them all; if between k and 2k
 *  remain reverse the first k */
public class ReverseStringII {

    // Jump 2k at a time; reverse [i, min(i + k, n) - 1] with two pointers. O(n) time, O(n) space (char array copy)
    static String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int l = start, r = Math.min(start + k - 1, a.length - 1);
            while (l < r) { char t = a[l]; a[l++] = a[r]; a[r--] = t; }
        }
        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));       // bacdfeg
        System.out.println(reverseStr("abcd", 2));          // bacd
        System.out.println(reverseStr("abc", 5));           // cba   (fewer than k left: reverse all)
        System.out.println(reverseStr("a", 1));             // a
        System.out.println(reverseStr("abcdefgh", 3));      // cbadefhg
        System.out.println(reverseStr("", 3));              // (empty)
    }
}
