import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 15 - 3Sum: return all UNIQUE triplets [a, b, c] with a + b + c == 0.
 *
 * Approach:
 *   1. SORT the array. This helps in two ways: two pointers become possible, and equal numbers sit next to each other,
 *      so skipping duplicates is easy.
 *   2. FIX one number nums[i] (the "anchor"). Now we need two other numbers, to the right of i, that add up to -nums[i].
 *      That is exactly Two Sum II (sorted array), solved with two pointers: left = i + 1, right = n - 1.
 *   3. DUPLICATES: we must not report the same triplet twice. We skip repeated values in three places:
 *        - the anchor i,
 *        - left (after a match),
 *        - right (after a match).
 *
 * Time O(n^2), extra space O(1) (ignoring the output list and the sort).
 */
public class ThreeSum {

    static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);                       // step 1: sort
        int n = nums.length;

        // i only needs to go up to n - 3, because we need two more numbers to its right
        for (int i = 0; i < n - 2; i++) {

            // The array is sorted. If the smallest number is already positive, all three numbers are positive,
            // so the sum can never be 0. We can stop completely.
            if (nums[i] > 0) break;

            // Duplicate anchor: if this value is the same as the previous anchor, we already found every triplet
            // that starts with this value, so skip it.
            // We compare with the PREVIOUS element (i - 1), not the next one. That way the FIRST copy is used
            // and only the later copies are skipped. (Comparing with the next element would skip the first copy
            // and lose triplets like [-1, -1, 2].)
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // step 2: two pointers on the part to the right of i
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // move both pointers inward
                    left++;
                    right--;

                    // step 3: skip duplicates, so the same triplet is not added again.
                    // Move left forward while it equals the value just before it.
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Move right backward while it equals the value just after it.
                    while (left < right && nums[right] == nums[right + 1]) right--;

                } else if (sum < 0) {
                    left++;                      // sum too small: we need a bigger number, so move left forward
                } else {
                    right--;                     // sum too big: we need a smaller number, so move right backward
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
