import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/** Next Greater Element I (LC 496): for each x in nums1 (a subset of nums2) find the next greater element to its right in nums2 */
public class NextGreaterElement {

    // Monotonic (decreasing) stack over nums2: when a bigger element arrives, it is the answer for everything it pops.
    // O(n + m) time, O(n) space
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> next = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : nums2) {
            while (!stack.isEmpty() && stack.peek() < x) next.put(stack.pop(), x);
            stack.push(x);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) res[i] = next.getOrDefault(nums1[i], -1);   // leftovers have no greater element
        return res;
    }

    // General form: next greater element for EVERY index of an array (right to left scan). O(n)
    static int[] nextGreaterForAll(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();                  // holds candidate VALUES, decreasing from bottom to top
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= a[i]) stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(a[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));   // [-1, 3, -1]
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));      // [3, -1]
        System.out.println(Arrays.toString(nextGreaterForAll(new int[]{1, 3, 2, 4})));                        // [3, 4, 4, -1]
        System.out.println(Arrays.toString(nextGreaterForAll(new int[]{5, 4, 3, 2, 1})));                     // [-1, -1, -1, -1, -1]
        System.out.println(Arrays.toString(nextGreaterForAll(new int[]{2, 2, 2})));                           // [-1, -1, -1]
    }
}
