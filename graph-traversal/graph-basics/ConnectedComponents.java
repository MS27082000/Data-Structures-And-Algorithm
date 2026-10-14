import java.util.ArrayList;
import java.util.List;

/** Connected Components (undirected graph): count them and list their nodes */
public class ConnectedComponents {

    static List<List<Integer>> adj(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        return g;
    }

    // Start a DFS from every unvisited node; each start discovers one whole component. O(V + E) time, O(V) space
    static List<List<Integer>> components(int n, int[][] edges) {
        List<List<Integer>> g = adj(n, edges);
        boolean[] visited = new boolean[n];
        List<List<Integer>> result = new ArrayList<>();
        for (int s = 0; s < n; s++) {
            if (!visited[s]) {
                List<Integer> comp = new ArrayList<>();
                dfs(g, s, visited, comp);
                result.add(comp);
            }
        }
        return result;
    }

    private static void dfs(List<List<Integer>> g, int u, boolean[] visited, List<Integer> comp) {
        visited[u] = true;
        comp.add(u);
        for (int v : g.get(u)) if (!visited[v]) dfs(g, v, visited, comp);
    }

    static int count(int n, int[][] edges) {
        return components(n, edges).size();
    }

    public static void main(String[] args) {
        System.out.println(components(6, new int[][]{{0, 1}, {1, 2}, {3, 4}}));   // [[0, 1, 2], [3, 4], [5]]
        System.out.println(count(5, new int[][]{}));                              // 5  (no edges: every node alone)
        System.out.println(count(4, new int[][]{{0, 1}, {1, 2}, {2, 3}}));        // 1
        System.out.println(count(0, new int[][]{}));                              // 0
        System.out.println(count(6, new int[][]{{0, 1}, {2, 3}, {4, 5}, {1, 2}})); // 2
        // k components need at least V - k edges to be built; a connected graph needs >= V - 1 edges
    }
}
