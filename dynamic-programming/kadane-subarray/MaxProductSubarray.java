/** Maximum Product Subarray (LC 152) */
public class MaxProductSubarray {

    // Track both max AND min product ending here (a negative number flips min into max).
    // O(n) time, O(1) space
    static int maxProduct(int[] nums) {
        int curMax = nums[0], curMin = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) {                         // swap: multiplying by a negative flips order
                int t = curMax;
                curMax = curMin;
                curMin = t;
            }
            curMax = Math.max(x, curMax * x);
            curMin = Math.min(x, curMin * x);
            best = Math.max(best, curMax);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));        // 6
        System.out.println(maxProduct(new int[]{-2, 0, -1}));          // 0
        System.out.println(maxProduct(new int[]{-2, 3, -4}));          // 24
        System.out.println(maxProduct(new int[]{-3}));                 // -3
        System.out.println(maxProduct(new int[]{0, 2}));               // 2
        System.out.println(maxProduct(new int[]{-1, -2, -9, -6}));     // 108
    }
}
