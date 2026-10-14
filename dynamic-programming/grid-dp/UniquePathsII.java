/** Unique Paths II (LC 63): like Unique Paths, but cells marked 1 are OBSTACLES */
public class UniquePathsII {

    // f(r, c) = 0 on an obstacle; otherwise f(r-1, c) + f(r, c-1). Start cell = 1 unless it is an obstacle. O(m*n) time, O(n) space
    static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0] == 1 ? 0 : 1;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    dp[c] = 0;                                      // an obstacle: no path can pass through this cell
                } else if (c > 0) {
                    dp[c] += dp[c - 1];                             // dp[c] (above) + dp[c-1] (left)
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));   // 2
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));                    // 1
        System.out.println(uniquePathsWithObstacles(new int[][]{{1}}));                               // 0  (the start is blocked)
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0}, {0, 1}}));                    // 0  (the destination is blocked)
        System.out.println(uniquePathsWithObstacles(new int[][]{{0}}));                               // 1
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0, 0}}));                      // 1
    }
}
