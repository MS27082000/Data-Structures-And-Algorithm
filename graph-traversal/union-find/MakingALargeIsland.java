import java.util.HashSet;
import java.util.Set;

/** Making A Large Island (LC 827): you may change AT MOST ONE 0 into a 1. Size of the largest island you can get? */
public class MakingALargeIsland {

    private static int find(int[] p, int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }

    // 1) Union-Find over the existing land to get every island's SIZE.  2) For every 0 cell, flipping it merges the DISTINCT islands among its
    // 4 neighbours: new size = 1 + sum of those islands' sizes. Use a Set of roots so one island touching the cell twice is counted once.
    // 3) If there is no 0 at all the answer is n*n. O(n^2 * alpha) time, O(n^2) space
    static int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] parent = new int[n * n], size = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != 1) continue;
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] != 1) continue;
                    int a = find(parent, r * n + c), b = find(parent, nr * n + nc);
                    if (a != b) {
                        if (size[a] < size[b]) { int t = a; a = b; b = t; }
                        parent[b] = a;
                        size[a] += size[b];
                    }
                }
            }
        }
        int best = 0;
        boolean hasZero = false;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    best = Math.max(best, size[find(parent, r * n + c)]);        // an island that already exists (no flip)
                    continue;
                }
                hasZero = true;
                Set<Integer> roots = new HashSet<>();
                int total = 1;                                                    // the flipped cell itself
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] != 1) continue;
                    int root = find(parent, nr * n + nc);
                    if (roots.add(root)) total += size[root];
                }
                best = Math.max(best, total);
            }
        }
        return hasZero ? best : n * n;
    }

    public static void main(String[] args) {
        System.out.println(largestIsland(new int[][]{{1, 0}, {0, 1}}));                       // 3
        System.out.println(largestIsland(new int[][]{{1, 1}, {1, 0}}));                       // 4
        System.out.println(largestIsland(new int[][]{{1, 1}, {1, 1}}));                       // 4  (no 0 to flip)
        System.out.println(largestIsland(new int[][]{{0, 0}, {0, 0}}));                       // 1  (flip any single cell)
        System.out.println(largestIsland(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));      // 5  (flip the centre: 4 corners + centre)
    }
}
