/** Word Search (LC 79): does the word exist in the grid via adjacent (up/down/left/right) cells, each cell used once? */
public class WordSearch {

    // DFS from every cell; mark the cell visited in place and restore it on the way back. O(m * n * 3^L) time, O(L) stack
    static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] b, String word, int index, int r, int c) {
        if (index == word.length()) return true;
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] != word.charAt(index)) return false;
        char saved = b[r][c];
        b[r][c] = '#';                                            // mark visited
        boolean found = dfs(b, word, index + 1, r + 1, c) || dfs(b, word, index + 1, r - 1, c)
                || dfs(b, word, index + 1, r, c + 1) || dfs(b, word, index + 1, r, c - 1);
        b[r][c] = saved;                                          // backtrack: restore
        return found;
    }

    public static void main(String[] args) {
        char[][] g = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(g, "ABCCED"));    // true
        System.out.println(exist(g, "SEE"));       // true
        System.out.println(exist(g, "ABCB"));      // false (cell reuse is not allowed)
        System.out.println(exist(new char[][]{{'a'}}, "a"));    // true
        System.out.println(exist(new char[][]{{'a', 'a'}}, "aaa")); // false
    }
}
