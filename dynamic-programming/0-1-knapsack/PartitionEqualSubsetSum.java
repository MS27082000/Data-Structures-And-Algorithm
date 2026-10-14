/** Partition Equal Subset Sum (LC 416): can the array be split into two subsets with equal sums? */
public class PartitionEqualSubsetSum {

    // Two equal halves => each half = total / 2. So the total must be even, and some subset must sum to total / 2 (subset sum).
    // O(n * total/2) time, O(total/2) space
    static boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;
        if (total % 2 != 0) return false;
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int x : nums) {
            for (int s = target; s >= x; s--) dp[s] |= dp[s - x];
            if (dp[target]) return true;                            // early exit
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));        // true  (11 | 1 + 5 + 5)
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));         // false (sum 11 is odd)
        System.out.println(canPartition(new int[]{2, 2, 3, 5}));         // false (sum 12, but no subset makes 6)
        System.out.println(canPartition(new int[]{1, 1}));               // true
        System.out.println(canPartition(new int[]{100}));                // false (a single element cannot be split)
        System.out.println(canPartition(new int[]{3, 3, 3, 4, 5}));      // true  (3 + 3 + 3 = 9 | 4 + 5)
    }
}
