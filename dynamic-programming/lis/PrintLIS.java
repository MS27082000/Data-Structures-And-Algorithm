import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Print the Longest Increasing Subsequence (one valid LIS) */
public class PrintLIS {

    // Same O(n^2) DP, plus parent[i] = the previous index in the best chain ending at i. Rebuild by walking parents back from the best index
    // and reversing. O(n^2) time, O(n) space
    static List<Integer> printLIS(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        int[] dp = new int[n], parent = new int[n];
        int bestIdx = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            parent[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
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
        System.out.println(printLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));     // [2, 5, 7, 101]  (several LIS of length 4 exist; this is one)
        System.out.println(printLIS(new int[]{5, 4, 3}));                         // [5]
        System.out.println(printLIS(new int[]{1, 2, 3, 4}));                      // [1, 2, 3, 4]
        System.out.println(printLIS(new int[]{}));                                // []
        System.out.println(printLIS(new int[]{0, 8, 4, 12, 2}));                  // [0, 8, 12]
    }
}
