/** Target Sum (LC 494): put + or - in front of every number; count the ways the expression equals `target` */
public class TargetSum {

    // Let P be the numbers given +, N the numbers given -: P - N = target and P + N = total => P = (total + target) / 2.
    // So it is "count subsets with sum P" (same as partitions with a given difference). O(n * P) time, O(P) space
    static int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int x : nums) total += x;
        if (Math.abs(target) > total || (total + target) % 2 != 0) return 0;
        int need = (total + target) / 2;
        int[] dp = new int[need + 1];
        dp[0] = 1;
        for (int x : nums) {
            for (int s = need; s >= x; s--) dp[s] += dp[s - x];       // zeros double the count: +0 and -0 are different expressions
        }
        return dp[need];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));    // 5
        System.out.println(findTargetSumWays(new int[]{1}, 1));                // 1
        System.out.println(findTargetSumWays(new int[]{1}, 2));                // 0
        System.out.println(findTargetSumWays(new int[]{0, 0, 0, 0, 1}, 1));    // 16 (each zero can be + or -)
        System.out.println(findTargetSumWays(new int[]{1, 2, 3}, -6));         // 1  (all minus)
        System.out.println(findTargetSumWays(new int[]{2, 3}, 4));             // 0  (parity: total + target = 9 is odd)
    }
}
