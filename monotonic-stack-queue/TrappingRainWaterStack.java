import java.util.ArrayDeque;
import java.util.Deque;

/** Trapping Rain Water (LC 42), monotonic STACK approach. (The O(1)-space two-pointer solution is in two-pointers/TrappingRainWater) */
public class TrappingRainWaterStack {

    // Keep a stack of indices with decreasing heights. When a taller bar arrives, the popped bar is a "valley" bounded by
    // the new bar (right) and the new stack top (left): add water for the layer between them. O(n) time, O(n) space
    static int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int water = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.isEmpty()) break;                       // no left wall: nothing can be trapped here
                int left = stack.peek();
                int width = i - left - 1;
                int boundedHeight = Math.min(height[i], height[left]) - height[bottom];
                water += width * boundedHeight;
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));   // 6
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));                     // 9
        System.out.println(trap(new int[]{1, 2, 3}));                              // 0
        System.out.println(trap(new int[]{3, 0, 3}));                              // 3
        System.out.println(trap(new int[]{}));                                     // 0
    }
}
