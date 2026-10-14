import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/** Next Greater Element II (LC 503): the array is CIRCULAR, so the search wraps around */
public class NextGreaterElementII {

    // Simulate the circle by scanning indices 2n-1 .. 0 and using i % n. O(n) time, O(n) space
    static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();                  // candidate values
        for (int i = 2 * n - 1; i >= 0; i--) {
            int x = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= x) stack.pop();
            if (i < n && !stack.isEmpty()) res[i] = stack.peek();   // fill answers only during the real (first) pass
            stack.push(x);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));        // [2, -1, 2]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));  // [2, 3, 4, -1, 4]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{5, 4, 3, 2, 1})));  // [-1, 5, 5, 5, 5]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{7})));              // [-1]
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{2, 2, 2})));        // [-1, -1, -1]
    }
}
