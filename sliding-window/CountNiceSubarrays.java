/** Count Number of Nice Subarrays (LC 1248): subarrays containing exactly k ODD numbers */
public class CountNiceSubarrays {

    // Odd -> 1, even -> 0 turns this into "Binary Subarrays With Sum = k". exactly(k) = atMost(k) - atMost(k - 1). O(n), O(1)
    static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        if (k < 0) return 0;
        int left = 0, odds = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            odds += nums[right] & 1;                             // 1 if odd (works for negatives too)
            while (odds > k) odds -= nums[left++] & 1;
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
