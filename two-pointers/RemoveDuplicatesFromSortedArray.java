import java.util.Arrays;

/** LC 26 - Remove Duplicates from Sorted Array (in-place, return new length) */
public class RemoveDuplicatesFromSortedArray {

    // slow = last unique position, fast = scanner. O(n) time, O(1) space
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int k = removeDuplicates(a);
        System.out.println(k + " " + Arrays.toString(Arrays.copyOf(a, k)));   // 2 [1, 2]

        int[] b = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        k = removeDuplicates(b);
        System.out.println(k + " " + Arrays.toString(Arrays.copyOf(b, k)));   // 5 [0, 1, 2, 3, 4]

        System.out.println(removeDuplicates(new int[]{}));                    // 0
    }
}
