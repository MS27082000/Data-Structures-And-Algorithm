/**
 * Max Consecutive Ones III (LC 1004): longest subarray of 1s after flipping at most k zeros.
 *
 * "Flip at most k zeros" = "the window may contain at most k zeros".
 * So we find the LONGEST WINDOW with at most k zeros.
 *
 *   State to track      : zeros = number of zeros inside the window
 *   Window is invalid   : zeros > k
 *   When left leaves    : if nums[left] == 0, zeros--
 *
 * Time O(n), space O(1).
 */
public class MaxConsecutiveOnesIII {

    static int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;                          // a new cell enters the window
            }

            while (zeros > k) {                   // too many zeros: shrink from the left
                if (nums[left] == 0) {
                    zeros--;                      // the cell leaving was a zero
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);   // window is valid here
        }
        return maxLen;
    }

    // Non-shrinking variant: `if` instead of `while`. The window never gets smaller, it only slides,
    // so its final size (n - left) is the answer. Same O(n), simpler code.
    static int longestOnesNoShrink(int[] nums, int k) {
        int left = 0;
        int zeros = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }
            if (zeros > k) {                      // slide by exactly one step
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }
        }
        return nums.length - left;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));                         // 6
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3)); // 10
        System.out.println(longestOnes(new int[]{0, 0, 0}, 0));                                                 // 0
        System.out.println(longestOnes(new int[]{1, 1, 1}, 0));                                                 // 3
        System.out.println(longestOnes(new int[]{1, 1, 0, 0, 1}, 1));                                           // 3
        System.out.println(longestOnesNoShrink(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));                 // 6
    }
}
