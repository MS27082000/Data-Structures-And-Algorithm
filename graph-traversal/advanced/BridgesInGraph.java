import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Bridges in a Graph (Critical Connections in a Network, LC 1192): an edge whose removal DISCONNECTS the (undirected) graph */
public class BridgesInGraph {

    private static int timer;

    // Tarjan's low-link DFS. tin[u] = discovery time. low[u] = the earliest discovery time reachable from u's DFS subtree using tree edges
    // plus ONE back edge. A tree edge u -> v is a BRIDGE iff low[v] > tin[u]: nothing in v's subtree can reach u or above any other way.
    // O(V + E) time, O(V + E) space
    static List<List<Integer>> criticalConnections(int n, int[][] connections) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] c : connections) {
            g.get(c[0]).add(c[1]);
            g.get(c[1]).add(c[0]);
        }
        int[] tin = new int[n], low = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        timer = 0;
        for (int i = 0; i < n; i++) if (!visited[i]) dfs(g, i, -1, tin, low, visited, bridges);
        bridges.sort((a, b) -> a.get(0) != b.get(0) ? Integer.compare(a.get(0), b.get(0)) : Integer.compare(a.get(1), b.get(1)));
        return bridges;
    }

    private static void dfs(List<List<Integer>> g, int u, int parent, int[] tin, int[] low, boolean[] visited, List<List<Integer>> bridges) {
        visited[u] = true;
        tin[u] = low[u] = timer++;
        for (int v : g.get(u)) {
            if (v == parent) continue;                                  // do not go back along the tree edge we came from
            if (visited[v]) {
                low[u] = Math.min(low[u], tin[v]);                      // a BACK edge to an already-discovered node
            } else {
                dfs(g, v, u, tin, low, visited, bridges);
                low[u] = Math.min(low[u], low[v]);                      // inherit what v's subtree can reach
                if (low[v] > tin[u]) {                                  // v's subtree cannot get above u by another route
                    bridges.add(new ArrayList<>(List.of(Math.min(u, v), Math.max(u, v))));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(criticalConnections(4, new int[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}}));       // [[1, 3]]
        System.out.println(criticalConnections(3, new int[][]{{0, 1}, {1, 2}}));                        // [[0, 1], [1, 2]]  (every edge of a tree is a bridge)
        System.out.println(criticalConnections(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));                // []  (a cycle has no bridge)
        System.out.println(criticalConnections(2, new int[][]{{0, 1}}));                                // [[0, 1]]
        System.out.println(criticalConnections(6, new int[][]{{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 4}, {4, 5}, {5, 3}}));   // [[2, 3]]
    }
}
