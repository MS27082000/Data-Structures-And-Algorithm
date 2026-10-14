import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/** Print Shortest Path: nodes are 1..n, undirected weighted edges. Return the shortest path from 1 to n as a list of nodes ([-1] if none) */
public class PrintShortestPath {

    // Dijkstra + a PARENT array: parent[v] = the node that gave v its best distance. Walk back from n to 1 and reverse.
    // O((V + E) log V) time, O(V + E) space
    static List<Integer> shortestPath(int n, int[][] edges) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(new int[]{e[1], e[2]});
            g.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1], parent = new int[n + 1];
        Arrays.fill(dist, INF);
        for (int i = 0; i <= n; i++) parent[i] = i;
        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > dist[u]) continue;
            for (int[] e : g.get(u)) {
                if (d + e[1] < dist[e[0]]) {
                    dist[e[0]] = d + e[1];
                    parent[e[0]] = u;                              // remember HOW we reached e[0]
                    pq.offer(new int[]{dist[e[0]], e[0]});
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dist[n] == INF) {
            path.add(-1);
            return path;
        }
        for (int v = n; v != 1; v = parent[v]) path.add(v);
        path.add(1);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        System.out.println(shortestPath(5, edges));                                     // [1, 4, 3, 5]  (cost 5; via 2 would cost 7)
        System.out.println(shortestPath(2, new int[][]{{1, 2, 9}}));                    // [1, 2]
        System.out.println(shortestPath(3, new int[][]{{1, 2, 1}}));                    // [-1]  (3 is unreachable)
        System.out.println(shortestPath(1, new int[][]{}));                             // [1]
        System.out.println(shortestPath(4, new int[][]{{1, 2, 1}, {2, 4, 1}, {1, 3, 1}, {3, 4, 1}}));   // [1, 2, 4] or [1, 3, 4] (a tie)
    }
}
