import java.util.Arrays;

/** Bellman-Ford: single-source shortest paths with NEGATIVE edge weights, and negative-cycle detection */
public class BellmanFord {

    private static final int INF = Integer.MAX_VALUE;

    // A shortest path has at most V - 1 edges, so relax EVERY edge V - 1 times. If an edge can STILL be relaxed in a V-th pass, there is
    // a NEGATIVE CYCLE reachable from the source. Returns null in that case. O(V * E) time, O(V) space
    static int[] bellmanFord(int n, int[][] edges, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int i = 1; i <= n - 1; i++) {
            boolean changed = false;
            for (int[] e : edges) {
                if (dist[e[0]] != INF && dist[e[0]] + e[2] < dist[e[1]]) {
                    dist[e[1]] = dist[e[0]] + e[2];
                    changed = true;
                }
            }
            if (!changed) break;                                    // early exit: already converged
        }
        for (int[] e : edges) {
            if (dist[e[0]] != INF && dist[e[0]] + e[2] < dist[e[1]]) return null;   // V-th pass still improves => negative cycle
        }
        for (int i = 0; i < n; i++) if (dist[i] == INF) dist[i] = -1;     // -1 = unreachable
        return dist;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bellmanFord(3, new int[][]{{0, 1, 5}, {1, 2, -3}, {0, 2, 4}}, 0)));          // [0, 5, 2]
        System.out.println(Arrays.toString(bellmanFord(3, new int[][]{{0, 1, 1}, {1, 2, -1}, {2, 0, -1}}, 0)));          // null (cycle 0->1->2->0 totals -1)
        System.out.println(Arrays.toString(bellmanFord(4, new int[][]{{0, 1, 4}, {0, 2, 5}, {1, 2, -3}, {2, 3, 4}}, 0)));  // [0, 4, 1, 5]
        System.out.println(Arrays.toString(bellmanFord(4, new int[][]{{0, 1, 2}}, 0)));                                  // [0, 2, -1, -1]
        System.out.println(Arrays.toString(bellmanFord(3, new int[][]{{1, 2, -5}, {2, 1, 1}}, 0)));                      // [0, -1, -1]  (the negative cycle is unreachable from 0)
    }
}
