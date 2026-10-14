import java.util.ArrayDeque;
import java.util.Deque;

/** Largest Rectangle in Histogram (LC 84) */
public class LargestRectangleHistogram {

    // Stack of indices with INCREASING heights. When a shorter bar arrives, each popped bar is the minimum of a rectangle:
    // its width runs from (new stack top + 1) to (i - 1). A sentinel height 0 at the end flushes the stack. O(n), O(n)
    static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int best = 0, n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();   // previous smaller bar (or -1)
                best = Math.max(best, height * (i - left - 1));   // right boundary is i (next smaller)
            }
            stack.push(i);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));   // 10
        System.out.println(largestRectangleArea(new int[]{2, 4}));               // 4
        System.out.println(largestRectangleArea(new int[]{1, 1, 1, 1}));         // 4
        System.out.println(largestRectangleArea(new int[]{5}));                  // 5
        System.out.println(largestRectangleArea(new int[]{6, 5, 4, 3, 2, 1}));   // 12
        System.out.println(largestRectangleArea(new int[]{0, 0}));               // 0
        System.out.println(largestRectangleArea(new int[]{}));                   // 0
    }
}
