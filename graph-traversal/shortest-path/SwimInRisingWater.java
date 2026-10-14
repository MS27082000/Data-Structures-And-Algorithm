import java.util.Arrays;
import java.util.PriorityQueue;

/** Swim in Rising Water (LC 778): grid[r][c] is the elevation. At time t you can swim into any cell with elevation <= t. Least time to go from (0,0) to (n-1,n-1) */
public class SwimInRisingWater {

    // The cost of a path is the HIGHEST elevation on it (a minimax path), and we want the path minimising that. Dijkstra with
    // cost = max(cost so far, elevation of the next cell). O(N^2 log N) time for an N x N grid, O(N^2) space
    static int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] best = new int[n][n];
        for (int[] row : best) Arrays.fill(row, Integer.MAX_VALUE);
        best[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));   // {time, r, c}
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) return t;
            if (t > best[r][c]) continue;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                int nt = Math.max(t, grid[nr][nc]);
                if (nt < best[nr][nc]) {
                    best[nr][nc] = nt;
                    pq.offer(new int[]{nt, nr, nc});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(swimInWater(new int[][]{{0, 2}, {1, 3}}));                                                           // 3
        System.out.println(swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));   // 16
        System.out.println(swimInWater(new int[][]{{0}}));                                                                      // 0
        System.out.println(swimInWater(new int[][]{{3, 2}, {0, 1}}));                                                           // 3
        System.out.println(swimInWater(new int[][]{{0, 1}, {2, 3}}));                                                           // 3
    }
}
