/** Binary Subarrays With Sum (LC 930): count subarrays of a 0/1 array whose sum equals goal */
public class BinarySubarraysWithSum {

    // exactly(goal) = atMost(goal) - atMost(goal - 1). Sliding window works because all values are non-negative.
    // O(n) time, O(1) space
    static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;                                  // no subarray has a negative sum
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > goal) sum -= nums[left++];
            count += right - left + 1;                           // all subarrays ending at `right` with sum <= goal
        }
        return count;
    }

    // Alternative: prefix sums + count map (works even with negatives). See prefix-sum/CountSubarraysWithSumK
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));      // 4
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));      // 15
        System.out.println(numSubarraysWithSum(new int[]{1, 1, 1}, 5));            // 0
        System.out.println(numSubarraysWithSum(new int[]{1}, 1));                  // 1
        System.out.println(numSubarraysWithSum(new int[]{0, 1, 0}, 1));            // 4
    }
}
