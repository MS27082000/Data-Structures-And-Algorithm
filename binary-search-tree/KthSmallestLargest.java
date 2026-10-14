import java.util.ArrayDeque;
import java.util.Deque;

/** Kth Smallest (LC 230) and Kth Largest Element in a BST. Inorder visits keys in ascending order */
public class KthSmallestLargest {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static TreeNode bst(int... values) {
        TreeNode root = null;
        for (int v : values) root = insert(root, v);
        return root;
    }

    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }

    // Iterative inorder; stop after the k-th visit. O(h + k) time, O(h) space (no need to traverse everything)
    static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (--k == 0) return cur.val;
            cur = cur.right;
        }
        return -1;                                      // k is larger than the number of nodes
    }

    // REVERSE inorder (right, node, left) visits keys in DESCENDING order, so the k-th visit is the k-th largest
    static int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            if (--k == 0) return cur.val;
            cur = cur.left;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode t = bst(3, 1, 4, 2);
        System.out.println(kthSmallest(t, 1) + " " + kthLargest(t, 1));      // 1 4
        TreeNode u = bst(5, 3, 6, 2, 4, 1);
        System.out.println(kthSmallest(u, 3) + " " + kthLargest(u, 3));      // 3 4
        System.out.println(kthSmallest(u, 6) + " " + kthLargest(u, 6));      // 6 1
        System.out.println(kthSmallest(u, 7) + " " + kthLargest(u, 7));      // -1 -1  (k out of range)
        System.out.println(kthSmallest(bst(7), 1));                           // 7
    }
}
