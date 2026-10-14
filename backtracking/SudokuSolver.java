/** Sudoku Solver (LC 37): fill the empty cells ('.') so each row, column and 3x3 box contains 1-9 exactly once */
public class SudokuSolver {

    // For each empty cell try digits 1-9 that don't violate row/col/box; undo on failure. O(9^(empty cells)) worst case
    static boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') continue;
                for (char d = '1'; d <= '9'; d++) {
                    if (isValid(board, r, c, d)) {
                        board[r][c] = d;
                        if (solve(board)) return true;
                        board[r][c] = '.';                       // backtrack
                    }
                }
                return false;                                    // no digit fits this cell => dead end
            }
        }
        return true;                                             // no empty cell left
    }

    private static boolean isValid(char[][] b, int r, int c, char d) {
        for (int i = 0; i < 9; i++) {
            if (b[r][i] == d || b[i][c] == d) return false;
            int br = 3 * (r / 3) + i / 3, bc = 3 * (c / 3) + i % 3;   // walk the 3x3 box
            if (b[br][bc] == d) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] puzzle = {
                "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        char[][] board = new char[9][];
        for (int i = 0; i < 9; i++) board[i] = puzzle[i].toCharArray();
        System.out.println(solve(board));                        // true
        for (char[] row : board) System.out.println(new String(row));
        // 534678912 / 672195348 / 198342567 / 859761423 / 426853791 / 713924856 / 961537284 / 287419635 / 345286179
    }
}
