import java.util.HashSet;
import java.util.Set;

/** Most Stones Removed with Same Row or Column (LC 947): a stone can be removed if another stone remains in its row or column.
 *  Maximum number of stones that can be removed. */
public class MostStonesRemoved {

    private static int find(int[] p, int x) {
        while (p[x] != x) {
            p[x] = p[p[x]];
            x = p[x];
        }
        return x;
    }

    // Stones sharing a row or column form a CONNECTED group, and in every group of k stones you can remove k - 1 (leave exactly one).
    // So the answer = stones - (number of groups). Model rows and columns as NODES (column j becomes node maxRow + 1 + j) and a stone (r, c)
    // as an edge joining row r with column c. Count the components that actually contain a stone. O(S * alpha) time, O(maxRow + maxCol) space
    static int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;
        for (int[] s : stones) {
            maxRow = Math.max(maxRow, s[0]);
            maxCol = Math.max(maxCol, s[1]);
        }
        int[] parent = new int[maxRow + maxCol + 2];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        for (int[] s : stones) {
            int a = find(parent, s[0]), b = find(parent, maxRow + 1 + s[1]);
            if (a != b) parent[a] = b;
        }
        Set<Integer> groups = new HashSet<>();
        for (int[] s : stones) groups.add(find(parent, s[0]));            // one root per group that owns at least one stone
        return stones.length - groups.size();
    }

    public static void main(String[] args) {
        System.out.println(removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));    // 5
        System.out.println(removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));            // 3
        System.out.println(removeStones(new int[][]{{0, 0}}));                                            // 0  (the last stone stays)
        System.out.println(removeStones(new int[][]{{0, 0}, {1, 1}, {2, 2}}));                            // 0  (no shared row/column)
        System.out.println(removeStones(new int[][]{{0, 0}, {0, 1}, {0, 2}}));                            // 2
    }
}
