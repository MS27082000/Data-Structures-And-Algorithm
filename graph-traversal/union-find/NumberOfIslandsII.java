import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Number of Islands II (LC 305): an m x n grid of water. Land is added one cell at a time (positions[i] = {r, c}). After EACH addition return the
 *  number of islands. (Online problem: the number of islands changes dynamically, which is exactly what Union-Find is good at.) */
public class NumberOfIslandsII {

    private static int find(int[] p, int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }

    // Adding a land cell first counts as +1 island; then union it with each of its 4 land neighbours - every union of two DIFFERENT
    // components merges two islands (-1). A duplicate position changes nothing. O(K * alpha) time for K additions, O(m * n) space
    static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);                                      // -1 = water; otherwise the cell is land and parent[i] is its DSU parent
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int[] pos : positions) {
            int id = pos[0] * n + pos[1];
            if (parent[id] != -1) {                                   // already land: nothing changes
                result.add(count);
                continue;
            }
            parent[id] = id;
            count++;
            for (int[] d : dirs) {
                int nr = pos[0] + d[0], nc = pos[1] + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || parent[nr * n + nc] == -1) continue;
                int a = find(parent, id), b = find(parent, nr * n + nc);
                if (a != b) {
                    parent[a] = b;
                    count--;                                          // two islands became one
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));           // [1, 1, 2, 3]
        System.out.println(numIslands2(1, 1, new int[][]{{0, 0}}));                                    // [1]
        System.out.println(numIslands2(3, 3, new int[][]{{0, 0}, {0, 0}, {1, 1}}));                    // [1, 1, 2]  (a repeated cell)
        System.out.println(numIslands2(3, 3, new int[][]{{0, 0}, {2, 2}, {1, 1}, {0, 1}, {1, 2}}));    // [1, 2, 3, 2, 1]  (diagonals don't join; (0,1) then (1,2) bridge them)
        System.out.println(numIslands2(2, 2, new int[][]{{0, 0}, {1, 1}, {0, 1}, {1, 0}}));            // [1, 2, 1, 1]
    }
}
