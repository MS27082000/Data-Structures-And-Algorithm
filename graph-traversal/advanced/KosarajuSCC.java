import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/** Kosaraju's Algorithm: the Strongly Connected Components of a DIRECTED graph (maximal groups where every node can reach every other) */
public class KosarajuSCC {

    // 1) DFS on the graph, pushing each node on a stack when it FINISHES.
    // 2) Build the TRANSPOSE graph (all edges reversed).
    // 3) Pop nodes from the stack; each unvisited one starts a DFS on the transpose that collects exactly ONE SCC.
    // Why it works: reversing the edges keeps the SCCs the same but turns the condensation DAG around, so a DFS from the node that finishes
    // last (a node in a "source" SCC) can no longer escape into other SCCs. O(V + E) time, O(V + E) space
    static List<List<Integer>> scc(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>(), rev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            rev.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (!visited[i]) fill(g, i, visited, stack);

        visited = new boolean[n];
        List<List<Integer>> comps = new ArrayList<>();
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (visited[u]) continue;
            List<Integer> comp = new ArrayList<>();
            collect(rev, u, visited, comp);
            Collections.sort(comp);
            comps.add(comp);
        }
        comps.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));   // deterministic output order
        return comps;
    }

    private static void fill(List<List<Integer>> g, int u, boolean[] visited, Deque<Integer> stack) {
        visited[u] = true;
        for (int v : g.get(u)) if (!visited[v]) fill(g, v, visited, stack);
        stack.push(u);                                                // push on FINISH
    }

    private static void collect(List<List<Integer>> g, int u, boolean[] visited, List<Integer> comp) {
        visited[u] = true;
        comp.add(u);
        for (int v : g.get(u)) if (!visited[v]) collect(g, v, visited, comp);
    }

    public static void main(String[] args) {
        System.out.println(scc(5, new int[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}}));            // [[0, 1, 2], [3], [4]]
        int[][] e = {{0, 1}, {1, 2}, {2, 0}, {2, 3}, {3, 4}, {4, 5}, {5, 3}, {6, 5}, {6, 7}, {7, 6}};
        System.out.println(scc(8, e));                                                              // [[0, 1, 2], [3, 4, 5], [6, 7]]
        System.out.println(scc(3, new int[][]{}));                                                  // [[0], [1], [2]]  (no edges: every node alone)
        System.out.println(scc(4, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}}));                    // [[0, 1, 2, 3]]  (one big cycle)
        System.out.println(scc(3, new int[][]{{0, 1}, {1, 2}}));                                    // [[0], [1], [2]]  (a DAG: all trivial SCCs)
    }
}
