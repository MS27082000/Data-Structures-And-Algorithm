import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/** Is Graph Bipartite? (LC 785): can the nodes be coloured with 2 colours so every edge joins different colours? (= no odd-length cycle) */
public class BipartiteGraph {

    // BFS colouring: give a node colour 0, its neighbours the opposite colour, and so on. A neighbour already holding the SAME
    // colour => odd cycle => not bipartite. Handle every component. O(V + E) time, O(V) space
    static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int s = 0; s < n; s++) {
            if (color[s] != -1) continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(s);
            color[s] = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph[u]) {
                    if (color[v] == -1) {
                        color[v] = 1 - color[u];
                        q.offer(v);
                    } else if (color[v] == color[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // DFS version
    static boolean isBipartiteDfs(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        for (int s = 0; s < graph.length; s++) {
            if (color[s] == -1 && !paint(graph, s, 0, color)) return false;
        }
        return true;
    }

    private static boolean paint(int[][] g, int u, int c, int[] color) {
        color[u] = c;
        for (int v : g[u]) {
            if (color[v] == -1) {
                if (!paint(g, v, 1 - c, color)) return false;
            } else if (color[v] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] odd = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};          // contains a triangle 0-1-2
        int[][] even = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};               // a 4-cycle
        System.out.println(isBipartite(odd) + " " + isBipartiteDfs(odd));        // false false
        System.out.println(isBipartite(even) + " " + isBipartiteDfs(even));      // true true
        System.out.println(isBipartite(new int[][]{{}, {}, {}}));                 // true (no edges)
        System.out.println(isBipartite(new int[][]{{1}, {0}, {3}, {2}}));         // true (two separate edges: disconnected)
        System.out.println(isBipartite(new int[][]{{1, 2}, {0, 2}, {0, 1}}));     // false (triangle)
    }
}
