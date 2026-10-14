import java.util.ArrayDeque;
import java.util.Deque;

/** Sum of Subarray Minimums (LC 907): sum of min(subarray) over all subarrays, modulo 1e9+7 */
public class SumOfSubarrayMinimums {

    private static final long MOD = 1_000_000_007L;

    // Contribution technique: arr[i] is the minimum of (left choices) * (right choices) subarrays, where
    //   left  = i - (index of previous SMALLER element)      (strictly smaller)
    //   right = (index of next SMALLER-OR-EQUAL element) - i  (<= on ONE side only, to avoid double counting ties)
    // O(n) time, O(n) space
    static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {                                   // previous strictly smaller
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {                              // next smaller-or-equal
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        long total = 0;
        for (int i = 0; i < n; i++) total = (total + (long) arr[i] * left[i] % MOD * right[i]) % MOD;
        return (int) total;
    }

    static int bruteForce(int[] arr) {                                  // O(n^2) check
        long total = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                total += min;
            }
        }
        return (int) (total % MOD);
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));            // 17
        System.out.println(sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));     // 444
        System.out.println(sumSubarrayMins(new int[]{2, 2, 2}));               // 12 (ties are counted once)
        System.out.println(sumSubarrayMins(new int[]{5}));                     // 5
        System.out.println(sumSubarrayMins(new int[]{1, 2, 3, 4, 5}) == bruteForce(new int[]{1, 2, 3, 4, 5}));   // true
        System.out.println(sumSubarrayMins(new int[]{3, 1, 3, 1, 3}) == bruteForce(new int[]{3, 1, 3, 1, 3}));   // true
    }
}
