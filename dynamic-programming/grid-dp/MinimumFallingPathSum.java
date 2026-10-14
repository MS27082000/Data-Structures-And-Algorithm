/** Minimum Falling Path Sum (LC 931): start at ANY cell of the first row; from (r, c) move to (r+1, c-1), (r+1, c) or (r+1, c+1). Minimise the sum */
public class MinimumFallingPathSum {

    // f(r, c) = matrix[r][c] + min(f(r-1, c-1), f(r-1, c), f(r-1, c+1)) (those that exist). Answer = min of the last row.
    // O(n^2) time, O(n) space with a rolling row
    static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = matrix[0].clone();
        for (int r = 1; r < n; r++) {
            int[] cur = new int[n];
            for (int c = 0; c < n; c++) {
                int best = prev[c];
                if (c > 0) best = Math.min(best, prev[c - 1]);
                if (c < n - 1) best = Math.min(best, prev[c + 1]);
                cur[c] = matrix[r][c] + best;
            }
            prev = cur;
        }
        int ans = Integer.MAX_VALUE;
        for (int v : prev) ans = Math.min(ans, v);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}}));   // 13  (1 + 5 + 7)
        System.out.println(minFallingPathSum(new int[][]{{-19, 57}, {-40, -5}}));               // -59 (-19 + -40)
        System.out.println(minFallingPathSum(new int[][]{{5}}));                                // 5
        System.out.println(minFallingPathSum(new int[][]{{1, 2}, {3, 4}}));                     // 4   (1 + 3)
        System.out.println(minFallingPathSum(new int[][]{{100, -42, -46, -41}, {31, 97, 10, -10}, {-58, -51, 82, 89}, {51, 81, 69, -51}}));   // -36
    }
}
