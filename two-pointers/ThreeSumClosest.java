import java.util.Arrays;

/** LC 16 - 3Sum Closest */
public class ThreeSumClosest {

    // Sort + fix i + two pointers: O(n^2) time, O(1) space
    static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(closest - target)) closest = sum;
                if (sum == target) return sum;   // can't do better
                if (sum < target) left++;
                else right--;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));  // 2
        System.out.println(threeSumClosest(new int[]{0, 0, 0}, 1));       // 0
        System.out.println(threeSumClosest(new int[]{1, 1, 1, 0}, -100)); // 2
    }
}
