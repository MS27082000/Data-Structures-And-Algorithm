import java.util.Arrays;

/** LC 283 - Move Zeroes (in-place, keep order of non-zeros) */
public class MoveZeroes {

    // slow = next slot for non-zero. Swap avoids a second "fill zeros" loop. O(n) time, O(1) space
    static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(Arrays.toString(a)); // [1, 3, 12, 0, 0]

        int[] b = {0};
        moveZeroes(b);
        System.out.println(Arrays.toString(b)); // [0]

        int[] c = {1, 2, 3};
        moveZeroes(c);
        System.out.println(Arrays.toString(c)); // [1, 2, 3]
    }
}
