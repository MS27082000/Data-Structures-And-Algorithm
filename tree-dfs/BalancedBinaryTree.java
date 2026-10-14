import java.util.ArrayDeque;
import java.util.Queue;

/** Balanced Binary Tree (LC 110): for EVERY node the heights of its left and right subtrees differ by at most 1 */
public class BalancedBinaryTree {

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

    // Naive: height() for every node => O(n^2) on skewed trees
    static boolean isBalancedNaive(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalancedNaive(root.left) && isBalancedNaive(root.right);
    }

    private static int height(TreeNode n) {
        return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right));
    }

    // Optimal: compute the height AND check balance in one bottom-up pass. Return -1 as soon as any subtree is unbalanced
    // so the failure propagates upward. O(n) time, O(h) stack
    static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        if (left == -1) return -1;                         // early exit
        int right = checkHeight(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;         // this node is unbalanced
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println(isBalanced(build(3, 9, 20, null, null, 15, 7)));            // true
        System.out.println(isBalanced(build(1, 2, 2, 3, 3, null, null, 4, 4)));        // false
        System.out.println(isBalanced(build()));                                       // true
        System.out.println(isBalanced(build(1, 2, null, 3)));                          // false (left-skewed chain of 3)
        System.out.println(isBalanced(build(1, 2, 3, 4, 5, 6, 7)));                    // true
        System.out.println(isBalancedNaive(build(1, 2, 2, 3, 3, null, null, 4, 4)));   // false
        System.out.println(isBalanced(build(1, 2, 2, 3, null, null, 3, 4, null, null, 4))); // false (every node's HEIGHT diff must be checked, not just the root's)
    }
}
