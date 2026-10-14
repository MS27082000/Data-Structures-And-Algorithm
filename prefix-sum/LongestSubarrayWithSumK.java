import java.util.HashMap;
import java.util.Map;

/** Longest Subarray with Sum K (array may contain positives, negatives and zeros) */
public class LongestSubarrayWithSumK {

    // Prefix sum + HashMap of FIRST occurrence of each prefix. If (prefix - k) was seen at index j,
    // then a[j+1..i] sums to k. O(n) time, O(n) space
    static int longestSubarray(int[] a, long k) {
        Map<Long, Integer> first = new HashMap<>();
        first.put(0L, -1);                         // empty prefix sits before index 0
        long prefix = 0;
        int best = 0;
        for (int i = 0; i < a.length; i++) {
            prefix += a[i];
            Integer j = first.get(prefix - k);
            if (j != null) best = Math.max(best, i - j);
            first.putIfAbsent(prefix, i);          // keep the EARLIEST index to maximise the length
        }
        return best;
    }

    // Positives-only optimisation: sliding window, O(n) time, O(1) space
    static int longestSubarrayPositives(int[] a, long k) {
        int left = 0, best = 0;
        long sum = 0;
        for (int right = 0; right < a.length; right++) {
            sum += a[right];
            while (sum > k && left <= right) sum -= a[left++];
            if (sum == k) best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{10, 5, 2, 7, 1, 9}, 15));       // 4
        System.out.println(longestSubarray(new int[]{-1, 1, 1}, 1));                 // 3
        System.out.println(longestSubarray(new int[]{2, 3, 5}, 5));                  // 2
        System.out.println(longestSubarray(new int[]{1, 2, 3}, 100));                // 0
        System.out.println(longestSubarray(new int[]{1, -1, 5, -2, 3}, 3));          // 4
        System.out.println(longestSubarrayPositives(new int[]{10, 5, 2, 7, 1, 9}, 15)); // 4
    }
}
