import java.util.ArrayDeque;
import java.util.Deque;

/** Maximal Rectangle (LC 85): largest rectangle containing only '1's in a binary matrix */
public class MaximalRectangle {

    // Build a histogram of consecutive 1s ending at each row, then run Largest Rectangle in Histogram on it.
    // O(rows * cols) time, O(cols) space
    static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int best = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < cols; j++) heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;   // a '0' resets the column
            best = Math.max(best, largestRectangleArea(heights));
        }
        return best;
    }

    private static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int best = 0, n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > h) {
                int height = heights[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                best = Math.max(best, height * (i - left - 1));
            }
            stack.push(i);
        }
        return best;
    }

    public static void main(String[] args) {
        char[][] a = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(a));                              // 6
        System.out.println(maximalRectangle(new char[][]{{'0'}}));            // 0
        System.out.println(maximalRectangle(new char[][]{{'1'}}));            // 1
        System.out.println(maximalRectangle(new char[][]{{'1', '1'}, {'1', '1'}})); // 4
        System.out.println(maximalRectangle(new char[0][]));                  // 0
    }
}
