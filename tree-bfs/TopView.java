import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/** Top View of a Binary Tree: the nodes visible when looking from above, left to right */
public class TopView {

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

    // BFS tracking each node's horizontal distance (column). The FIRST node reached in each column is the top-most one.
    // BFS (not DFS) guarantees we meet shallower nodes first. O(n log n) with TreeMap (O(n) with min/max column tracking)
    static List<Integer> topView(TreeNode root) {
        TreeMap<Integer, Integer> firstInColumn = new TreeMap<>();
        Queue<Object[]> queue = new ArrayDeque<>();                 // {node, column}
        if (root != null) queue.offer(new Object[]{root, 0});
        while (!queue.isEmpty()) {
            Object[] cur = queue.poll();
            TreeNode node = (TreeNode) cur[0];
            int col = (int) cur[1];
            firstInColumn.putIfAbsent(col, node.val);               // keep only the first (highest) node per column
            if (node.left != null) queue.offer(new Object[]{node.left, col - 1});
            if (node.right != null) queue.offer(new Object[]{node.right, col + 1});
        }
        return new ArrayList<>(firstInColumn.values());
    }

    public static void main(String[] args) {
        System.out.println(topView(build(1, 2, 3, 4, 5, 6, 7)));           // [4, 2, 1, 3, 7]
        System.out.println(topView(build(1, 2, 3, null, 4, null, null)));   // [2, 1, 3]
        System.out.println(topView(build(1, 2, null, 3)));                  // [3, 2, 1] (left-skewed)
        System.out.println(topView(build(10, 20, 30, 40, 60, 90, 100)));    // [40, 20, 10, 30, 100]
        System.out.println(topView(build()));                               // []
    }
}
