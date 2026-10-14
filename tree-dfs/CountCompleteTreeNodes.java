import java.util.ArrayDeque;
import java.util.Queue;

/** Count Complete Tree Nodes (LC 222): count the nodes of a COMPLETE binary tree in better than O(n) */
public class CountCompleteTreeNodes {

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

    // If the leftmost height equals the rightmost height the subtree is PERFECT: it has 2^h - 1 nodes (a formula, no traversal).
    // Otherwise recurse on both children. At most one child is not perfect, so only one branch recurses deeply.
    // O(log^2 n) time, O(log n) stack
    static int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = leftHeight(root), right = rightHeight(root);
        if (left == right) return (1 << left) - 1;                 // perfect tree
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int leftHeight(TreeNode n) {
        int h = 0;
        while (n != null) { h++; n = n.left; }
        return h;
    }

    private static int rightHeight(TreeNode n) {
        int h = 0;
        while (n != null) { h++; n = n.right; }
        return h;
    }

    // O(n) baseline for comparison
    static int countNodesSimple(TreeNode root) {
        return root == null ? 0 : 1 + countNodesSimple(root.left) + countNodesSimple(root.right);
    }

    public static void main(String[] args) {
        System.out.println(countNodes(build(1, 2, 3, 4, 5, 6)));              // 6
        System.out.println(countNodes(build()));                              // 0
        System.out.println(countNodes(build(1)));                             // 1
        System.out.println(countNodes(build(1, 2, 3, 4, 5, 6, 7)));           // 7  (perfect: formula only)
        System.out.println(countNodes(build(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))); // 10
        System.out.println(countNodes(build(1, 2, 3, 4)) == countNodesSimple(build(1, 2, 3, 4)));   // true
    }
}
