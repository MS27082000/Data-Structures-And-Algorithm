import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/** Next Smaller Element: for each element find the first strictly smaller element to its RIGHT (-1 if none) */
public class NextSmallerElement {

    // Mirror of Next Greater Element: scan right to left, keep a stack of candidates that is increasing toward the top.
    // O(n) time, O(n) space
    static int[] nextSmaller(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) stack.pop();   // >= : equal values are not "smaller"
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(a[i]);
        }
        return res;
    }

    // Previous smaller element (to the LEFT): scan left to right
    static int[] previousSmaller(int[] a) {
        int n = a.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(a[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextSmaller(new int[]{4, 8, 5, 2, 25})));       // [2, 5, 2, -1, -1]
        System.out.println(Arrays.toString(nextSmaller(new int[]{13, 7, 6, 12})));          // [7, 6, -1, -1]
        System.out.println(Arrays.toString(nextSmaller(new int[]{1, 2, 3})));               // [-1, -1, -1]
        System.out.println(Arrays.toString(nextSmaller(new int[]{3, 3, 3})));               // [-1, -1, -1]
        System.out.println(Arrays.toString(previousSmaller(new int[]{4, 8, 5, 2, 25})));    // [-1, 4, 4, -1, 2]
    }
}
