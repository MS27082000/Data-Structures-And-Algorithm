import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/** Dijkstra's Algorithm: shortest distance from a source to every node in a graph with NON-NEGATIVE edge weights */
public class DijkstraAlgorithm {

    static List<List<int[]>> adj(int n, int[][] edges, boolean directed) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(new int[]{e[1], e[2]});
            if (!directed) g.get(e[1]).add(new int[]{e[0], e[2]});
        }
        return g;
    }

    // Greedy: always finalise the unfinished node with the SMALLEST known distance (min-heap of {distance, node}), then relax its
    // edges. With non-negative weights a finalised distance can never be improved later.
    // O((V + E) log V) time with a binary heap, O(V + E) space
    static int[] dijkstra(int n, List<List<int[]>> g, int src) {
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > dist[u]) continue;                              // STALE entry: a shorter path to u was already processed
            for (int[] e : g.get(u)) {
                int v = e[0], w = e[1];
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});                // lazy deletion: push a new entry instead of decreasing the key
                }
            }
        }
        for (int i = 0; i < n; i++) if (dist[i] == INF) dist[i] = -1;   // -1 = unreachable
        return dist;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dijkstra(3, adj(3, new int[][]{{0, 1, 1}, {0, 2, 6}, {1, 2, 3}}, false), 0)));   // [0, 1, 4]
        int[][] e = {{0, 1, 4}, {0, 2, 8}, {1, 4, 6}, {2, 3, 2}, {3, 4, 10}};
        System.out.println(Arrays.toString(dijkstra(5, adj(5, e, false), 0)));                                          // [0, 4, 8, 10, 10]
        System.out.println(Arrays.toString(dijkstra(4, adj(4, new int[][]{{0, 1, 2}, {2, 3, 1}}, false), 0)));           // [0, 2, -1, -1]
        System.out.println(Arrays.toString(dijkstra(3, adj(3, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 2, 10}}, true), 0)));   // [0, 5, 10]
        System.out.println(Arrays.toString(dijkstra(1, adj(1, new int[][]{}, false), 0)));                               // [0]
        // NEGATIVE weights break the greedy argument (a finalised node could later be improved): use Bellman-Ford there.
    }
}
