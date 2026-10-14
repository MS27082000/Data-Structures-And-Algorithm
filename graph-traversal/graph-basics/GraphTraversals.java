import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/** Graph Traversal Techniques: BFS and DFS (recursive and iterative), including DISCONNECTED graphs */
public class GraphTraversals {

    static List<List<Integer>> adj(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        return g;
    }

    // BFS: queue + visited[]. Mark visited when ENQUEUEING (not when dequeuing) so a node is never queued twice.
    // O(V + E) time, O(V) space. Visits nodes level by level = shortest path (in edges) in an unweighted graph
    static List<Integer> bfs(List<List<Integer>> g, int start) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[g.size()];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int v : g.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
        return order;
    }

    // DFS recursive: go as deep as possible before backtracking. O(V + E) time, O(V) stack
    static void dfs(List<List<Integer>> g, int u, boolean[] visited, List<Integer> order) {
        visited[u] = true;
        order.add(u);
        for (int v : g.get(u)) if (!visited[v]) dfs(g, v, visited, order);
    }

    // DFS iterative with an explicit stack (avoids stack overflow on deep graphs). Push neighbours in REVERSE to match the
    // recursive visiting order
    static List<Integer> dfsIterative(List<List<Integer>> g, int start) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[g.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (visited[u]) continue;                           // may have been pushed more than once
            visited[u] = true;
            order.add(u);
            List<Integer> nb = g.get(u);
            for (int i = nb.size() - 1; i >= 0; i--) if (!visited[nb.get(i)]) stack.push(nb.get(i));
        }
        return order;
    }

    // Disconnected graph: run the traversal from EVERY unvisited node
    static List<Integer> bfsAll(List<List<Integer>> g) {
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[g.size()];
        for (int s = 0; s < g.size(); s++) {
            if (visited[s]) continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(s);
            visited[s] = true;
            while (!q.isEmpty()) {
                int u = q.poll();
                order.add(u);
                for (int v : g.get(u)) if (!visited[v]) { visited[v] = true; q.offer(v); }
            }
        }
        return order;
    }

    public static void main(String[] args) {
        List<List<Integer>> g = adj(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {3, 4}});
        System.out.println(bfs(g, 0));                                    // [0, 1, 2, 3, 4]
        List<Integer> d = new ArrayList<>();
        dfs(g, 0, new boolean[5], d);
        System.out.println(d);                                            // [0, 1, 3, 2, 4]
        System.out.println(dfsIterative(g, 0));                           // [0, 1, 3, 2, 4]  (same as recursive)
        List<List<Integer>> split = adj(6, new int[][]{{0, 1}, {1, 2}, {3, 4}});
        System.out.println(bfs(split, 0));                                // [0, 1, 2]  (only the component of 0)
        System.out.println(bfsAll(split));                                // [0, 1, 2, 3, 4, 5]  (all components)
        System.out.println(bfs(adj(1, new int[][]{}), 0));                // [0]
    }
}
