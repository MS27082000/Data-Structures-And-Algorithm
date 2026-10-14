import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Detect a Cycle in an UNDIRECTED Graph */
public class CycleDetectionUndirected {

    static List<List<Integer>> adj(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        return g;
    }

    // DFS carrying the PARENT. Meeting an already-visited neighbour that is NOT the parent means a back edge => cycle.
    // The graph may be disconnected, so start from every unvisited node. O(V + E) time, O(V) space
    static boolean hasCycleDfs(int n, int[][] edges) {
        List<List<Integer>> g = adj(n, edges);
        boolean[] visited = new boolean[n];
        for (int s = 0; s < n; s++) {
            if (!visited[s] && dfs(g, s, -1, visited)) return true;
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> g, int u, int parent, boolean[] visited) {
        visited[u] = true;
        for (int v : g.get(u)) {
            if (!visited[v]) {
                if (dfs(g, v, u, visited)) return true;
            } else if (v != parent) {
                return true;                                      // visited and not the node we came from: a cycle
            }
        }
        return false;
    }

    // BFS version: queue of {node, parent}
    static boolean hasCycleBfs(int n, int[][] edges) {
        List<List<Integer>> g = adj(n, edges);
        boolean[] visited = new boolean[n];
        for (int s = 0; s < n; s++) {
            if (visited[s]) continue;
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{s, -1});
            visited[s] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int v : g.get(cur[0])) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(new int[]{v, cur[0]});
                    } else if (v != cur[1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] cyc = {{0, 1}, {1, 2}, {2, 3}, {3, 1}};
        System.out.println(hasCycleDfs(4, cyc) + " " + hasCycleBfs(4, cyc));                        // true true
        int[][] tree = {{0, 1}, {1, 2}, {1, 3}};
        System.out.println(hasCycleDfs(4, tree) + " " + hasCycleBfs(4, tree));                      // false false
        System.out.println(hasCycleDfs(5, new int[][]{{0, 1}, {2, 3}, {3, 4}, {4, 2}}));            // true  (cycle in the 2nd component)
        System.out.println(hasCycleDfs(3, new int[][]{{0, 1}, {1, 2}}));                            // false
        System.out.println(hasCycleDfs(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));                    // true  (triangle)
        System.out.println(hasCycleDfs(2, new int[][]{}));                                          // false
    }
}
