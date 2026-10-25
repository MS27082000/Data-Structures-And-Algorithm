import java.util.HashMap;
import java.util.Map;

/**
 * Largest Subarray with Sum 0.
 *
 * This is "Longest Subarray with Sum K" with k = 0.
 * (prefixSum - k) becomes prefixSum, so we ask: "have I seen this same prefix sum before?"
 * If yes, the elements between the two positions add up to 0.
 *
 * The map stores: prefix sum -> FIRST index where it appeared.
 *
 * Time O(n), space O(n).
 */
public class LargestSubarrayWithSumZero {

    static int maxLen(int[] arr) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);                              // prefix 0 before index 0
        long prefixSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                // seen before: the stretch between that index and i sums to 0
                int length = i - map.get(prefixSum);
                maxLen = Math.max(maxLen, length);
            } else {
                map.put(prefixSum, i);                // store only the FIRST index
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{15, -2, 2, -8, 1, 7, 10, 23}));  // 5
        System.out.println(maxLen(new int[]{1, 2, 3}));                      // 0
        System.out.println(maxLen(new int[]{0, 0, 0}));                      // 3
        System.out.println(maxLen(new int[]{1, -1}));                        // 2
        System.out.println(maxLen(new int[]{}));                             // 0
    }
}
