import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** LC 15 - 3Sum (unique triplets summing to 0) */
public class ThreeSum {

    // Sort + fix i + two pointers: O(n^2) time, O(1) extra space (ignoring output / sort)
    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] > 0) break;                          // smallest > 0 => no triplet possible
            if (i > 0 && nums[i] == nums[i - 1]) continue;   // skip duplicate anchor
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;     // skip dup left
                    while (left < right && nums[right] == nums[right + 1]) right--;  // skip dup right
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(threeSum(new int[]{0, 1, 1}));             // []
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));          // [[0, 0, 0]]
        System.out.println(threeSum(new int[]{}));                    // []
    }
}
