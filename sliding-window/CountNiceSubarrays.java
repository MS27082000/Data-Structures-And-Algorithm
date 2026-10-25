/**
 * Count Number of Nice Subarrays (LC 1248): count subarrays that contain exactly k ODD numbers.
 *
 * Same pattern as Binary Subarrays With Sum, with "count of odd numbers" in place of "sum":
 *      exactly(k) = atMost(k) - atMost(k - 1)
 *
 *   State to track      : oddCount = number of odd numbers inside the window
 *   Window is invalid   : oddCount > k
 *   When left leaves    : if nums[left] is odd, oddCount--
 *
 * Time O(n), space O(1).
 */
public class CountNiceSubarrays {

    static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    // Counts subarrays with at most k odd numbers.
    private static int atMost(int[] nums, int k) {
        if (k < 0) return 0;                          // no subarray has a negative number of odds

        int left = 0;
        int oddCount = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {
            // 1. add nums[right]
            if (nums[right] % 2 != 0) {
                oddCount++;
            }

            // 2. too many odd numbers: shrink from the left
            while (oddCount > k) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }

            // 3. every subarray ending at right and starting at left..right has at most k odd numbers
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));                        // 2
        System.out.println(numberOfSubarrays(new int[]{2, 4, 6}, 1));                              // 0
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));         // 16
        System.out.println(numberOfSubarrays(new int[]{1}, 1));                                    // 1
        System.out.println(numberOfSubarrays(new int[]{2, 2}, 0));                                 // 3
    }
}
