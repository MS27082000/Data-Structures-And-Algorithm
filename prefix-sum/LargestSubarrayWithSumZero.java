import java.util.HashMap;
import java.util.Map;

/** Largest Subarray with Sum 0 */
public class LargestSubarrayWithSumZero {

    // Same prefix-sum idea with k = 0: if the same prefix appears twice, the elements between sum to 0.
    // O(n) time, O(n) space
    static int maxLen(int[] a) {
        Map<Long, Integer> first = new HashMap<>();
        first.put(0L, -1);
        long prefix = 0;
        int best = 0;
        for (int i = 0; i < a.length; i++) {
            prefix += a[i];
            Integer j = first.get(prefix);
            if (j != null) best = Math.max(best, i - j);
            else first.put(prefix, i);             // store only the first occurrence
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{15, -2, 2, -8, 1, 7, 10, 23}));  // 5
        System.out.println(maxLen(new int[]{1, 2, 3}));                      // 0
        System.out.println(maxLen(new int[]{0, 0, 0}));                      // 3
        System.out.println(maxLen(new int[]{1, -1}));                        // 2
        System.out.println(maxLen(new int[]{}));                             // 0
    }
}
