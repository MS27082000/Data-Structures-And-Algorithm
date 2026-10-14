import java.util.Arrays;

/** Maximum Sum of Non-Adjacent Elements: pick a subsequence with no two adjacent elements and maximise its sum */
public class MaximumSumOfNonAdjacentElements {

    // State: f(i) = best sum using elements 0..i. For each element choose: TAKE it (then skip i-1: nums[i] + f(i-2)) or SKIP it (f(i-1)).
    // f(i) = max(nums[i] + f(i-2), f(i-1)).  Base: f(0) = nums[0], f(-1) = 0.  O(n) time
    static int memo(int i, int[] a, int[] dp) {
        if (i < 0) return 0;
        if (i == 0) return a[0];
        if (dp[i] != -1) return dp[i];
        int take = a[i] + memo(i - 2, a, dp);
        int skip = memo(i - 1, a, dp);
        return dp[i] = Math.max(take, skip);
    }

    // O(n) time, O(1) space
    static int maxSum(int[] a) {
        int prev2 = 0, prev = 0;                                   // f(i-2), f(i-1)
        for (int x : a) {
            int cur = Math.max(x + prev2, prev);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{2, 1, 4, 9}));                // 11  (2 + 9)
        System.out.println(maxSum(new int[]{1, 2, 4}));                   // 5   (1 + 4)
        System.out.println(maxSum(new int[]{2, 1, 4, 9, 5}));             // 11  (2+4+5 = 11 or 2+9 = 11; 1+9 = 10)
        System.out.println(maxSum(new int[]{5}));                         // 5
        System.out.println(maxSum(new int[]{}));                          // 0
        System.out.println(maxSum(new int[]{-3, -1, -2}));                // 0   (taking nothing is allowed here)
        int[] a = {2, 1, 4, 9};
        int[] dp = new int[a.length];
        Arrays.fill(dp, -1);
        System.out.println(memo(a.length - 1, a, dp));                    // 11
    }
}
