import java.util.ArrayList;
import java.util.List;

/** Longest Increasing Subsequence (LC 300): length of the longest strictly increasing subsequence */
public class LongestIncreasingSubsequence {

    // O(n^2) DP: dp[i] = LIS length ENDING at i = 1 + max(dp[j]) for j < i with nums[j] < nums[i]
    static int lisQuadratic(int[] nums) {
        int n = nums.length, best = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            best = Math.max(best, dp[i]);
        }
        return best;
    }

    // O(n log n) "patience" tails: tails[k] = smallest possible tail of an increasing subsequence of length k + 1. For each x, binary search
    // the first tail >= x and replace it (or append when x is bigger than all). The size of tails is the answer (tails is NOT the LIS itself).
    static int lisFast(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for (int x : nums) {
            int lo = 0, hi = tails.size();
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (tails.get(mid) < x) lo = mid + 1; else hi = mid;     // lower bound: strictly increasing => replace an equal value
            }
            if (lo == tails.size()) tails.add(x); else tails.set(lo, x);
        }
        return tails.size();
    }

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lisQuadratic(a) + " " + lisFast(a));                                  // 4 4  (2, 3, 7, 18)
        System.out.println(lisQuadratic(new int[]{0, 1, 0, 3, 2, 3}) + " " + lisFast(new int[]{0, 1, 0, 3, 2, 3}));   // 4 4
        System.out.println(lisQuadratic(new int[]{7, 7, 7, 7}) + " " + lisFast(new int[]{7, 7, 7, 7}));               // 1 1  (strictly increasing)
        System.out.println(lisFast(new int[]{}));                                                // 0
        System.out.println(lisFast(new int[]{5, 4, 3, 2, 1}));                                   // 1
        System.out.println(lisFast(new int[]{1, 2, 3, 4, 5}));                                   // 5
    }
}
