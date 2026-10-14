import java.util.Arrays;

/** LC 167 - Two Sum II (sorted array, 1-indexed result) */
public class TwoSumII {

    // Opposite-ends two pointers: O(n) time, O(1) space
    static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            if (sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));   // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));        // [1, 3]
        System.out.println(Arrays.toString(twoSum(new int[]{-1, 0}, -1)));         // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3}, 100)));      // [-1, -1]
    }
}
