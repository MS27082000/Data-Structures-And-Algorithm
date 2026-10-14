import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/** Floyd-Warshall: shortest distances between ALL pairs of nodes (handles negative edges, detects negative cycles) */
public class FloydWarshall {

    static final int INF = 1_000_000_000;                          // large but safe to add twice without overflowing an int

    // dist[i][j] = best known i -> j. For each possible INTERMEDIATE node k, try to improve every pair by going through k:
    // dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]). O(V^3) time, O(V^2) space (in place)
    static int[][] floydWarshall(int n, int[][] edges) {
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, INF);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int[] e : edges) dist[e[0]][e[1]] = Math.min(dist[e[0]][e[1]], e[2]);
        for (int k = 0; k < n; k++) {                              // k MUST be the outermost loop
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        return dist;
    }

    // Negative cycle exists iff some node can reach itself with negative cost
    static boolean hasNegativeCycle(int[][] dist) {
        for (int i = 0; i < dist.length; i++) if (dist[i][i] < 0) return true;
        return false;
    }

    // Verification: with non-negative weights, Dijkstra from every node must give the same answers
    static int[][] viaDijkstra(int n, int[][] edges) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) g.get(e[0]).add(new int[]{e[1], e[2]});
        int[][] res = new int[n][n];
        for (int s = 0; s < n; s++) {
            Arrays.fill(res[s], INF);
            res[s][s] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            pq.offer(new int[]{0, s});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                if (cur[0] > res[s][cur[1]]) continue;
                for (int[] e : g.get(cur[1])) {
                    if (cur[0] + e[1] < res[s][e[0]]) {
                        res[s][e[0]] = cur[0] + e[1];
                        pq.offer(new int[]{res[s][e[0]], e[0]});
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 3}, {0, 3, 7}, {1, 0, 8}, {1, 2, 2}, {2, 0, 5}, {2, 3, 1}, {3, 0, 2}};
        int[][] d = floydWarshall(4, edges);
        System.out.println(Arrays.deepToString(d));                                       // [[0, 3, 5, 6], [5, 0, 2, 3], [3, 6, 0, 1], [2, 5, 7, 0]]
        System.out.println(Arrays.deepToString(d).equals(Arrays.deepToString(viaDijkstra(4, edges))));   // true (cross-check)
        int[][] neg = floydWarshall(3, new int[][]{{0, 1, 1}, {1, 2, -1}, {2, 0, -1}});
        System.out.println(hasNegativeCycle(neg));                                        // true
        System.out.println(hasNegativeCycle(d));                                          // false
        int[][] unreachable = floydWarshall(2, new int[][]{});
        System.out.println(unreachable[0][1] == INF);                                     // true (INF = no path)
    }
}
