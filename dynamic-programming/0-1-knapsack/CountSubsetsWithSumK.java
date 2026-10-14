/** Count Subsets with Sum K (arr may contain 0s, so subsets are counted by INDEX choices, not by distinct values) */
public class CountSubsetsWithSumK {

    // dp[s] = number of ways to reach sum s. For each item: dp[s] += dp[s - x] (iterate downwards). Zeros double the count automatically
    // because including or excluding a 0 gives two different subsets that both keep the same sum. O(n * k) time, O(k) space
    static int countSubsets(int[] arr, int k) {
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int x : arr) {
            for (int s = k; s >= x; s--) dp[s] += dp[s - x];       // for x = 0 this doubles every entry (s - 0 = s), as intended
        }
        return dp[k];
    }

    public static void main(String[] args) {
        System.out.println(countSubsets(new int[]{1, 2, 2, 3}, 3));        // 3  ({1,2}, {1,2}, {3})
        System.out.println(countSubsets(new int[]{1, 1, 1, 1}, 2));        // 6
        System.out.println(countSubsets(new int[]{0, 0, 1}, 1));           // 4  (the 1 plus any subset of the two zeros)
        System.out.println(countSubsets(new int[]{5}, 5));                 // 1
        System.out.println(countSubsets(new int[]{1, 2}, 10));             // 0
        System.out.println(countSubsets(new int[]{4, 6, 2}, 0));           // 1  (the empty subset)
    }
}
