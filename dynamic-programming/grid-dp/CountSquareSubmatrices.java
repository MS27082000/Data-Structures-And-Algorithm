/** Count Square Submatrices with All Ones (LC 1277) */
public class CountSquareSubmatrices {

    // State: dp[i][j] = side of the LARGEST all-ones square whose BOTTOM-RIGHT corner is (i, j). For a 1:
    //   dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]).   A cell with dp = k is the corner of exactly k squares (sides 1..k),
    // so the answer is the sum of all dp values. O(m*n) time, O(m*n) space (can be reduced to O(n))
    static int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, total = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    total += dp[i][j];
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));   // 15  (10 of size 1, 4 of size 2, 1 of size 3)
        System.out.println(countSquares(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));             // 7
        System.out.println(countSquares(new int[][]{{1}}));                                         // 1
        System.out.println(countSquares(new int[][]{{0, 0}, {0, 0}}));                              // 0
        System.out.println(countSquares(new int[][]{{1, 1}, {1, 1}}));                              // 5   (4 singles + 1 square of side 2)
    }
}
