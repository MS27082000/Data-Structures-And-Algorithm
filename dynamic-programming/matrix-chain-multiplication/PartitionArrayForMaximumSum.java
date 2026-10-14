/** Partition Array for Maximum Sum (LC 1043): split into contiguous subarrays of length at most k; each subarray becomes all-max-of-itself. Maximise the sum */
public class PartitionArrayForMaximumSum {

    // Front partition DP: dp[i] = best sum for the first i elements. For the last block of length len (1..k) ending at i, its value is
    // len * (max of that block). Track the running max as len grows. O(n * k) time, O(n) space
    static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int len = 1; len <= k && len <= i; len++) {
                max = Math.max(max, arr[i - len]);
                dp[i] = Math.max(dp[i], dp[i - len] + max * len);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));     // 84  ([15,15,15,9,10,10,10])
        System.out.println(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));   // 83
        System.out.println(maxSumAfterPartitioning(new int[]{1}, 1));                          // 1
        System.out.println(maxSumAfterPartitioning(new int[]{3, 1, 2}, 1));                    // 6  (k = 1: nothing changes)
        System.out.println(maxSumAfterPartitioning(new int[]{3, 1, 2}, 3));                    // 9  (3 x 3)
    }
}
