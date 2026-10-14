/** Kadane's Algorithm - Maximum Subarray (LC 53) */
public class KadanesAlgorithm {

    // O(n) time, O(1) space. At each element: extend the current subarray, or start fresh from here.
    static int maxSubArray(int[] nums) {
        int current = nums[0], best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    // Variant: also return the subarray bounds (common follow-up)
    static int[] maxSubArrayWithRange(int[] nums) {
        int current = nums[0], best = nums[0];
        int start = 0, bestStart = 0, bestEnd = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > current + nums[i]) {
                current = nums[i];
                start = i;
            } else {
                current += nums[i];
            }
            if (current > best) {
                best = current;
                bestStart = start;
                bestEnd = i;
            }
        }
        return new int[]{best, bestStart, bestEnd};
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));   // 6
        System.out.println(maxSubArray(new int[]{1}));                               // 1
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));                  // 23
        System.out.println(maxSubArray(new int[]{-3, -1, -2}));                      // -1 (all negative)
        int[] r = maxSubArrayWithRange(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(r[0] + " from " + r[1] + " to " + r[2]);                  // 6 from 3 to 6
    }
}
