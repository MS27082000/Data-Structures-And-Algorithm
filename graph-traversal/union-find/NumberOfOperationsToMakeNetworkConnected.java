/** Number of Operations to Make Network Connected (LC 1319): n computers (0..n-1), connections[i] = {a, b} cables. In one operation move a cable
 *  from a redundant place to join two disconnected computers. Minimum operations to connect everyone, or -1. */
public class NumberOfOperationsToMakeNetworkConnected {

    private static int find(int[] p, int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }

    // Connecting n computers needs at least n - 1 cables, otherwise -1. Union all cables: every cable joining two nodes ALREADY in the same
    // component is REDUNDANT (a spare). The graph ends with `c` components and we need c - 1 more links, and spares >= c - 1 is guaranteed when
    // cables >= n - 1. So the answer is simply (components - 1). O(n + E * alpha) time, O(n) space
    static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] c : connections) {
            int a = find(parent, c[0]), b = find(parent, c[1]);
            if (a != b) {
                parent[a] = b;
                components--;
            }
        }
        return components - 1;
    }

    public static void main(String[] args) {
        System.out.println(makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));                          // 1  (move the spare cable 1-2 to reach node 3)
        System.out.println(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));          // 2
        System.out.println(makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));                  // -1 (4 cables < 5 needed)
        System.out.println(makeConnected(1, new int[][]{}));                                                // 0
        System.out.println(makeConnected(3, new int[][]{{0, 1}, {1, 2}}));                                  // 0  (already connected)
    }
}
