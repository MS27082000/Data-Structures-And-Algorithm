import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/** Minimum Spanning Tree (theory + Prim's algorithm). An MST of a connected, weighted, undirected graph is a subset of V - 1 edges that
 *  connects every node (no cycle) with the minimum possible total weight. */
public class PrimsAlgorithm {

    // Prim: GROW one tree from node 0. A min-heap holds the edges leaving the tree; repeatedly take the cheapest edge that reaches a
    // node not yet in the tree (CUT PROPERTY: the lightest edge crossing any cut belongs to some MST). O(E log V) time, O(V + E) space
    static long primWeight(int n, int[][] edges) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int[] e : edges) {
            g.get(e[0]).add(new int[]{e[1], e[2]});
            g.get(e[1]).add(new int[]{e[0], e[2]});
        }
        boolean[] inTree = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));   // {weight, node}
        pq.offer(new int[]{0, 0});
        long total = 0;
        int taken = 0;
        while (!pq.isEmpty() && taken < n) {
            int[] cur = pq.poll();
            int u = cur[1];
            if (inTree[u]) continue;                                // the edge leads to a node that is already connected
            inTree[u] = true;
            total += cur[0];
            taken++;
            for (int[] e : g.get(u)) if (!inTree[e[0]]) pq.offer(new int[]{e[1], e[0]});
        }
        return taken == n ? total : -1;                             // -1: the graph is disconnected, no spanning tree
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}};
        System.out.println(primWeight(5, edges));                                           // 16  (0-1:2, 1-2:3, 1-4:5, 0-3:6)
        System.out.println(primWeight(3, new int[][]{{0, 1, 5}, {1, 2, 3}, {0, 2, 1}}));    // 4   (0-2:1 + 1-2:3)
        System.out.println(primWeight(3, new int[][]{{0, 1, 1}}));                          // -1  (node 2 is isolated)
        System.out.println(primWeight(1, new int[][]{}));                                   // 0
        System.out.println(primWeight(4, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 0, 1}}));   // 3  (any 3 of the 4 equal edges)
    }
}
