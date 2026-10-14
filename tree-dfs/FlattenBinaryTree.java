import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Flatten Binary Tree to Linked List (LC 114): rewire the tree IN PLACE into a "linked list" along the right pointers, in preorder */
public class FlattenBinaryTree {

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

    // O(1) extra space (Morris-style). For each node with a left child: find the RIGHTMOST node of the left subtree, hang the
    // node's right subtree on it, move the left subtree to the right, and clear left. O(n) time, O(1) space
    static void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode rightmost = cur.left;
                while (rightmost.right != null) rightmost = rightmost.right;
                rightmost.right = cur.right;                  // the old right subtree follows the end of the left subtree
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    // Recursive alternative: process right, then left, keeping a `prev` pointer (reverse preorder). O(n) time, O(h) stack
    private static TreeNode prev = null;

    static void flattenRecursive(TreeNode node) {
        if (node == null) return;
        flattenRecursive(node.right);
        flattenRecursive(node.left);
        node.right = prev;
        node.left = null;
        prev = node;
    }

    static List<Integer> chain(TreeNode root) {                 // read along right pointers; also verifies left is always null
        List<Integer> out = new ArrayList<>();
        for (TreeNode n = root; n != null; n = n.right) {
            out.add(n.val);
            if (n.left != null) out.add(-999);                  // flag a violation
        }
        return out;
    }

    public static void main(String[] args) {
        TreeNode a = build(1, 2, 5, 3, 4, null, 6);
        flatten(a);
        System.out.println(chain(a));                           // [1, 2, 3, 4, 5, 6]
        TreeNode b = build(1, 2, 5, 3, 4, null, 6);
        prev = null;
        flattenRecursive(b);
        System.out.println(chain(b));                           // [1, 2, 3, 4, 5, 6]
        TreeNode c = build(1, null, 2);
        flatten(c);
        System.out.println(chain(c));                           // [1, 2]
        TreeNode d = build(0);
        flatten(d);
        System.out.println(chain(d));                           // [0]
        flatten(null);
        System.out.println(chain(null));                        // []
    }
}
