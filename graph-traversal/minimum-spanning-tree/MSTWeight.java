import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Find the MST Weight with Kruskal's algorithm (sort edges + Disjoint Set) */
public class MSTWeight {

    private static int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];                          // path compression (halving)
            x = parent[x];
        }
        return x;
    }

    // Kruskal: consider edges from LIGHTEST to heaviest; keep an edge if it joins two DIFFERENT components (a Disjoint Set answers
    // that in ~O(1)), otherwise it would create a cycle. Stop after V - 1 edges. O(E log E) time (the sort), O(V) space
    static long kruskal(int n, int[][] edges, List<int[]> chosen) {
        int[][] sorted = edges.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[2], b[2]));
        int[] parent = new int[n], size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        long total = 0;
        int used = 0;
        for (int[] e : sorted) {
            int a = find(parent, e[0]), b = find(parent, e[1]);
            if (a == b) continue;                                   // same component: this edge would close a cycle
            if (size[a] < size[b]) { int t = a; a = b; b = t; }     // union by size
            parent[b] = a;
            size[a] += size[b];
            total += e[2];
            if (chosen != null) chosen.add(e);
            if (++used == n - 1) break;
        }
        return used == n - 1 ? total : -1;                          // fewer than V-1 edges: disconnected
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 3, 6}, {1, 2, 3}, {1, 3, 8}, {1, 4, 5}, {2, 4, 7}};
        List<int[]> chosen = new ArrayList<>();
        System.out.println(kruskal(5, edges, chosen));                                      // 16
        StringBuilder sb = new StringBuilder();
        for (int[] e : chosen) sb.append(e[0]).append('-').append(e[1]).append(':').append(e[2]).append(' ');
        System.out.println(sb.toString().trim());                                           // 0-1:2 1-2:3 1-4:5 0-3:6
        System.out.println(kruskal(3, new int[][]{{0, 1, 5}, {1, 2, 3}, {0, 2, 1}}, null)); // 4
        System.out.println(kruskal(3, new int[][]{{0, 1, 1}}, null));                       // -1  (disconnected)
        System.out.println(kruskal(1, new int[][]{}, null));                                // 0
        System.out.println(kruskal(4, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 1}, {3, 0, 1}}, null));   // 3
    }
}
