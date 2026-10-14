import java.util.ArrayDeque;
import java.util.Queue;

/** Symmetric Tree (LC 101): is the tree a mirror image of itself around its centre? */
public class SymmetricTree {

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

    // Compare the left subtree with the MIRROR of the right subtree: left.left <-> right.right and left.right <-> right.left.
    // O(n) time, O(h) stack
    static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }

    // Iterative: queue of node PAIRS that must match. O(n) time, O(w) space.
    // NOTE: we enqueue NULL children on purpose, so use LinkedList (ArrayDeque throws NullPointerException on null)
    static boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new java.util.LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode a = q.poll(), b = q.poll();
            if (a == null && b == null) continue;
            if (a == null || b == null || a.val != b.val) return false;
            q.add(a.left);
            q.add(b.right);
            q.add(a.right);
            q.add(b.left);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric(build(1, 2, 2, 3, 4, 4, 3)));                 // true
        System.out.println(isSymmetric(build(1, 2, 2, null, 3, null, 3)));           // false (both 3s are on the same side)
        System.out.println(isSymmetric(build(1)));                                   // true
        System.out.println(isSymmetric(build()));                                    // true
        System.out.println(isSymmetric(build(1, 2, 3)));                             // false
        System.out.println(isSymmetricIterative(build(1, 2, 2, 3, 4, 4, 3)));        // true
        System.out.println(isSymmetricIterative(build(1, 2, 2, null, 3, null, 3)));  // false
    }
}
