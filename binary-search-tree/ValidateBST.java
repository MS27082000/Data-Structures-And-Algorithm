import java.util.ArrayDeque;
import java.util.Queue;

/** Validate Binary Search Tree (LC 98): is the tree a valid BST? */
public class ValidateBST {

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

    // Every node must lie strictly inside an open interval (low, high) inherited from its ANCESTORS. Going left tightens `high`,
    // going right tightens `low`. Use long bounds so Integer.MIN_VALUE / MAX_VALUE nodes are handled. O(n) time, O(h) stack
    static boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean check(TreeNode node, long low, long high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) return false;
        return check(node.left, low, node.val) && check(node.right, node.val, high);
    }

    // Alternative: inorder must be STRICTLY increasing. Track the previous value. O(n) time, O(h) stack
    private static Long prev;

    static boolean isValidInorder(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private static boolean inorder(TreeNode n) {
        if (n == null) return true;
        if (!inorder(n.left)) return false;
        if (prev != null && n.val <= prev) return false;
        prev = (long) n.val;
        return inorder(n.right);
    }

    public static void main(String[] args) {
        System.out.println(isValidBST(build(2, 1, 3)));                         // true
        System.out.println(isValidBST(build(5, 1, 4, null, null, 3, 6)));       // false (4 < 5 on the right side)
        System.out.println(isValidBST(build(5, 4, 6, null, null, 3, 7)));       // false (3 is in the right subtree of 5 but 3 < 5)
        System.out.println(isValidBST(build(2, 2, 2)));                         // false (duplicates are not allowed)
        System.out.println(isValidBST(build(Integer.MAX_VALUE)));               // true
        System.out.println(isValidBST(build(Integer.MIN_VALUE, null, Integer.MAX_VALUE))); // true (long bounds)
        System.out.println(isValidInorder(build(5, 1, 4, null, null, 3, 6)));   // false
        System.out.println(isValidInorder(build(8, 4, 12, 2, 6, 10, 14)));      // true
    }
}
