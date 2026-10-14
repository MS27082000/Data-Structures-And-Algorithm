import java.util.ArrayDeque;
import java.util.Queue;

/** Introduction to Binary Trees: node structure, building a tree, and the basic measurements (size, height, leaves) + tree types */
public class TreeBasics {

    static class TreeNode {
        int val;
        TreeNode left, right;                 // each node has at most TWO children
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

    static int size(TreeNode n)   { return n == null ? 0 : 1 + size(n.left) + size(n.right); }
    static int height(TreeNode n) { return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right)); }   // in NODES (empty = 0)
    static int leaves(TreeNode n) {
        if (n == null) return 0;
        if (n.left == null && n.right == null) return 1;
        return leaves(n.left) + leaves(n.right);
    }

    // Full: every node has 0 or 2 children
    static boolean isFull(TreeNode n) {
        if (n == null) return true;
        if ((n.left == null) != (n.right == null)) return false;
        return isFull(n.left) && isFull(n.right);
    }

    // Perfect: all internal nodes have 2 children and all leaves are at the same depth => size == 2^height - 1
    static boolean isPerfect(TreeNode n) {
        return size(n) == (1 << height(n)) - 1;
    }

    public static void main(String[] args) {
        TreeNode t = build(1, 2, 3, 4, 5, 6, 7);
        System.out.println(size(t) + " " + height(t) + " " + leaves(t));           // 7 3 4
        System.out.println(isFull(t) + " " + isPerfect(t));                         // true true
        TreeNode skew = build(1, 2, null, 3, null, 4);
        System.out.println(size(skew) + " " + height(skew) + " " + leaves(skew));   // 4 4 1   (skewed: height == size)
        System.out.println(isFull(skew) + " " + isPerfect(skew));                   // false false
        TreeNode partial = build(1, 2, 3, 4, 5);
        System.out.println(isFull(partial) + " " + isPerfect(partial));             // true false
        System.out.println(size(null) + " " + height(null));                        // 0 0
    }
}
