/** Single Number II (LC 137): every element appears THREE times except one (which appears once). O(n) time, O(1) space */
public class SingleNumberII {

    // Approach 1: for each of the 32 bit positions, count how many numbers have that bit set.
    // Triples contribute multiples of 3, so (count % 3) is the bit of the single number. O(32 n), O(1)
    static int singleNumberBitCount(int[] nums) {
        int result = 0;
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int x : nums) count += (x >> bit) & 1;
            if (count % 3 != 0) result |= (1 << bit);
        }
        return result;                                   // negatives work: bit 31 is the sign bit
    }

    // Approach 2: two variables simulate a 2-bit counter mod 3 per bit. `ones` holds bits seen once (mod 3),
    // `twos` holds bits seen twice. A bit seen three times is cleared from both. O(n), O(1)
    static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int x : nums) {
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2}));                  // 3
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));        // 99
        System.out.println(singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2})); // -4
        System.out.println(singleNumber(new int[]{7}));                           // 7
        System.out.println(singleNumberBitCount(new int[]{2, 2, 3, 2}));          // 3
        System.out.println(singleNumberBitCount(new int[]{-5, 6, 6, 6}));         // -5
    }
}
