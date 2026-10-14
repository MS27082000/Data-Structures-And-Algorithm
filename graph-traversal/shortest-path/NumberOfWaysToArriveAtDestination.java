import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/** Number of Ways to Arrive at Destination (LC 1976): the number of DIFFERENT shortest paths from node 0 to node n-1, modulo 1e9+7 */
public class NumberOfWaysToArriveAtDestination {

    private static final long MOD = 1_000_000_007L;

    // Dijkstra with an extra array ways[]. When a STRICTLY shorter path to v is found, ways[v] = ways[u]. When an EQUALLY short path
    // is found, ways[v] += ways[u]. Use long: both distances and counts can be large. O((V + E) log V) time
    static int countPaths(int n, int[][] roads) {
        List<List<long[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] r : roads) {
            g.get(r[0]).add(new long[]{r[1], r[2]});
            g.get(r[1]).add(new long[]{r[0], r[2]});
        }
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > dist[u]) continue;
            for (long[] e : g.get(u)) {
                int v = (int) e[0];
                long nd = d + e[1];
                if (nd < dist[v]) {                                  // a strictly better route: replace the count
                    dist[v] = nd;
                    ways[v] = ways[u];
                    pq.offer(new long[]{nd, v});
                } else if (nd == dist[v]) {                          // another route of the same length: add the counts
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        return (int) (ways[n - 1] % MOD);
    }

    public static void main(String[] args) {
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        System.out.println(countPaths(7, roads));                              // 4
        System.out.println(countPaths(2, new int[][]{{1, 0, 10}}));            // 1
        System.out.println(countPaths(3, new int[][]{{0, 1, 1}, {1, 2, 1}, {0, 2, 2}}));   // 2  (0-1-2 and 0-2 both cost 2)
        System.out.println(countPaths(1, new int[][]{}));                      // 1  (already there)
        System.out.println(countPaths(4, new int[][]{{0, 1, 1}, {0, 2, 1}, {1, 3, 1}, {2, 3, 1}}));   // 2
    }
}
