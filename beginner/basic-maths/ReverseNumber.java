/** Reverse a number (LC 7 adds the 32-bit overflow rule) */
public class ReverseNumber {

    // rev = rev * 10 + last digit. O(log10 n) time, O(1) space
    static long reverse(long n) {
        long sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        long rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return sign * rev;
    }

    // LeetCode 7: return 0 if the reversed value leaves the int range. Check BEFORE the multiply so the int never overflows
    static int reverseInt(int x) {
        int rev = 0;
        while (x != 0) {
            int d = x % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && d > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && d < -8)) return 0;
            rev = rev * 10 + d;
            x /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1234));               // 4321
        System.out.println(reverse(1200));               // 21   (trailing zeros disappear)
        System.out.println(reverse(-123));               // -321
        System.out.println(reverse(0));                  // 0
        System.out.println(reverseInt(123));             // 321
        System.out.println(reverseInt(1534236469));      // 0    (overflow)
        System.out.println(reverseInt(-2147483412));     // -2143847412
    }
}
