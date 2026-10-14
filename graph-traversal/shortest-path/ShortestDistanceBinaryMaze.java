import java.util.ArrayDeque;
import java.util.Queue;

/** Shortest Distance in a Binary Maze: grid of 1 (open) and 0 (blocked). Fewest 4-directional steps from source to destination, or -1 */
public class ShortestDistanceBinaryMaze {

    // Every move costs 1, so plain BFS is already the "Dijkstra" here. Track distance per cell; the first time the destination is
    // dequeued is the shortest. O(R*C) time, O(R*C) space
    static int shortestPath(int[][] grid, int[] source, int[] dest) {
        if (grid[source[0]][source[1]] == 0 || grid[dest[0]][dest[1]] == 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) java.util.Arrays.fill(row, -1);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(source);
        dist[source[0]][source[1]] = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == dest[0] && cur[1] == dest[1]) return dist[cur[0]][cur[1]];
            for (int[] d : dirs) {
                int nr = cur[0] + d[0], nc = cur[1] + d[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        System.out.println(shortestPath(grid, new int[]{0, 1}, new int[]{2, 2}));            // 3
        System.out.println(shortestPath(grid, new int[]{0, 0}, new int[]{4, 0}));            // 4
        System.out.println(shortestPath(grid, new int[]{0, 0}, new int[]{4, 3}));            // -1  (the bottom-right cell is walled off)
        System.out.println(shortestPath(grid, new int[]{2, 2}, new int[]{2, 2}));            // 0   (source == destination)
        System.out.println(shortestPath(new int[][]{{1, 0}, {0, 1}}, new int[]{0, 0}, new int[]{1, 1}));   // -1 (diagonal moves are not allowed)
    }
}
