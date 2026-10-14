/** Set the Rightmost Unset Bit: turn the lowest 0 bit into 1 (if every bit is already 1, return n unchanged) */
public class SetRightmostUnsetBit {

    // n + 1 flips the trailing 1s to 0 and the first 0 to 1; OR-ing with n restores the trailing 1s. O(1)
    //   n = 1011  ->  n + 1 = 1100  ->  n | (n + 1) = 1111
    static int setRightmostUnsetBit(int n) {
        if (n != 0 && (n & (n + 1)) == 0) return n;   // all ones (1, 3, 7, 15 ...): no unset bit below the top set bit
        return n | (n + 1);                           // n = 0 falls through: 0 | 1 = 1
    }

    // Plain loop version: scan for the first 0 bit, below the highest set bit. O(log n)
    static int setRightmostUnsetBitLoop(int n) {
        int mask = 1;
        while ((n & mask) != 0) mask <<= 1;
        if (n != 0 && mask > n) return n;      // only 1s up to the top bit: nothing to set
        return n | mask;
    }

    public static void main(String[] args) {
        System.out.println(setRightmostUnsetBit(6));       // 7   (110 -> 111)
        System.out.println(setRightmostUnsetBit(11));      // 15  (1011 -> 1111)
        System.out.println(setRightmostUnsetBit(5));       // 7   (101 -> 111)
        System.out.println(setRightmostUnsetBit(15));      // 15  (1111: all ones, unchanged)
        System.out.println(setRightmostUnsetBit(8));       // 9   (1000 -> 1001)
        System.out.println(setRightmostUnsetBitLoop(6));   // 7
        System.out.println(setRightmostUnsetBitLoop(15));  // 15
        System.out.println(setRightmostUnsetBit(0));       // 1   (bit 0 is the rightmost unset bit)
        System.out.println(setRightmostUnsetBitLoop(0));   // 1
    }
}
