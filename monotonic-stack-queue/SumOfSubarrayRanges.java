import java.util.ArrayDeque;
import java.util.Deque;

/** Sum of Subarray Ranges (LC 2104): range = max - min of a subarray. Sum of ranges over all subarrays */
public class SumOfSubarrayRanges {

    // sum of ranges = (sum of subarray MAXIMUMS) - (sum of subarray MINIMUMS). Each via the monotonic-stack contribution trick.
    // O(n) time, O(n) space. long: the answer can exceed int
    static long subArrayRanges(int[] nums) {
        return sumOfExtremes(nums, true) - sumOfExtremes(nums, false);
    }

    // maxMode = true -> sum of subarray maximums; false -> sum of subarray minimums
    private static long sumOfExtremes(int[] a, boolean maxMode) {
        int n = a.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {                                    // previous element that is strictly better
            while (!stack.isEmpty() && worseOrEqual(a[stack.peek()], a[i], maxMode)) stack.pop();
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {                               // next element that is better-or-equal (ties on one side)
            while (!stack.isEmpty() && worse(a[stack.peek()], a[i], maxMode)) stack.pop();
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        long total = 0;
        for (int i = 0; i < n; i++) total += (long) a[i] * left[i] * right[i];
        return total;
    }

    // for maxMode: x is "worse or equal" than y if x <= y; for minMode: x >= y
    private static boolean worseOrEqual(int x, int y, boolean maxMode) { return maxMode ? x <= y : x >= y; }
    private static boolean worse(int x, int y, boolean maxMode) { return maxMode ? x < y : x > y; }

    static long bruteForce(int[] a) {
        long total = 0;
        for (int i = 0; i < a.length; i++) {
            int min = a[i], max = a[i];
            for (int j = i; j < a.length; j++) {
                min = Math.min(min, a[j]);
                max = Math.max(max, a[j]);
                total += max - min;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(subArrayRanges(new int[]{1, 2, 3}));              // 4
        System.out.println(subArrayRanges(new int[]{1, 3, 3}));              // 4
        System.out.println(subArrayRanges(new int[]{4, -2, -3, 4, 1}));      // 59
        System.out.println(subArrayRanges(new int[]{5}));                    // 0
        System.out.println(subArrayRanges(new int[]{2, 2, 2}));              // 0
        System.out.println(subArrayRanges(new int[]{3, 1, 4, 1, 5, 9, 2}) == bruteForce(new int[]{3, 1, 4, 1, 5, 9, 2})); // true
    }
}
