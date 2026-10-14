import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/** Sliding Window Maximum (LC 239): the maximum of every window of size k */
public class SlidingWindowMaximum {

    // Monotonic DEQUE of INDICES whose values are strictly decreasing from front to back. The front is always the max.
    // Each index is pushed and popped at most once. O(n) time, O(k) space
    static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();            // front index slid out of the window
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();   // smaller elements can never be a max again
            dq.offerLast(i);
            if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];                   // the first full window is at i = k-1
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));  // [3, 3, 5, 5, 6, 7]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)));                            // [1]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{9, 11}, 2)));                        // [11]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{4, 3, 2, 1}, 2)));                   // [4, 3, 2]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 2, 3, 4}, 1)));                   // [1, 2, 3, 4]
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{7, 7, 7, 7}, 3)));                   // [7, 7]
    }
}
