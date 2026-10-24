import java.util.Arrays;

/**
 * LC 16 - 3Sum Closest: return the sum of three numbers that is CLOSEST to target.
 *
 * Same pattern as 3Sum:
 *   1. SORT the array.
 *   2. FIX one number nums[i]. Use two pointers (left = i + 1, right = n - 1) for the other two.
 *   3. For every sum we see, check whether it is closer to target than the best sum so far.
 *   4. Use the sorted order to decide which pointer to move:
 *        sum < target -> we need a bigger sum  -> left++
 *        sum > target -> we need a smaller sum -> right--
 *
 * Difference from 3Sum: we don't look for an exact match. We just remember the closest sum seen
 * ("closest"). So we also don't need duplicate skipping.
 *
 * Time O(n^2), space O(1).
 */
public class ThreeSumClosest {

    static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        // Start with a real triple sum. (Not Integer.MAX_VALUE: subtracting target from it could overflow.)
        int closest = nums[0] + nums[1] + nums[2];

        // i needs two numbers to its right, so it stops at n - 3
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // "Distance" of a sum from target is |sum - target|. A smaller distance means closer.
                // If this sum is closer than the best one so far, remember it.
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }

                if (sum == target) {
                    return sum;              // distance 0, we can't do better
                } else if (sum < target) {
                    left++;                  // sum too small, so take a bigger number on the left
                } else {
                    right--;                 // sum too big, so take a smaller number on the right
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));  // 2
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));       // 0
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100)); // 2
        System.out.println(threeSumClosest(new int[]{1, 2, 4, 8}, 7));    // 7
    }
}
