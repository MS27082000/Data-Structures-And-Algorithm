import java.util.ArrayDeque;
import java.util.Queue;

/** Same Tree (LC 100): are two binary trees identical (same structure AND same values)? */
public class IdenticalTrees {

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

    // Simultaneous DFS on both trees. O(min(n, m)) time (stops at the first mismatch), O(h) stack
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;           // both ended together
        if (p == null || q == null) return false;          // structure differs
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(isSameTree(build(1, 2, 3), build(1, 2, 3)));                  // true
        System.out.println(isSameTree(build(1, 2), build(1, null, 2)));                  // false (same values, different shape)
        System.out.println(isSameTree(build(1, 2, 1), build(1, 1, 2)));                  // false (same shape, different values)
        System.out.println(isSameTree(build(), build()));                                // true
        System.out.println(isSameTree(build(1), build()));                               // false
        System.out.println(isSameTree(build(1, 2, 3, 4, 5, 6, 7), build(1, 2, 3, 4, 5, 6, 7))); // true
    }
}
