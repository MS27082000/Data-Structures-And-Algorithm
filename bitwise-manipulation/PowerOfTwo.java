/** Power of Two (LC 231) */
public class PowerOfTwo {

    // A power of two has exactly ONE set bit, so n & (n - 1) clears it and leaves 0. n must be positive. O(1)
    static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Alternative: n & -n isolates the lowest set bit; if it equals n there is only one set bit
    static boolean isPowerOfTwoAlt(int n) {
        return n > 0 && (n & -n) == n;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));                    // true  (2^0)
        System.out.println(isPowerOfTwo(16));                   // true
        System.out.println(isPowerOfTwo(3));                    // false
        System.out.println(isPowerOfTwo(0));                    // false
        System.out.println(isPowerOfTwo(-16));                  // false (negatives are never powers of two)
        System.out.println(isPowerOfTwo(1 << 30));              // true
        System.out.println(isPowerOfTwo(Integer.MIN_VALUE));    // false (a single bit, but negative)
        System.out.println(isPowerOfTwoAlt(64));                // true
    }
}
