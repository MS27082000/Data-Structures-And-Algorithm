import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/** Shortest Path in a Weighted DAG from a source: -1 for unreachable nodes. Works even with NEGATIVE weights (a DAG has no negative cycle) */
public class ShortestPathInDAG {

    // 1) Topologically sort (DFS finishing order).  2) Relax the outgoing edges of the nodes in that order: when a node is
    // processed, all paths into it are already final. O(V + E) time - faster than Dijkstra and handles negative edges
    static int[] shortestPath(int n, int[][] edges, int src) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) g.get(e[0]).add(new int[]{e[1], e[2]});
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (!visited[i]) dfs(g, i, visited, stack);

        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();                                   // topological order
            if (dist[u] == INF) continue;                          // not reachable from src: its edges cannot help
            for (int[] e : g.get(u)) {
                if (dist[u] + e[1] < dist[e[0]]) dist[e[0]] = dist[u] + e[1];
            }
        }
        for (int i = 0; i < n; i++) if (dist[i] == INF) dist[i] = -1;
        return dist;
    }

    private static void dfs(List<List<int[]>> g, int u, boolean[] visited, Deque<Integer> stack) {
        visited[u] = true;
        for (int[] e : g.get(u)) if (!visited[e[0]]) dfs(g, e[0], visited, stack);
        stack.push(u);
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        System.out.println(Arrays.toString(shortestPath(6, edges, 0)));                                  // [0, 2, 3, 6, 1, 5]
        System.out.println(Arrays.toString(shortestPath(4, new int[][]{{0, 1, 2}, {0, 2, 1}}, 0)));       // [0, 2, 1, -1]
        System.out.println(Arrays.toString(shortestPath(3, new int[][]{{0, 1, 5}, {1, 2, -3}}, 0)));      // [0, 5, 2]  (negative weight is fine in a DAG)
        System.out.println(Arrays.toString(shortestPath(3, new int[][]{{1, 2, 4}}, 0)));                  // [0, -1, -1]
        System.out.println(Arrays.toString(shortestPath(1, new int[][]{}, 0)));                           // [0]
    }
}
