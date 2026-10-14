/** Check if the i-th bit is set (plus set / clear / toggle). Bits are 0-indexed from the RIGHT (LSB = bit 0) */
public class CheckIthBit {

    // Right-shift variant: bring bit i to position 0, then mask. O(1)
    static boolean isSetShift(int n, int i) {
        return ((n >> i) & 1) == 1;
    }

    // Left-shift variant: mask only bit i. O(1)
    static boolean isSetMask(int n, int i) {
        return (n & (1 << i)) != 0;
    }

    static int set(int n, int i)    { return n | (1 << i); }
    static int clear(int n, int i)  { return n & ~(1 << i); }
    static int toggle(int n, int i) { return n ^ (1 << i); }

    public static void main(String[] args) {
        int n = 13;                                      // 1101
        System.out.println(isSetShift(n, 0));            // true
        System.out.println(isSetShift(n, 1));            // false
        System.out.println(isSetMask(n, 2));             // true
        System.out.println(isSetMask(n, 3));             // true
        System.out.println(isSetMask(n, 4));             // false
        System.out.println(set(n, 1));                   // 15  (1111)
        System.out.println(clear(n, 3));                 // 5   (0101)
        System.out.println(toggle(n, 0));                // 12  (1100)
        System.out.println(isSetShift(-1, 31));          // true (the sign bit of -1)
        System.out.println(isSetShift(0, 5));            // false
    }
}
