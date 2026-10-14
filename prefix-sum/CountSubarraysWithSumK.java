import java.util.HashMap;
import java.util.Map;

/** Subarray Sum Equals K (LC 560): count subarrays with sum exactly k (negatives allowed) */
public class CountSubarraysWithSumK {

    // Prefix sum + HashMap of COUNTS of each prefix. For each i, add count(prefix - k). O(n) time, O(n) space
    static int subarraySum(int[] nums, int k) {
        Map<Long, Integer> count = new HashMap<>();
        count.put(0L, 1);                          // empty prefix
        long prefix = 0;
        int total = 0;
        for (int x : nums) {
            prefix += x;
            total += count.getOrDefault(prefix - k, 0);   // look up BEFORE adding the current prefix
            count.merge(prefix, 1, Integer::sum);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));          // 2
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));          // 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));         // 3
        System.out.println(subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7)); // 4
        System.out.println(subarraySum(new int[]{0, 0, 0}, 0));          // 6
    }
}
