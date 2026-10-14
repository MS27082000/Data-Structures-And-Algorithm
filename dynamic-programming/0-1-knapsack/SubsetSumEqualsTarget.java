/** Subset Sum Equals to Target: is there a subset of arr with sum exactly `target`? (non-negative numbers) */
public class SubsetSumEqualsTarget {

    // State: dp[i][s] = can the first i items form sum s. Each item: skip it (dp[i-1][s]) or take it (dp[i-1][s - arr[i-1]]). dp[*][0] = true.
    // Space optimised to one row: iterate s DOWNWARDS so each item is used at most once. O(n * target) time, O(target) space
    static boolean subsetSum(int[] arr, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int x : arr) {
            for (int s = target; s >= x; s--) {
                if (dp[s - x]) dp[s] = true;
            }
        }
        return dp[target];
    }

    // Top-down version, memoised on (index, remaining target)
    static boolean memo(int i, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) return true;
        if (i == 0) return arr[0] == target;
        if (dp[i][target] != null) return dp[i][target];
        boolean notTake = memo(i - 1, target, arr, dp);
        boolean take = arr[i] <= target && memo(i - 1, target - arr[i], arr, dp);
        return dp[i][target] = notTake || take;
    }

    public static void main(String[] args) {
        int[] a = {3, 34, 4, 12, 5, 2};
        System.out.println(subsetSum(a, 9) + " " + memo(a.length - 1, 9, a, new Boolean[a.length][10]));     // true true  (4 + 5)
        System.out.println(subsetSum(a, 30));                                                                // false
        System.out.println(subsetSum(new int[]{1, 2, 3}, 0));                                                // true (the empty subset)
        System.out.println(subsetSum(new int[]{5}, 5));                                                      // true
        System.out.println(subsetSum(new int[]{2, 4, 6}, 7));                                                // false (all even)
        System.out.println(subsetSum(new int[]{1, 2, 3, 4, 5}, 15));                                         // true (all of them)
    }
}
