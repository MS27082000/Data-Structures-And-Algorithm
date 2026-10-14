/** M-Coloring Problem: can the graph's vertices be coloured with at most m colours so adjacent vertices differ? */
public class MColoring {

    // Try each colour for vertex v; prune if a neighbour already has it. O(m^V) worst case, O(V) stack
    static boolean graphColoring(boolean[][] graph, int m) {
        int v = graph.length;
        return color(0, graph, new int[v], m);
    }

    private static boolean color(int vertex, boolean[][] g, int[] colors, int m) {
        if (vertex == g.length) return true;                       // every vertex coloured
        for (int c = 1; c <= m; c++) {
            if (isSafe(vertex, g, colors, c)) {
                colors[vertex] = c;
                if (color(vertex + 1, g, colors, m)) return true;
                colors[vertex] = 0;                                // backtrack
            }
        }
        return false;
    }

    private static boolean isSafe(int vertex, boolean[][] g, int[] colors, int c) {
        for (int u = 0; u < g.length; u++) {
            if (g[vertex][u] && colors[u] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[][] triangle = {
                {false, true, true},
                {true, false, true},
                {true, true, false}};
        System.out.println(graphColoring(triangle, 3));    // true
        System.out.println(graphColoring(triangle, 2));    // false (a triangle needs 3 colours)
        boolean[][] square = {
                {false, true, false, true},
                {true, false, true, false},
                {false, true, false, true},
                {true, false, true, false}};
        System.out.println(graphColoring(square, 2));      // true (even cycle is bipartite)
        System.out.println(graphColoring(new boolean[][]{{false}}, 1)); // true
    }
}
