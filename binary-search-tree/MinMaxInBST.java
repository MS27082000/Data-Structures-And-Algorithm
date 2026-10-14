/** Minimum and Maximum in a BST: the leftmost and the rightmost nodes */
public class MinMaxInBST {

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

    // Keep going LEFT for the minimum, RIGHT for the maximum. O(h) time, O(1) space (no need to visit the whole tree)
    static TreeNode minNode(TreeNode root) {
        if (root == null) return null;
        while (root.left != null) root = root.left;
        return root;
    }

    static TreeNode maxNode(TreeNode root) {
        if (root == null) return null;
        while (root.right != null) root = root.right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode t = bst(8, 4, 12, 2, 6, 10, 14);
        System.out.println(minNode(t).val + " " + maxNode(t).val);        // 2 14
        TreeNode one = bst(5);
        System.out.println(minNode(one).val + " " + maxNode(one).val);    // 5 5
        TreeNode left = bst(5, 3, 1);                                      // left-skewed
        System.out.println(minNode(left).val + " " + maxNode(left).val);  // 1 5
        TreeNode right = bst(1, 2, 3);                                     // right-skewed
        System.out.println(minNode(right).val + " " + maxNode(right).val);// 1 3
        System.out.println(minNode(null) + " " + maxNode(null));          // null null
    }
}
