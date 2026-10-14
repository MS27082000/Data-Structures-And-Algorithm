import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/** Distance of the Nearest Cell having 1 (GfG), and its LeetCode twin 01 Matrix (LC 542: distance to the nearest 0) */
public class NearestCellHavingOne {

    // MULTI-SOURCE BFS: push EVERY target cell (distance 0) first, then expand outwards. Each cell is reached for the first
    // time by its nearest target. O(R*C) time and space (a naive BFS from each cell would be O((R*C)^2))
    static int[][] nearest(int[][] grid, int target) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == target) {
                    dist[r][c] = 0;
                    q.offer(new int[]{r, c});
                } else {
                    dist[r][c] = -1;                              // -1 = not reached yet (doubles as the visited marker)
                }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return dist;
    }

    static int[][] nearestOne(int[][] grid) { return nearest(grid, 1); }
    static int[][] updateMatrix(int[][] mat) { return nearest(mat, 0); }     // LC 542

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(nearestOne(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 0, 1}})));    // [[2, 1, 2], [1, 0, 1], [0, 1, 0]]
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}))); // [[0, 0, 0], [0, 1, 0], [1, 2, 1]]
        System.out.println(Arrays.deepToString(nearestOne(new int[][]{{1}})));                                // [[0]]
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0, 1}, {1, 1}})));                   // [[0, 1], [1, 2]]
        System.out.println(Arrays.deepToString(nearestOne(new int[][]{{0, 0}, {0, 0}})));                     // [[-1, -1], [-1, -1]]  (no 1 anywhere)
    }
}
