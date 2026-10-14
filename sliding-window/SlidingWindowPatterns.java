/** Sliding Window: Pattern and Template (theory). Four reusable shapes, each shown on a tiny example. */
public class SlidingWindowPatterns {

    // Pattern 1: FIXED-size window. Add the entering element, drop the leaving one. O(n)
    // Example: maximum sum of any k consecutive elements
    static int maxSumOfSizeK(int[] a, int k) {
        int sum = 0, best;
        for (int i = 0; i < k; i++) sum += a[i];
        best = sum;
        for (int right = k; right < a.length; right++) {
            sum += a[right] - a[right - k];                // slide: + new element, - element that left
            best = Math.max(best, sum);
        }
        return best;
    }

    // Pattern 2: LONGEST window satisfying a condition (variable size). Expand right; while INVALID shrink left. O(n)
    // Example: longest subarray with sum <= limit (positive numbers)
    static int longestWithSumAtMost(int[] a, int limit) {
        int left = 0, sum = 0, best = 0;
        for (int right = 0; right < a.length; right++) {
            sum += a[right];
            while (sum > limit) sum -= a[left++];          // shrink until valid again
            best = Math.max(best, right - left + 1);       // window [left, right] is valid here
        }
        return best;
    }

    // Pattern 3: SHORTEST window satisfying a condition. Expand right; while VALID record and shrink left. O(n)
    // Example: shortest subarray with sum >= target (positive numbers)
    static int shortestWithSumAtLeast(int[] a, int target) {
        int left = 0, sum = 0, best = Integer.MAX_VALUE;
        for (int right = 0; right < a.length; right++) {
            sum += a[right];
            while (sum >= target) {
                best = Math.min(best, right - left + 1);   // record BEFORE shrinking
                sum -= a[left++];
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }

    // Pattern 4: COUNT subarrays: exactly(K) = atMost(K) - atMost(K - 1). atMost counts windows ending at `right`
    // Example: number of subarrays with sum <= limit (positive numbers)
    static int countWithSumAtMost(int[] a, int limit) {
        if (limit < 0) return 0;
        int left = 0, sum = 0, count = 0;
        for (int right = 0; right < a.length; right++) {
            sum += a[right];
            while (sum > limit) sum -= a[left++];
            count += right - left + 1;                     // every start in [left, right] gives a valid subarray ending here
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxSumOfSizeK(new int[]{2, 1, 5, 1, 3, 2}, 3));            // 9
        System.out.println(longestWithSumAtMost(new int[]{1, 2, 1, 0, 1, 1, 0}, 4));  // 5
        System.out.println(shortestWithSumAtLeast(new int[]{2, 3, 1, 2, 4, 3}, 7));   // 2  ([4,3])
        System.out.println(shortestWithSumAtLeast(new int[]{1, 1, 1}, 10));           // 0  (impossible)
        System.out.println(countWithSumAtMost(new int[]{1, 2, 3}, 3));                // 4  ([1],[2],[3],[1,2])
        // exactly 3 = atMost(3) - atMost(2)
        System.out.println(countWithSumAtMost(new int[]{1, 2, 3}, 3) - countWithSumAtMost(new int[]{1, 2, 3}, 2)); // 2
    }
}
