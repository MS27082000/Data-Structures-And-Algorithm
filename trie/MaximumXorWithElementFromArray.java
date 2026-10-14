import java.util.Arrays;

/** Maximum XOR With an Element From Array (LC 1707): for each query (x, m), the max of x ^ nums[j] over nums[j] <= m; -1 if none */
public class MaximumXorWithElementFromArray {

    private static class Node {
        Node zero, one;
    }

    private static void insert(Node root, int x) {
        Node cur = root;
        for (int i = 30; i >= 0; i--) {
            if (((x >> i) & 1) == 0) { if (cur.zero == null) cur.zero = new Node(); cur = cur.zero; }
            else { if (cur.one == null) cur.one = new Node(); cur = cur.one; }
        }
    }

    private static int maxXor(Node root, int x) {
        Node cur = root;
        int val = 0;
        for (int i = 30; i >= 0; i--) {
            int b = (x >> i) & 1;
            Node want = b == 0 ? cur.one : cur.zero;
            if (want != null) { val |= (1 << i); cur = want; }
            else cur = b == 0 ? cur.zero : cur.one;
        }
        return val;
    }

    // OFFLINE trick: sort the nums and sort the queries by m. Sweep the queries in increasing m, inserting every num <= m into the trie before
    // answering. Each query then only sees allowed numbers. O((n + q) * 31 + n log n + q log q) time, O(31 * n) space
    static int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int q = queries.length;
        Integer[] order = new Integer[q];
        for (int i = 0; i < q; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a][1], queries[b][1]));
        int[] ans = new int[q];
        Node root = new Node();
        int p = 0;
        for (int idx : order) {
            int x = queries[idx][0], m = queries[idx][1];
            while (p < nums.length && nums[p] <= m) insert(root, nums[p++]);
            ans[idx] = p == 0 ? -1 : maxXor(root, x);                   // nothing inserted => no allowed element
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maximizeXor(new int[]{0, 1, 2, 3, 4}, new int[][]{{3, 1}, {1, 3}, {5, 6}})));    // [3, 3, 7]
        System.out.println(Arrays.toString(maximizeXor(new int[]{5, 2, 4, 6, 6, 3}, new int[][]{{12, 4}, {8, 1}, {6, 3}})));   // [15, -1, 5]
        System.out.println(Arrays.toString(maximizeXor(new int[]{10}, new int[][]{{3, 5}})));                                // [-1]
        System.out.println(Arrays.toString(maximizeXor(new int[]{1, 2, 3}, new int[][]{{0, 3}, {7, 1}})));                   // [3, 6]
    }
}
