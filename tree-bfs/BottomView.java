import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/** Bottom View of a Binary Tree: the nodes visible when looking from below, left to right */
public class BottomView {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static TreeNode build(Integer... a) {
        if (a.length == 0 || a[0] == null) return null;
        TreeNode root = new TreeNode(a[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < a.length) {
            TreeNode n = q.poll();
            if (i < a.length && a[i] != null) { n.left = new TreeNode(a[i]); q.add(n.left); }
            i++;
            if (i < a.length && a[i] != null) { n.right = new TreeNode(a[i]); q.add(n.right); }
            i++;
        }
        return root;
    }

    // Same as Top View but OVERWRITE: the LAST node reached in each column (deepest; the later one at equal depth) wins.
    // O(n log n) time, O(n) space
    static List<Integer> bottomView(TreeNode root) {
        TreeMap<Integer, Integer> lastInColumn = new TreeMap<>();
        Queue<Object[]> queue = new ArrayDeque<>();
        if (root != null) queue.offer(new Object[]{root, 0});
        while (!queue.isEmpty()) {
            Object[] cur = queue.poll();
            TreeNode node = (TreeNode) cur[0];
            int col = (int) cur[1];
            lastInColumn.put(col, node.val);                        // overwrite: deeper nodes come later in BFS
            if (node.left != null) queue.offer(new Object[]{node.left, col - 1});
            if (node.right != null) queue.offer(new Object[]{node.right, col + 1});
        }
        return new ArrayList<>(lastInColumn.values());
    }

    public static void main(String[] args) {
        System.out.println(bottomView(build(1, 2, 3, 4, 5, 6, 7)));           // [4, 2, 6, 3, 7]
        System.out.println(bottomView(build(20, 8, 22, 5, 3, 4, 25)));        // [5, 8, 4, 22, 25]  (3 and 4 share column 0: the later one, 4, wins)
        System.out.println(bottomView(build(1, 2, null, 3)));                 // [3, 2, 1]
        System.out.println(bottomView(build(10, 20, 30, 40, 60, 90, 100)));   // [40, 20, 90, 30, 100]  (60 and 90 share column 0: 90 is later at that level)
        System.out.println(bottomView(build()));                              // []
    }
}
