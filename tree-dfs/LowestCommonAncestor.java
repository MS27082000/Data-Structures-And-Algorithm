import java.util.ArrayDeque;
import java.util.Queue;

/** Lowest Common Ancestor of a Binary Tree (LC 236): the deepest node that has both p and q in its subtree (a node counts as its own descendant) */
public class LowestCommonAncestor {

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

    static TreeNode find(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode l = find(root.left, val);
        return l != null ? l : find(root.right, val);
    }

    // Post-order DFS. Return p or q when found, otherwise null. At a node:
    //   found in BOTH subtrees => this node is the LCA;   found in only one => pass that result upward.
    // (If p is an ancestor of q we return p early: q lies below it, so p is the LCA.) O(n) time, O(h) stack
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;     // p and q are on different sides
        return left != null ? left : right;                 // both in one side (or neither)
    }

    public static void main(String[] args) {
        TreeNode t = build(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        System.out.println(lowestCommonAncestor(t, find(t, 5), find(t, 1)).val);   // 3
        System.out.println(lowestCommonAncestor(t, find(t, 5), find(t, 4)).val);   // 5  (a node is its own ancestor)
        System.out.println(lowestCommonAncestor(t, find(t, 7), find(t, 4)).val);   // 2
        System.out.println(lowestCommonAncestor(t, find(t, 6), find(t, 8)).val);   // 3
        TreeNode two = build(1, 2);
        System.out.println(lowestCommonAncestor(two, find(two, 1), find(two, 2)).val);   // 1
    }
}
