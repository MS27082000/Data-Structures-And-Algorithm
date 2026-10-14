/** Count Partitions with Given Difference: number of ways to split arr into subsets S1 and S2 with S1 - S2 = d (S1 >= S2) */
public class CountPartitionsWithGivenDifference {

    // S1 + S2 = total and S1 - S2 = d  =>  S1 = (total + d) / 2. So count subsets with sum (total + d) / 2.
    // Invalid when total + d is odd or total < d. Zeros are handled by counting index choices. O(n * target) time, O(target) space
    static int countPartitions(int[] arr, int d) {
        int total = 0;
        for (int x : arr) total += x;
        if (total - d < 0 || (total - d) % 2 != 0) return 0;
        int target = (total + d) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int x : arr) {
            for (int s = target; s >= x; s--) dp[s] += dp[s - x];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{5, 2, 6, 4}, 3));     // 1  (total 17, S1 = (17 + 3) / 2 = 10 => only {6,4})
        System.out.println(countPartitions(new int[]{1, 1, 2, 3}, 1));     // 3
        System.out.println(countPartitions(new int[]{0, 0, 1}, 1));        // 4
        System.out.println(countPartitions(new int[]{1, 2, 3}, 10));       // 0  (the difference is larger than the total)
        System.out.println(countPartitions(new int[]{3, 1, 2}, 0));        // 2  (S1 = 3: {3} or {1,2}; with d = 0 each split is counted from both sides)
    }
}
