import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Two Sum (LC 1): indices of two numbers adding to target (unsorted array, exactly one answer) */
public class TwoSum {

    // HashMap value -> index. Check the complement BEFORE inserting the current element.
    // O(n) time, O(n) space
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) return new int[]{seen.get(need), i};
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));   // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));        // [1, 2] (not [0, 0]!)
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));           // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2}, 10)));          // [-1, -1]
    }
}
