import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/** Boundary Traversal of a Binary Tree (anti-clockwise): root, left boundary, leaves (left to right), right boundary (bottom to top) */
public class BoundaryTraversal {

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

    private static boolean isLeaf(TreeNode n) { return n.left == null && n.right == null; }

    // Three separate walks, each excluding leaves where needed so nothing is listed twice. O(n) time, O(h) extra space
    static List<Integer> boundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val);                  // a lone root is added once, as a leaf, below
        // 1) LEFT boundary top-down, excluding leaves: prefer the left child, otherwise the right child
        TreeNode cur = root.left;
        while (cur != null) {
            if (!isLeaf(cur)) res.add(cur.val);
            cur = (cur.left != null) ? cur.left : cur.right;
        }
        // 2) LEAVES left to right (any traversal that visits left before right)
        addLeaves(root, res);
        // 3) RIGHT boundary bottom-up, excluding leaves: collect top-down then reverse
        List<Integer> right = new ArrayList<>();
        cur = root.right;
        while (cur != null) {
            if (!isLeaf(cur)) right.add(cur.val);
            cur = (cur.right != null) ? cur.right : cur.left;
        }
        Collections.reverse(right);
        res.addAll(right);
        return res;
    }

    private static void addLeaves(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    public static void main(String[] args) {
        System.out.println(boundary(build(1, 2, 3, 4, 5, 6, 7)));                       // [1, 2, 4, 5, 6, 7, 3]
        System.out.println(boundary(build(1, 2, 3, 4, 5, null, 6, null, null, 7, 8)));  // [1, 2, 4, 7, 8, 6, 3]
        System.out.println(boundary(build(1)));                                         // [1]
        System.out.println(boundary(build(1, 2, null, 3)));                             // [1, 2, 3]
        System.out.println(boundary(build(1, null, 2, null, 3)));                       // [1, 3, 2]
        System.out.println(boundary(build()));                                          // []
    }
}
