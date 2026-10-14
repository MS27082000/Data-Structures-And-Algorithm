import java.util.ArrayList;
import java.util.List;

/** Rat in a Maze: from (0,0) to (n-1,n-1) through cells with value 1 (0 = blocked), moves D, L, R, U, no revisiting.
 *  Return all paths in lexicographic order. */
public class RatInAMaze {

    private static final String DIRS = "DLRU";                    // already lexicographic
    private static final int[] DR = {1, 0, 0, -1};
    private static final int[] DC = {0, -1, 1, 0};

    // O(4^(n*n)) worst case, O(n*n) stack
    static List<String> findPaths(int[][] maze) {
        List<String> res = new ArrayList<>();
        int n = maze.length;
        if (n == 0 || maze[0][0] == 0 || maze[n - 1][n - 1] == 0) return res;
        dfs(0, 0, maze, new boolean[n][n], new StringBuilder(), res);
        return res;
    }

    private static void dfs(int r, int c, int[][] maze, boolean[][] visited, StringBuilder path, List<String> res) {
        int n = maze.length;
        if (r == n - 1 && c == n - 1) {
            res.add(path.toString());
            return;
        }
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + DR[d], nc = c + DC[d];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n && maze[nr][nc] == 1 && !visited[nr][nc]) {
                path.append(DIRS.charAt(d));
                dfs(nr, nc, maze, visited, path, res);
                path.deleteCharAt(path.length() - 1);
            }
        }
        visited[r][c] = false;                                    // backtrack: allow other paths to use this cell
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(findPaths(maze));                      // [DDRDRR, DRDDRR]
        System.out.println(findPaths(new int[][]{{1, 0}, {1, 0}})); // []
        System.out.println(findPaths(new int[][]{{1}}));          // [] -> start == end: empty path [""]
        System.out.println(findPaths(new int[][]{{0, 1}, {1, 1}})); // [] (start blocked)
    }
}
