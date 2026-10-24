import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum (LC 18): return all UNIQUE quadruplets [a, b, c, d] with a + b + c + d == target.
 *
 * This is 3Sum with one more fixed number:
 *   1. SORT the array (for two pointers, and so equal numbers sit together).
 *   2. FIX two numbers with two nested loops: nums[i] and nums[j] (j is always after i).
 *   3. For the other two numbers use TWO POINTERS: left = j + 1, right = n - 1.
 *   4. SKIP DUPLICATES at all four positions (i, j, left, right) so no quadruplet repeats.
 *   5. Use LONG for the sum: four ints can add up to more than an int can hold.
 *
 * Time O(n^3), extra space O(1) (ignoring the output list and the sort).
 */
public class FourSum {

    static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);                                   // step 1
        int n = nums.length;

        // i needs three numbers to its right, so it stops at n - 4
        for (int i = 0; i < n - 3; i++) {

            // Duplicate i: same value as the previous i, so every quadruplet starting with it was already found.
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // j needs two numbers to its right, so it stops at n - 3
            for (int j = i + 1; j < n - 2; j++) {

                // Duplicate j. Note "j > i + 1", not "j > 0": the FIRST j after i (j == i + 1) must be allowed
                // even if it equals nums[i], e.g. [2, 2, 2, 2] needs i and j to both be 2.
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // step 3: two pointers on the part to the right of j
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // long, because four numbers up to 10^9 add up to more than Integer.MAX_VALUE
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        left++;
                        right--;

                        // step 4: skip duplicate left / right values after a match
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if (sum < target) {
                        left++;                              // sum too small, take a bigger number
                    } else {
                        right--;                             // sum too big, take a smaller number
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));   // [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        System.out.println(fourSum(new int[]{2, 2, 2, 2, 2}, 8));        // [[2, 2, 2, 2]]
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296)); // [] (no overflow bug)
        System.out.println(fourSum(new int[]{1, 2}, 3));                 // []
    }
}
