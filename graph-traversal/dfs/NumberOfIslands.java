/** Number of Islands (LC 200): count groups of '1's connected horizontally or vertically */
public class NumberOfIslands {

    // The grid IS the graph (nodes = cells, edges = 4 neighbours). On each unvisited '1' start a DFS that SINKS the island
    // (mark it '0'), so it is never counted twice. O(R*C) time, O(R*C) stack worst case
    static int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    sink(grid, r, c);
                }
            }
        }
        return count;
    }

    private static void sink(char[][] g, int r, int c) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] != '1') return;
        g[r][c] = '0';                                        // mark visited by overwriting (restore a copy if the input must stay intact)
        sink(g, r + 1, c);
        sink(g, r - 1, c);
        sink(g, r, c + 1);
        sink(g, r, c - 1);
    }

    static char[][] grid(String... rows) {
        char[][] g = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) g[i] = rows[i].toCharArray();
        return g;
    }

    public static void main(String[] args) {
        System.out.println(numIslands(grid("11000", "11000", "00100", "00011")));    // 3
        System.out.println(numIslands(grid("11110", "11010", "11000", "00000")));    // 1
        System.out.println(numIslands(grid("000", "000")));                          // 0
        System.out.println(numIslands(grid("1")));                                   // 1
        System.out.println(numIslands(grid("101", "010", "101")));                   // 5  (diagonals do NOT connect)
    }
}
