/** Subarrays with K Different Integers (LC 992): count subarrays that contain EXACTLY k distinct integers */
public class SubarraysWithKDistinct {

    // exactly(k) = atMost(k) - atMost(k - 1). Values are in 1..n, so a plain array replaces the HashMap.
    // O(n) time, O(n) space
    static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        if (k <= 0) return 0;
        int[] freq = new int[nums.length + 1];
        int left = 0, distinct = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]]++ == 0) distinct++;
            while (distinct > k) {
                if (--freq[nums[left++]] == 0) distinct--;
            }
            count += right - left + 1;                           // all windows ending at `right` with <= k distinct
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));      // 7
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));      // 3
        System.out.println(subarraysWithKDistinct(new int[]{1, 1, 1}, 1));            // 6
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 3}, 4));            // 0
        System.out.println(subarraysWithKDistinct(new int[]{2, 1, 1, 1, 2}, 1));      // 8
    }
}
