import java.util.HashSet;
import java.util.Set;

/** Maximum XOR of Two Numbers in an Array (LC 421) */
public class MaximumXorOfTwoNumbers {

    private static class Node {
        Node zero, one;
    }

    // Binary trie of the numbers (31 bits, MSB first). For each x walk the trie, at every bit preferring the OPPOSITE bit (it sets that bit of
    // the xor to 1); if it is missing, take the same bit. O(31 * n) time, O(31 * n) space
    static int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for (int x : nums) {
            Node cur = root;
            for (int i = 30; i >= 0; i--) {
                int b = (x >> i) & 1;
                if (b == 0) { if (cur.zero == null) cur.zero = new Node(); cur = cur.zero; }
                else { if (cur.one == null) cur.one = new Node(); cur = cur.one; }
            }
        }
        int best = 0;
        for (int x : nums) {
            Node cur = root;
            int val = 0;
            for (int i = 30; i >= 0; i--) {
                int b = (x >> i) & 1;
                Node want = b == 0 ? cur.one : cur.zero;               // the opposite bit
                if (want != null) { val |= (1 << i); cur = want; }
                else cur = b == 0 ? cur.zero : cur.one;
            }
            best = Math.max(best, val);
        }
        return best;
    }

    // Prefix-set alternative: build the answer bit by bit from the top; a candidate is achievable if two prefixes xor to it. O(31 * n)
    static int findMaximumXORPrefixSet(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);
            Set<Integer> prefixes = new HashSet<>();
            for (int x : nums) prefixes.add(x & mask);
            int candidate = max | (1 << i);
            for (int p : prefixes) {
                if (prefixes.contains(candidate ^ p)) { max = candidate; break; }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(a) + " " + findMaximumXORPrefixSet(a));                       // 28 28  (5 ^ 25)
        System.out.println(findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70})); // 127
        System.out.println(findMaximumXOR(new int[]{0}));                                               // 0
        System.out.println(findMaximumXOR(new int[]{8, 8}));                                            // 0  (same number xor itself)
        System.out.println(findMaximumXOR(new int[]{1, 2}));                                            // 3
        System.out.println(findMaximumXOR(new int[]{Integer.MAX_VALUE, 0}));                            // 2147483647
    }
}
