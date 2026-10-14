/** Matrix Chain Multiplication: dims[] where matrix i has size dims[i-1] x dims[i]. Minimum number of scalar multiplications to multiply the chain */
public class MatrixChainMultiplication {

    // Interval DP: f(i, j) = min cost to multiply matrices i..j. Try every split k (i <= k < j):
    //   f(i, j) = min over k of f(i, k) + f(k+1, j) + dims[i-1] * dims[k] * dims[j].    f(i, i) = 0.
    // Fill by increasing chain length. O(n^3) time, O(n^2) space
    static int matrixChain(int[] dims) {
        int n = dims.length - 1;                          // number of matrices
        if (n < 2) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(matrixChain(new int[]{10, 20, 30, 40, 30}));       // 30000
        System.out.println(matrixChain(new int[]{10, 20, 30}));               // 6000
        System.out.println(matrixChain(new int[]{40, 20, 30, 10, 30}));       // 26000
        System.out.println(matrixChain(new int[]{10, 30, 5, 60}));            // 4500
        System.out.println(matrixChain(new int[]{5, 10}));                    // 0  (a single matrix)
    }
}
