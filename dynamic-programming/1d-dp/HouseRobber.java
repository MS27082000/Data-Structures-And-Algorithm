/** House Robber (LC 198) and House Robber II (LC 213, houses arranged in a CIRCLE): max money without robbing two adjacent houses */
public class HouseRobber {

    // Linear street: the same recurrence as "max sum of non-adjacent elements". O(n) time, O(1) space
    static int rob(int[] nums) {
        return robRange(nums, 0, nums.length - 1);
    }

    private static int robRange(int[] nums, int lo, int hi) {
        int prev2 = 0, prev = 0;
        for (int i = lo; i <= hi; i++) {
            int cur = Math.max(nums[i] + prev2, prev);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    // Circular street: the first and last houses are adjacent, so they can't BOTH be robbed. Either skip the first house or skip the last
    // one, solve each linear problem, and take the better. A single house is a special case. O(n) time, O(1) space
    static int robCircular(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));                    // 4   (1 + 3)
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));                 // 12  (2 + 9 + 1)
        System.out.println(rob(new int[]{}));                              // 0
        System.out.println(robCircular(new int[]{2, 3, 2}));               // 3   (2 and 2 are adjacent in a circle)
        System.out.println(robCircular(new int[]{1, 2, 3, 1}));            // 4
        System.out.println(robCircular(new int[]{1, 2, 3}));               // 3
        System.out.println(robCircular(new int[]{5}));                     // 5   (a single house)
        System.out.println(robCircular(new int[]{200, 3, 140, 20, 10}));   // 340
    }
}
