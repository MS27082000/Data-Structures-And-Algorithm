import java.util.ArrayList;
import java.util.List;

/** Detect a Cycle in a DIRECTED Graph */
public class CycleDetectionDirected {

    static List<List<Integer>> adj(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) g.get(e[0]).add(e[1]);
        return g;
    }

    // DFS with THREE states: 0 = unvisited, 1 = on the CURRENT recursion path, 2 = finished. Reaching a node in state 1 means a
    // back edge to an ancestor => cycle. (A plain visited[] is not enough: a node visited via ANOTHER branch is fine in a directed graph.)
    // O(V + E) time, O(V) space
    static boolean hasCycle(int n, int[][] edges) {
        List<List<Integer>> g = adj(n, edges);
        int[] state = new int[n];
        for (int s = 0; s < n; s++) {
            if (state[s] == 0 && dfs(g, s, state)) return true;
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> g, int u, int[] state) {
        state[u] = 1;                                              // enter: on the current path
        for (int v : g.get(u)) {
            if (state[v] == 1) return true;                        // back edge
            if (state[v] == 0 && dfs(g, v, state)) return true;
        }
        state[u] = 2;                                              // leave: fully explored
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 1}}));      // true  (1 -> 2 -> 3 -> 1)
        System.out.println(hasCycle(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}}));      // false (a diamond DAG: 3 is reached twice, no cycle)
        System.out.println(hasCycle(1, new int[][]{{0, 0}}));                              // true  (self loop)
        System.out.println(hasCycle(3, new int[][]{{0, 1}, {1, 2}}));                      // false
        System.out.println(hasCycle(3, new int[][]{{0, 1}, {1, 0}}));                      // true  (2-cycle)
        System.out.println(hasCycle(5, new int[][]{{0, 1}, {2, 3}, {3, 4}, {4, 2}}));      // true  (cycle in another component)
    }
}
