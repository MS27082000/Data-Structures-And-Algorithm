import java.util.Arrays;

/**
 * Next Permutation (LC 31): rearrange the array IN PLACE into the next bigger arrangement.
 * If it is already the biggest, change it to the smallest.
 *
 *   [1,2,3] -> [1,3,2]      [1,3,5,4,2] -> [1,4,2,3,5]      [3,2,1] -> [1,2,3]
 *
 *   1. Pivot: from the right, the first number that is smaller than its right neighbour.
 *   2. Swap the pivot with the first number from the right that is bigger than it.
 *   3. Reverse everything after the pivot.
 *
 * Time O(n), space O(1).
 */
public class NextPermutation {

    static void nextPermutation(int[] nums) {
        int pivot = -1;                          // -1 means "no pivot found yet"
        int n = nums.length;

        // Step 1: find the pivot index
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;                           // first one from the right is the one we want
            }
        }

        // Step 2: find the next greater number than the pivot (from the right) and swap
        if (pivot != -1) {
            for (int i = n - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    int temp = nums[i];
                    nums[i] = nums[pivot];
                    nums[pivot] = temp;
                    break;
                }
            }
        }

        // Step 3: reverse the part after the pivot. If pivot == -1 this reverses the whole array.
        reverse(nums, pivot + 1, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[][] tests = {{1, 2, 3}, {3, 2, 1}, {1, 1, 5}, {1, 3, 2}, {2, 3, 1}, {1}, {1, 5, 1}, {1, 3, 5, 4, 2}};
        for (int[] t : tests) {
            nextPermutation(t);
            System.out.println(Arrays.toString(t));
        }
        // [1, 3, 2] [1, 2, 3] [1, 5, 1] [2, 1, 3] [3, 1, 2] [1] [5, 1, 1] [1, 4, 2, 3, 5]
    }
}
