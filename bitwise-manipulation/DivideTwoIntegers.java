/** Divide Two Integers (LC 29): divide WITHOUT *, / or %; truncate toward zero; clamp to the 32-bit int range */
public class DivideTwoIntegers {

    // Subtract the largest (divisor << k) that still fits, add 2^k to the quotient, repeat. O(log^2 n) time, O(1) space
    static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;   // the only overflow case
        boolean negative = (dividend < 0) != (divisor < 0);
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);   // long: |MIN_VALUE| does not fit in int
        long quotient = 0;
        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {              // double the divisor while it still fits into a
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            quotient += multiple;
        }
        return (int) (negative ? -quotient : quotient);
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));                          // 3
        System.out.println(divide(7, -3));                          // -2  (truncates toward zero)
        System.out.println(divide(-7, 2));                          // -3
        System.out.println(divide(0, 5));                           // 0
        System.out.println(divide(1, 1));                           // 1
        System.out.println(divide(Integer.MIN_VALUE, -1));          // 2147483647 (clamped)
        System.out.println(divide(Integer.MIN_VALUE, 1));           // -2147483648
        System.out.println(divide(Integer.MAX_VALUE, 2));           // 1073741823
        System.out.println(divide(Integer.MIN_VALUE, Integer.MIN_VALUE)); // 1
    }
}
