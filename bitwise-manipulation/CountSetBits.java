/** Count the Number of Set Bits (Hamming weight, LC 191) */
public class CountSetBits {

    // Brian Kernighan: n & (n - 1) removes the lowest set bit, so the loop runs once per SET bit. O(k) for k set bits
    static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;                      // works for negatives too: int has 32 bits, so the loop ends
    }

    // Simple version: test every one of the 32 bits. O(32). Use >>> so negative numbers don't loop forever
    static int countSetBitsSimple(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    // Follow-up: Counting Bits (LC 338): set bits for every number 0..n using dp[i] = dp[i >> 1] + (i & 1). O(n)
    static int[] countBitsUpTo(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = dp[i >> 1] + (i & 1);
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(11));                       // 3   (1011)
        System.out.println(countSetBits(128));                      // 1
        System.out.println(countSetBits(0));                        // 0
        System.out.println(countSetBits(-1));                       // 32
        System.out.println(countSetBits(Integer.MAX_VALUE));        // 31
        System.out.println(countSetBitsSimple(11) + " " + countSetBitsSimple(-1)); // 3 32
        System.out.println(java.util.Arrays.toString(countBitsUpTo(5))); // [0, 1, 1, 2, 1, 2]
        System.out.println(Integer.bitCount(11));                   // 3 (the built-in)
    }
}
