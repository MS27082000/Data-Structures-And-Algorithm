/** Max Consecutive Ones III (LC 1004): longest subarray of 1s after flipping at most k zeros */
public class MaxConsecutiveOnesIII {

    // Longest window containing at most k zeros. O(n) time, O(1) space
    static int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, best = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            while (zeros > k) {                                  // too many zeros: shrink
                if (nums[left] == 0) zeros--;
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    // Non-shrinking variant: the window never gets smaller, it only slides, so its final size is the answer. O(n)
    static int longestOnesNoShrink(int[] nums, int k) {
        int left = 0, zeros = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            if (zeros > k) {                                     // `if`, not `while`: slide by exactly one
                if (nums[left] == 0) zeros--;
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
        System.out.println(longestOnesNoShrink(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));                 // 6
    }
}
