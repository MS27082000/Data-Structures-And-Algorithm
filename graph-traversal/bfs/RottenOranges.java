import java.util.ArrayDeque;
import java.util.Queue;

/** Rotting Oranges (LC 994): 0 empty, 1 fresh, 2 rotten. Every minute rot spreads to 4-neighbours. Minutes until none is fresh, or -1 */
public class RottenOranges {

    // MULTI-SOURCE BFS: start with ALL rotten oranges in the queue at once; each BFS level = one minute. O(R*C) time, O(R*C) space
    static int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, fresh = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) q.offer(new int[]{r, c});
                else if (grid[r][c] == 1) fresh++;
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;
        while (!q.isEmpty() && fresh > 0) {
            minutes++;
            for (int i = q.size(); i > 0; i--) {                  // process one whole level per minute
                int[] cur = q.poll();
                for (int[] d : dirs) {
                    int nr = cur[0] + d[0], nc = cur[1] + d[1];
                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return fresh == 0 ? minutes : -1;                         // fresh oranges left => unreachable
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));   // 4
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));   // -1 (the bottom-left orange is isolated)
        System.out.println(orangesRotting(new int[][]{{0, 2}}));                            // 0  (nothing fresh)
        System.out.println(orangesRotting(new int[][]{{1}}));                               // -1 (fresh orange, no rotten source)
        System.out.println(orangesRotting(new int[][]{{0}}));                               // 0
        System.out.println(orangesRotting(new int[][]{{2, 1, 1, 1, 2}}));                   // 2  (two sources rot from both ends)
    }
}
