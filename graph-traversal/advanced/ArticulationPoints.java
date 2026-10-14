import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/** Articulation Points (cut vertices): a node whose removal increases the number of connected components of an undirected graph */
public class ArticulationPoints {

    private static int timer;

    // Same tin/low DFS as bridges. A non-root node u is an articulation point if some DFS child v has low[v] >= tin[u] (the subtree of v can
    // reach u at best, never ABOVE it - note >= here versus > for bridges). The DFS ROOT is one only if it has MORE THAN ONE DFS child.
    // O(V + E) time, O(V + E) space
    static List<Integer> articulationPoints(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        int[] tin = new int[n], low = new int[n];
        boolean[] visited = new boolean[n];
        TreeSet<Integer> points = new TreeSet<>();                       // a Set: a node can qualify through several children
        timer = 0;
        for (int i = 0; i < n; i++) if (!visited[i]) dfs(g, i, -1, tin, low, visited, points);
        return new ArrayList<>(points);
    }

    private static void dfs(List<List<Integer>> g, int u, int parent, int[] tin, int[] low, boolean[] visited, TreeSet<Integer> points) {
        visited[u] = true;
        tin[u] = low[u] = timer++;
        int children = 0;
        for (int v : g.get(u)) {
            if (v == parent) continue;
            if (visited[v]) {
                low[u] = Math.min(low[u], tin[v]);
            } else {
                dfs(g, v, u, tin, low, visited, points);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] >= tin[u] && parent != -1) points.add(u);     // non-root condition
                children++;
            }
        }
        if (parent == -1 && children > 1) points.add(u);                 // root condition
    }

    public static void main(String[] args) {
        System.out.println(articulationPoints(5, new int[][]{{0, 1}, {1, 4}, {2, 4}, {2, 3}, {3, 4}}));   // [1, 4]
        System.out.println(articulationPoints(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));                    // []  (a triangle)
        System.out.println(articulationPoints(4, new int[][]{{0, 1}, {0, 2}, {0, 3}}));                    // [0]  (the centre of a star)
        System.out.println(articulationPoints(3, new int[][]{{0, 1}, {1, 2}}));                            // [1]  (the middle of a path)
        System.out.println(articulationPoints(2, new int[][]{{0, 1}}));                                    // []  (removing a node leaves one node: still "connected")
        System.out.println(articulationPoints(7, new int[][]{{0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}, {4, 5}, {5, 3}}));   // [1, 3]
    }
}
