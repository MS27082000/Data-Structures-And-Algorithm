import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/** Shortest Path in an Undirected Graph with Unit Weights: distance (number of edges) from `src` to every node, -1 if unreachable */
public class ShortestPathUnitWeights {

    // BFS visits nodes in order of increasing distance, so the FIRST time a node is reached is its shortest distance.
    // O(V + E) time, O(V) space
    static int[] shortestPath(int n, int[][] edges, int src) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(src);
        dist[src] = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
        System.out.println(Arrays.toString(shortestPath(9, edges, 0)));                       // [0, 1, 2, 1, 2, 3, 3, 4, 4]
        System.out.println(Arrays.toString(shortestPath(4, new int[][]{{0, 1}, {2, 3}}, 0))); // [0, 1, -1, -1]  (2 and 3 unreachable)
        System.out.println(Arrays.toString(shortestPath(1, new int[][]{}, 0)));               // [0]
        System.out.println(Arrays.toString(shortestPath(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, 2)));   // [2, 1, 0, 1, 2]
        // BFS gives shortest paths ONLY when every edge has the same weight. For weighted edges use Dijkstra.
    }
}
