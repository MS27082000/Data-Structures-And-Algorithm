import java.util.HashMap;
import java.util.Map;

/**
 * Longest Subarray with Sum K (the array may contain positives, negatives and zeros).
 *
 * Formula: sum of subarray (j+1 .. i) = prefix[i] - prefix[j].
 * We want this to be k, so prefix[j] must be prefix[i] - k. prefix[i] is known, so we search for prefix[j].
 *
 * The map stores: prefix sum -> FIRST index where it appeared (the earliest start gives the longest subarray).
 *
 * Time O(n), space O(n).
 */
public class LongestSubarrayWithSumK {

    static int longestSubarray(int[] arr, long k) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);                              // prefix 0 before index 0 (handles subarrays starting at index 0)
        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Did we see (prefixSum - k) earlier? Then the stretch after it up to i sums to k.
            // Look up BEFORE inserting the current prefix.
            if (map.containsKey(prefixSum - k)) {
                int length = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, length);
            }

            // Store only the FIRST index of this prefix. A later index would only make the subarray shorter.
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{10, 5, 2, 7, 1, 9}, 15));       // 4
        System.out.println(longestSubarray(new int[]{-1, 1, 1}, 1));                 // 3
        System.out.println(longestSubarray(new int[]{2, 3, 5}, 5));                  // 2
        System.out.println(longestSubarray(new int[]{1, 2, 3}, 100));                // 0
        System.out.println(longestSubarray(new int[]{1, -1, 5, -2, 3}, 3));          // 4
    }
}
