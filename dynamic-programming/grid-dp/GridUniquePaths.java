import java.util.Arrays;

/** Unique Paths (LC 62): an m x n grid; a robot moves only RIGHT or DOWN from the top-left to the bottom-right. Count the distinct paths */
public class GridUniquePaths {

    // State: f(r, c) = paths to reach cell (r, c). f(r, c) = f(r-1, c) + f(r, c-1) (arrive from above or from the left). Base: first row/col = 1.
    static int memo(int r, int c, int[][] dp) {
        if (r == 0 || c == 0) return 1;
        if (dp[r][c] != -1) return dp[r][c];
        return dp[r][c] = memo(r - 1, c, dp) + memo(r, c - 1, dp);
    }

    // 1D rolling array: dp[c] holds the value of the cell above until overwritten, dp[c-1] the cell to the left. O(m*n) time, O(n) space
    static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) dp[c] += dp[c - 1];
        }
        return dp[n - 1];
    }

    // Combinatorics: every path has (m-1) downs and (n-1) rights in some order => C(m+n-2, m-1). O(min(m, n)) time, O(1) space
    static long uniquePathsMath(int m, int n) {
        int total = m + n - 2, k = Math.min(m - 1, n - 1);
        long res = 1;
        for (int i = 1; i <= k; i++) res = res * (total - k + i) / i;       // multiply then divide: always exact at every step
        return res;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7) + " " + uniquePathsMath(3, 7));     // 28 28
        System.out.println(uniquePaths(3, 2) + " " + uniquePathsMath(3, 2));     // 3 3
        System.out.println(uniquePaths(1, 1));                                    // 1
        System.out.println(uniquePaths(1, 10) + " " + uniquePaths(10, 1));        // 1 1   (a single row/column has one path)
        System.out.println(uniquePaths(10, 10) + " " + uniquePathsMath(10, 10));  // 48620 48620
        int[][] dp = new int[3][7];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(memo(2, 6, dp));                                       // 28
    }
}
