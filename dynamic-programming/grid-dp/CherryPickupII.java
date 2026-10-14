import java.util.Arrays;

/** Cherry Pickup II (LC 1463): two robots start at the top-left (col 0) and top-right (col n-1) and move down one row at a time, each going
 *  to col-1, col or col+1. Cherries in a cell are collected once (if both stand there, counted once). Maximise the total. */
public class CherryPickupII {

    // State: f(row, c1, c2) = max cherries from this row down with the robots in columns c1 and c2. Both robots move at the SAME time, so
    // one dimension (row) is shared. Each step tries 3 x 3 = 9 combinations. O(rows * cols^2 * 9) time
    static int memo(int r, int c1, int c2, int[][] grid, int[][][] dp) {
        int rows = grid.length, cols = grid[0].length;
        if (c1 < 0 || c2 < 0 || c1 >= cols || c2 >= cols) return Integer.MIN_VALUE / 2;   // out of bounds: a very bad value
        if (r == rows - 1) return c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        if (dp[r][c1][c2] != -1) return dp[r][c1][c2];
        int cherries = c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2];
        int best = Integer.MIN_VALUE / 2;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                best = Math.max(best, memo(r + 1, c1 + d1, c2 + d2, grid, dp));
            }
        }
        return dp[r][c1][c2] = cherries + best;
    }

    static int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        for (int[][] a : dp) for (int[] b : a) Arrays.fill(b, -1);
        return memo(0, 0, cols - 1, grid, dp);
    }

    // Bottom-up with two rolling layers of size cols x cols: O(rows * cols^2 * 9) time, O(cols^2) space
    static int cherryPickupTab(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int NEG = Integer.MIN_VALUE / 2;
        int[][] next = new int[cols][cols];
        for (int c1 = 0; c1 < cols; c1++)
            for (int c2 = 0; c2 < cols; c2++)
                next[c1][c2] = c1 == c2 ? grid[rows - 1][c1] : grid[rows - 1][c1] + grid[rows - 1][c2];
        for (int r = rows - 2; r >= 0; r--) {
            int[][] cur = new int[cols][cols];
            for (int c1 = 0; c1 < cols; c1++) {
                for (int c2 = 0; c2 < cols; c2++) {
                    int best = NEG;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int n1 = c1 + d1, n2 = c2 + d2;
                            if (n1 >= 0 && n1 < cols && n2 >= 0 && n2 < cols) best = Math.max(best, next[n1][n2]);
                        }
                    }
                    cur[c1][c2] = (c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2]) + best;
                }
            }
            next = cur;
        }
        return next[0][cols - 1];
    }

    public static void main(String[] args) {
        int[][] a = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        System.out.println(cherryPickup(a) + " " + cherryPickupTab(a));                                       // 24 24
        int[][] b = {{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}};
        System.out.println(cherryPickup(b) + " " + cherryPickupTab(b));                                       // 28 28
        System.out.println(cherryPickup(new int[][]{{1, 1}, {1, 1}}));                                          // 4
        System.out.println(cherryPickup(new int[][]{{5, 5}}));                                                  // 10  (one row: both cells)
        System.out.println(cherryPickup(new int[][]{{9}, {9}}));                                                // 18  (single column: both robots share the cell, but cherries count once per cell => 9 + 9 over two rows)
    }
}
