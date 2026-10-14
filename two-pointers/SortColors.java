import java.util.Arrays;

/** LC 75 - Sort Colors (Dutch National Flag), one pass, in-place */
public class SortColors {

    // low: next slot for 0, high: next slot for 2, mid: scanner. O(n) time, O(1) space
    static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);   // do NOT mid++ : swapped-in value is unchecked
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0};
        sortColors(a);
        System.out.println(Arrays.toString(a)); // [0, 0, 1, 1, 2, 2]

        int[] b = {2, 0, 1};
        sortColors(b);
        System.out.println(Arrays.toString(b)); // [0, 1, 2]

        int[] c = {1};
        sortColors(c);
        System.out.println(Arrays.toString(c)); // [1]
    }
}
