/** Introduction to Bits and Tricks: the operators and the one-liners every bit problem is built from */
public class BitTricks {

    // ---- single-bit operations (bit positions are 0-indexed from the right) ----
    static int getBit(int n, int i)    { return (n >> i) & 1; }
    static int setBit(int n, int i)    { return n | (1 << i); }
    static int clearBit(int n, int i)  { return n & ~(1 << i); }
    static int toggleBit(int n, int i) { return n ^ (1 << i); }

    // n & (n - 1) clears the LOWEST set bit.   n & -n isolates the LOWEST set bit.
    static int clearLowestSetBit(int n) { return n & (n - 1); }
    static int isolateLowestSetBit(int n) { return n & -n; }

    public static void main(String[] args) {
        // Operators: &  |  ^  ~  <<  >>  >>>
        System.out.println(5 & 3);                 // 1   (101 & 011 = 001)
        System.out.println(5 | 3);                 // 7   (101 | 011 = 111)
        System.out.println(5 ^ 3);                 // 6   (101 ^ 011 = 110)
        System.out.println(~5);                    // -6  (two's complement: ~n = -n - 1)

        // Shifts: << multiplies by 2^k, >> divides by 2^k (keeps the sign), >>> fills with zeros
        System.out.println(5 << 2);                // 20
        System.out.println(20 >> 2);               // 5
        System.out.println(-8 >> 1);               // -4  (arithmetic shift keeps the sign bit)
        System.out.println(-8 >>> 28);             // 15  (logical shift: zeros come in from the left)

        // Single-bit tricks
        System.out.println(getBit(13, 2));         // 1   (13 = 1101)
        System.out.println(setBit(8, 1));          // 10  (1000 -> 1010)
        System.out.println(clearBit(13, 0));       // 12  (1101 -> 1100)
        System.out.println(toggleBit(13, 3));      // 5   (1101 -> 0101)

        // Lowest set bit tricks
        System.out.println(clearLowestSetBit(12)); // 8   (1100 -> 1000)
        System.out.println(isolateLowestSetBit(12)); // 4 (1100 -> 0100)

        // XOR properties: x ^ x = 0, x ^ 0 = x, commutative + associative
        System.out.println(7 ^ 7);                 // 0
        System.out.println(7 ^ 0);                 // 7
        System.out.println(1 ^ 2 ^ 3 ^ 2 ^ 1);    // 3  (pairs cancel out)

        // Representation facts
        System.out.println(Integer.toBinaryString(10));       // 1010
        System.out.println(Integer.toBinaryString(-1));       // 32 ones (two's complement)
        System.out.println(Integer.MAX_VALUE + 1);            // -2147483648 (overflow wraps around)
        System.out.println(1 << 31);                          // -2147483648 (the sign bit)
        System.out.println(1L << 40);                         // 1099511627776 (use long beyond 31 bits)
    }
}
