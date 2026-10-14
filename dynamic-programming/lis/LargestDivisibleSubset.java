import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Largest Divisible Subset (LC 368): the largest subset where every pair (a, b) satisfies a % b == 0 or b % a == 0 */
public class LargestDivisibleSubset {

    // Sort first. In a sorted chain, divisibility is TRANSITIVE: if each element divides the next, every pair divides. So this is an LIS where
    // the "increasing" condition is nums[i] % nums[j] == 0. Use parents to rebuild. O(n^2) time, O(n) space
    static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        Arrays.sort(nums);
        int[] dp = new int[n], parent = new int[n];
        int bestIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > dp[bestIdx]) bestIdx = i;
        }
        for (int i = bestIdx; i != -1; i = parent[i]) res.add(nums[i]);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));              // [1, 2]  ([1, 3] is also valid)
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));           // [1, 2, 4, 8]
        System.out.println(largestDivisibleSubset(new int[]{3, 4, 16, 8}));          // [4, 8, 16]
        System.out.println(largestDivisibleSubset(new int[]{5}));                    // [5]
        System.out.println(largestDivisibleSubset(new int[]{2, 3, 7, 11}));          // [2]  (any single element is valid)
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 3, 9, 18}));    // [1, 3, 9, 18]
    }
}
