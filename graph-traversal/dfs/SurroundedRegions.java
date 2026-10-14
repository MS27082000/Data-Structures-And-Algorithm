import java.util.Arrays;

/** Surrounded Regions (LC 130): flip every 'O' region that is completely surrounded by 'X' (not touching the border) to 'X' */
public class SurroundedRegions {

    // 1) From every BORDER 'O' mark the whole connected region as safe ('S').  2) Flip remaining 'O' -> 'X', and 'S' -> 'O'.
    // O(R*C) time, O(R*C) stack
    static void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            mark(board, r, 0);
            mark(board, r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            mark(board, 0, c);
            mark(board, rows - 1, c);
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';     // surrounded: captured
                else if (board[r][c] == 'S') board[r][c] = 'O'; // connected to the border: restore
            }
        }
    }

    private static void mark(char[][] b, int r, int c) {
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] != 'O') return;
        b[r][c] = 'S';
        mark(b, r + 1, c);
        mark(b, r - 1, c);
        mark(b, r, c + 1);
        mark(b, r, c - 1);
    }

    static char[][] board(String... rows) {
        char[][] g = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) g[i] = rows[i].toCharArray();
        return g;
    }

    static String show(char[][] b) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : b) sb.append(new String(row)).append(' ');
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        char[][] a = board("XXXX", "XOOX", "XXOX", "XOXX");
        solve(a);
        System.out.println(show(a));                          // XXXX XXXX XXXX XOXX
        char[][] b = board("X");
        solve(b);
        System.out.println(show(b));                          // X
        char[][] c = board("OOO", "OXO", "OOO");
        solve(c);
        System.out.println(show(c));                          // OOO OXO OOO  (everything touches the border)
        char[][] d = board("XXX", "XOX", "XXX");
        solve(d);
        System.out.println(show(d));                          // XXX XXX XXX
    }
}
