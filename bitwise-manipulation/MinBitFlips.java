/** Minimum Bit Flips to Convert Number (LC 2220): flips needed to turn start into goal */
public class MinBitFlips {

    // start ^ goal has a 1 exactly where the bits DIFFER. Each differing bit needs one flip, so count them. O(k)
    static int minBitFlips(int start, int goal) {
        int diff = start ^ goal;
        int count = 0;
        while (diff != 0) {
            diff &= (diff - 1);             // Kernighan: remove the lowest set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(10, 7));                  // 3   (1010 vs 0111)
        System.out.println(minBitFlips(3, 4));                   // 3   (011 vs 100)
        System.out.println(minBitFlips(5, 5));                   // 0
        System.out.println(minBitFlips(0, Integer.MAX_VALUE));   // 31
        System.out.println(minBitFlips(-1, 0));                  // 32
        System.out.println(Integer.bitCount(10 ^ 7));            // 3 (the built-in equivalent)
    }
}
