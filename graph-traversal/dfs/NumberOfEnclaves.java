/** Number of Enclaves (LC 1020): count land cells (1) from which you can NOT walk off the grid boundary */
public class NumberOfEnclaves {

    // Reverse thinking: flood-fill from every BORDER land cell (those can escape) and sink them; the land cells left are enclaves.
    // O(R*C) time, O(R*C) stack
    static int numEnclaves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            sink(grid, r, 0);
            sink(grid, r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            sink(grid, 0, c);
            sink(grid, rows - 1, c);
        }
        int count = 0;
        for (int[] row : grid) for (int cell : row) count += cell;       // whatever 1 remains is enclosed
        return count;
    }

    private static void sink(int[][] g, int r, int c) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] != 1) return;
        g[r][c] = 0;
        sink(g, r + 1, c);
        sink(g, r - 1, c);
        sink(g, r, c + 1);
        sink(g, r, c - 1);
    }

    public static void main(String[] args) {
        System.out.println(numEnclaves(new int[][]{{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));   // 3
        System.out.println(numEnclaves(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}));   // 0
        System.out.println(numEnclaves(new int[][]{{1}}));                                                      // 0 (a border cell)
        System.out.println(numEnclaves(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));                          // 1
        System.out.println(numEnclaves(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));                          // 0 (everything touches the border)
    }
}
