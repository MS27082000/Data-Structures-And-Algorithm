import java.util.HashSet;
import java.util.Set;

/** Number of Distinct Islands (LC 694): count islands with DISTINCT SHAPES (translations count as the same shape, rotations/reflections do not) */
public class NumberOfDistinctIslands {

    // Record each island's shape as the sequence of DFS moves (U/D/L/R), adding a "back" marker when the DFS returns.
    // Two islands with the same path string have the same shape. O(R*C) time, O(R*C) space
    static int numDistinctIslands(int[][] grid) {
        Set<String> shapes = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    StringBuilder path = new StringBuilder();
                    dfs(grid, r, c, visited, path, 'o');          // 'o' = origin
                    shapes.add(path.toString());
                }
            }
        }
        return shapes.size();
    }

    private static void dfs(int[][] g, int r, int c, boolean[][] visited, StringBuilder path, char move) {
        if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] != 1 || visited[r][c]) return;
        visited[r][c] = true;
        path.append(move);
        dfs(g, r + 1, c, visited, path, 'D');
        dfs(g, r - 1, c, visited, path, 'U');
        dfs(g, r, c + 1, visited, path, 'R');
        dfs(g, r, c - 1, visited, path, 'L');
        path.append('b');                                          // BACKTRACK marker: without it different shapes can collide
    }

    public static void main(String[] args) {
        System.out.println(numDistinctIslands(new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}));   // 1
        System.out.println(numDistinctIslands(new int[][]{{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}}));   // 3
        System.out.println(numDistinctIslands(new int[][]{{1, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 1}}));   // 2 (L-shapes that are rotations differ)
        System.out.println(numDistinctIslands(new int[][]{{0, 0}, {0, 0}}));                                                        // 0
        System.out.println(numDistinctIslands(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));                                       // 1 (four single cells)
    }
}
