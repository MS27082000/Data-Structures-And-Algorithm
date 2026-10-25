import java.util.HashMap;
import java.util.Map;

/**
 * Subarray Sum Equals K (LC 560): count the subarrays with sum exactly k (negatives allowed).
 *
 * Formula: sum of subarray (j+1 .. i) = prefix[i] - prefix[j].
 * We want this to be k, so prefix[j] must be prefix[i] - k. prefix[i] is known, so we search for prefix[j].
 *
 * The map stores: prefix sum -> HOW MANY TIMES it appeared.
 * Each earlier occurrence of (prefixSum - k) is a different start, so it gives a different subarray ending at i.
 *
 * Time O(n), space O(n).
 */
public class CountSubarraysWithSumK {

    static int subarraySum(int[] nums, int k) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);                               // the empty prefix (sum 0) has appeared once
        long prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // how many earlier prefixes equal (prefixSum - k)? Each one is a valid subarray ending at i.
            // Look up BEFORE inserting the current prefix.
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // record the current prefix
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));          // 2
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));          // 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));         // 3
        System.out.println(subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7)); // 4
        System.out.println(subarraySum(new int[]{0, 0, 0}, 0));          // 6
    }
}
