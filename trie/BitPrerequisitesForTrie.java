/** Bit prerequisites for the XOR-trie problems: read bit i, build a 31-bit path, and walk "the opposite bit" greedily */
public class BitPrerequisitesForTrie {

    // bit i (0 = least significant) of x
    static int bit(int x, int i) {
        return (x >> i) & 1;
    }

    // Print the 8 high-to-low bits of x: this is exactly the path a number takes in a binary trie (most significant bit first)
    static String bits(int x, int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = width - 1; i >= 0; i--) sb.append(bit(x, i));
        return sb.toString();
    }

    // XOR maximisation idea: to make a ^ b big, we want the HIGHEST bits to differ. At each bit from the top, prefer a number whose bit is
    // the opposite of ours. Here, brute force over a small array to show what the trie will speed up.
    static int maxXorBruteForce(int[] nums) {
        int best = 0;
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) best = Math.max(best, nums[i] ^ nums[j]);
        return best;
    }

    public static void main(String[] args) {
        System.out.println(bits(5, 8) + " " + bits(10, 8));                       // 00000101 00001010
        System.out.println(bit(5, 0) + " " + bit(5, 1) + " " + bit(5, 2));         // 1 0 1
        System.out.println(bits(5 ^ 10, 8));                                       // 00001111  (differing bits become 1)
        System.out.println(maxXorBruteForce(new int[]{3, 10, 5, 25, 2, 8}));       // 28  (5 ^ 25)
        System.out.println(bits(-1, 8) + " " + bit(Integer.MIN_VALUE, 31));        // 11111111 1  (non-negative inputs keep bit 31 = 0)
        System.out.println((Integer.MAX_VALUE) + " has " + Integer.bitCount(Integer.MAX_VALUE) + " one-bits (31 levels are enough)");   // 2147483647 has 31 one-bits (31 levels are enough)
    }
}
