import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/** Find Eventual Safe States (LC 802): a node is SAFE if every path starting from it ends at a terminal node (no outgoing edges) - i.e.
 *  it is not on a cycle and cannot reach one. Return the safe nodes in ascending order. */
public class EventualSafeStates {

    // REVERSE the graph and run Kahn's algorithm from the TERMINAL nodes (out-degree 0): a node becomes safe once all of its
    // outgoing neighbours are safe. Nodes on or leading to a cycle never reach out-degree 0. O(V + E) time, O(V + E) space
    static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) reverse.add(new ArrayList<>());
        int[] outdeg = new int[n];
        for (int u = 0; u < n; u++) {
            outdeg[u] = graph[u].length;
            for (int v : graph[u]) reverse.get(v).add(u);          // reversed edge v -> u
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (outdeg[i] == 0) q.offer(i);
        List<Integer> safe = new ArrayList<>();
        while (!q.isEmpty()) {
            int v = q.poll();
            safe.add(v);
            for (int u : reverse.get(v)) if (--outdeg[u] == 0) q.offer(u);
        }
        Collections.sort(safe);
        return safe;
    }

    // DFS alternative with the 3-state trick: a node is unsafe if it lies on a cycle or reaches one
    static List<Integer> viaDfs(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];                                  // 0 unvisited, 1 in progress / unsafe, 2 safe
        List<Integer> safe = new ArrayList<>();
        for (int i = 0; i < n; i++) if (isSafe(graph, i, state)) safe.add(i);
        return safe;
    }

    private static boolean isSafe(int[][] g, int u, int[] state) {
        if (state[u] != 0) return state[u] == 2;
        state[u] = 1;                                              // on the current path
        for (int v : g[u]) if (!isSafe(g, v, state)) return false; // reaching an in-progress or unsafe node => unsafe
        state[u] = 2;
        return true;
    }

    public static void main(String[] args) {
        int[][] g = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(g) + " " + viaDfs(g));                                  // [2, 4, 5, 6] [2, 4, 5, 6]
        System.out.println(eventualSafeNodes(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}})); // [4]
        System.out.println(eventualSafeNodes(new int[][]{{}, {}}));                                   // [0, 1]  (all terminal)
        System.out.println(eventualSafeNodes(new int[][]{{1}, {0}}));                                 // []  (a 2-cycle)
        System.out.println(viaDfs(new int[][]{{0}}));                                                 // []  (self loop)
    }
}
