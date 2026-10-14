import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/** Topological Sort of a DAG: an ordering where every edge u -> v has u BEFORE v. Kahn's algorithm (BFS on in-degrees) and the DFS version */
public class TopologicalSortKahn {

    static List<List<Integer>> adj(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) g.get(e[0]).add(e[1]);
        return g;
    }

    // Kahn: repeatedly remove a node with in-degree 0 and decrease its neighbours' in-degrees. If fewer than n nodes get removed,
    // the rest are on/behind a CYCLE (no topological order exists). O(V + E) time, O(V) space
    static int[] kahn(int n, int[][] edges) {
        List<List<Integer>> g = adj(n, edges);
        int[] indeg = new int[n];
        for (int[] e : edges) indeg[e[1]]++;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.offer(i);
        int[] order = new int[n];
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[count++] = u;
            for (int v : g.get(u)) if (--indeg[v] == 0) q.offer(v);
        }
        return count == n ? order : new int[0];                    // empty array = cycle
    }

    // DFS: after fully exploring a node, push it on a stack; the reversed finishing order is a valid topological order. O(V + E)
    static int[] dfsTopo(int n, int[][] edges) {
        List<List<Integer>> g = adj(n, edges);
        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int s = 0; s < n; s++) if (!visited[s]) dfs(g, s, visited, stack);
        int[] order = new int[n];
        for (int i = 0; i < n; i++) order[i] = stack.pop();
        return order;                                              // assumes a DAG (does not detect cycles)
    }

    private static void dfs(List<List<Integer>> g, int u, boolean[] visited, ArrayDeque<Integer> stack) {
        visited[u] = true;
        for (int v : g.get(u)) if (!visited[v]) dfs(g, v, visited, stack);
        stack.push(u);                                             // push AFTER all descendants are done
    }

    // Validity checker: every edge must go forward in the order
    static boolean isValid(int n, int[][] edges, int[] order) {
        if (order.length != n) return false;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[order[i]] = i;
        for (int[] e : edges) if (pos[e[0]] >= pos[e[1]]) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] edges = {{5, 0}, {5, 2}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        int[] a = kahn(6, edges), b = dfsTopo(6, edges);
        System.out.println(Arrays.toString(a) + " " + isValid(6, edges, a));     // [4, 5, 0, 2, 3, 1] true
        System.out.println(Arrays.toString(b) + " " + isValid(6, edges, b));     // a different valid order, true
        System.out.println(kahn(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}).length); // 0  (cycle: no order)
        System.out.println(Arrays.toString(kahn(1, new int[][]{})));             // [0]
        System.out.println(Arrays.toString(kahn(3, new int[][]{})));             // [0, 1, 2]  (any order is valid)
    }
}
