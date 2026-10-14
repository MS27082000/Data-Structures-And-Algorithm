import java.util.ArrayDeque;
import java.util.Queue;

/** Binary Tree Maximum Path Sum (LC 124): the largest sum of any path (a sequence of connected nodes, going down on both sides of a "turning" node) */
public class MaxPathSum {

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

    private static int best;

    // gain(node) = the best sum of a path that STARTS at node and goes down ONE side (what a parent can use).
    // The best path TURNING at node = node.val + gain(left) + gain(right). A negative gain is dropped (use 0). O(n) time, O(h) stack
    static int maxPathSum(TreeNode root) {
        best = Integer.MIN_VALUE;                            // NOT 0: all-negative trees have a negative answer
        gain(root);
        return best;
    }

    private static int gain(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, gain(node.left));             // ignore a branch that would only reduce the sum
        int right = Math.max(0, gain(node.right));
        best = Math.max(best, node.val + left + right);      // path that bends at this node
        return node.val + Math.max(left, right);             // a parent can extend only ONE side
    }

    public static void main(String[] args) {
        System.out.println(maxPathSum(build(1, 2, 3)));                         // 6
        System.out.println(maxPathSum(build(-10, 9, 20, null, null, 15, 7)));   // 42  (15 + 20 + 7)
        System.out.println(maxPathSum(build(-3)));                              // -3
        System.out.println(maxPathSum(build(-2, -1)));                          // -1
        System.out.println(maxPathSum(build(2, -1)));                           // 2
        System.out.println(maxPathSum(build(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1))); // 48
    }
}
