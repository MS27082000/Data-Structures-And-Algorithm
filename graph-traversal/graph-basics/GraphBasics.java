import java.util.ArrayList;
import java.util.List;

/** Introduction to Graphs: representations (adjacency list vs matrix), directed vs undirected, weighted, degree */
public class GraphBasics {

    // ---- Adjacency LIST: O(V + E) space. The default choice for sparse graphs ----
    static List<List<Integer>> adjList(int n, int[][] edges, boolean directed) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            if (!directed) adj.get(e[1]).add(e[0]);            // an undirected edge is stored in BOTH directions
        }
        return adj;
    }

    // ---- Adjacency MATRIX: O(V^2) space, O(1) edge lookup. Good for dense graphs / Floyd-Warshall ----
    static int[][] adjMatrix(int n, int[][] edges, boolean directed) {
        int[][] m = new int[n][n];
        for (int[] e : edges) {
            m[e[0]][e[1]] = 1;
            if (!directed) m[e[1]][e[0]] = 1;
        }
        return m;
    }

    // ---- Weighted adjacency list: each neighbour is {node, weight} ----
    static List<List<int[]>> weightedAdj(int n, int[][] edges, boolean directed) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            if (!directed) adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        List<List<Integer>> undirected = adjList(4, edges, false);
        List<List<Integer>> directed = adjList(4, edges, true);
        System.out.println(undirected);                       // [[1, 2], [0, 2], [0, 1, 3], [2]]
        System.out.println(directed);                         // [[1, 2], [2], [3], []]

        // degree: undirected = neighbours; directed has in-degree and out-degree
        System.out.println(undirected.get(2).size());         // 3  (degree of node 2)
        int[] indeg = new int[4];
        for (List<Integer> nb : directed) for (int v : nb) indeg[v]++;
        System.out.println(java.util.Arrays.toString(indeg)); // [0, 1, 2, 1]
        System.out.println(directed.get(0).size());           // 2  (out-degree of node 0)

        System.out.println(java.util.Arrays.deepToString(adjMatrix(4, edges, false)));
        // [[0, 1, 1, 0], [1, 0, 1, 0], [1, 1, 0, 1], [0, 0, 1, 0]]  (symmetric for undirected)

        List<List<int[]>> w = weightedAdj(3, new int[][]{{0, 1, 5}, {1, 2, 3}}, false);
        System.out.println(w.get(1).get(0)[0] + ":" + w.get(1).get(0)[1] + " " + w.get(1).get(1)[0] + ":" + w.get(1).get(1)[1]);   // 0:5 2:3

        // edges <= V*(V-1)/2 for a simple undirected graph; a tree has V-1 edges
        System.out.println(4 * 3 / 2);                        // 6  (max edges for 4 nodes)
    }
}
