import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** N-Queens (LC 51): place n queens on an n x n board so none attack each other; return all boards */
public class NQueens {

    // One queen per row. O(1) conflict checks with three boolean arrays: column, "/" diagonal (r + c), "\" diagonal (r - c + n - 1)
    // O(n!) time, O(n) space
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        place(0, n, board, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], res);
        return res;
    }

    private static void place(int row, int n, char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2,
                              List<List<String>> res) {
        if (row == n) {
            List<String> snapshot = new ArrayList<>();
            for (char[] r : board) snapshot.add(new String(r));
            res.add(snapshot);
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row + col, d2 = row - col + n - 1;
            if (cols[col] || diag1[d1] || diag2[d2]) continue;      // attacked
            board[row][col] = 'Q';
            cols[col] = diag1[d1] = diag2[d2] = true;
            place(row + 1, n, board, cols, diag1, diag2, res);
            board[row][col] = '.';                                  // backtrack
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));            // [[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]
        System.out.println(solveNQueens(1));            // [[Q]]
        System.out.println(solveNQueens(2).size());     // 0
        System.out.println(solveNQueens(3).size());     // 0
        System.out.println(solveNQueens(8).size());     // 92
    }
}
