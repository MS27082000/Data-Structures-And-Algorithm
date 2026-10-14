import java.util.Arrays;

/** Cheapest Flights Within K Stops (LC 787): cheapest price from src to dst using at most k STOPS (so at most k + 1 flights), or -1 */
public class CheapestFlightsWithinKStops {

    // Bellman-Ford limited to k + 1 rounds: after round i, dist[v] = the cheapest price using AT MOST i flights. Each round reads from a
    // COPY of the previous round's distances, otherwise a single round could chain several flights. O(K * E) time, O(V) space
    static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] next = dist.clone();
            for (int[] f : flights) {
                int u = f[0], v = f[1], w = f[2];
                if (dist[u] != INF && dist[u] + w < next[v]) next[v] = dist[u] + w;
            }
            dist = next;
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        int[][] f = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        System.out.println(findCheapestPrice(4, f, 0, 3, 1));                                              // 700  (0 -> 1 -> 3)
        int[][] g = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        System.out.println(findCheapestPrice(3, g, 0, 2, 1));                                              // 200  (0 -> 1 -> 2)
        System.out.println(findCheapestPrice(3, g, 0, 2, 0));                                              // 500  (direct only)
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}}, 0, 2, 5));                       // -1   (unreachable)
        System.out.println(findCheapestPrice(4, f, 0, 3, 2));                                              // 400  (0 -> 1 -> 2 -> 3 = 100 + 100 + 200)
        System.out.println(findCheapestPrice(2, new int[][]{{0, 1, 7}}, 0, 0, 0));                         // 0    (src == dst)
    }
}
