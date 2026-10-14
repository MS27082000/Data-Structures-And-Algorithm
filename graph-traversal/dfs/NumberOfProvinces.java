/** Number of Provinces (LC 547): isConnected[i][j] == 1 means cities i and j are directly connected. Count the groups */
public class NumberOfProvinces {

    // The input is an ADJACENCY MATRIX. DFS from each unvisited city; every start = one new province. O(V^2) time, O(V) space
    static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, provinces = 0;
        boolean[] visited = new boolean[n];
        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                provinces++;
                dfs(isConnected, city, visited);
            }
        }
        return provinces;
    }

    private static void dfs(int[][] m, int u, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < m.length; v++) {
            if (m[u][v] == 1 && !visited[v]) dfs(m, v, visited);
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));            // 2
        System.out.println(findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));            // 3
        System.out.println(findCircleNum(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));            // 1
        System.out.println(findCircleNum(new int[][]{{1}}));                                        // 1
        System.out.println(findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));   // 1
    }
}
