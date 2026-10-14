import java.util.ArrayList;
import java.util.List;

/** Introduction to Binary Search Trees: the BST property, building one by insertion, inorder = sorted, and why height matters */
public class BSTBasics {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // BST property: for EVERY node, all values in the left subtree < node.val < all values in the right subtree (distinct keys)
    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);   // duplicates are ignored here
        return root;
    }

    static TreeNode bst(int... values) {
        TreeNode root = null;
        for (int v : values) root = insert(root, v);
        return root;
    }

    static void inorder(TreeNode n, List<Integer> out) {
        if (n == null) return;
        inorder(n.left, out);
        out.add(n.val);
        inorder(n.right, out);
    }

    static int height(TreeNode n) {
        return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right));
    }

    public static void main(String[] args) {
        TreeNode t = bst(8, 4, 12, 2, 6, 10, 14);
        List<Integer> in = new ArrayList<>();
        inorder(t, in);
        System.out.println(in);                       // [2, 4, 6, 8, 10, 12, 14]  (inorder of a BST is SORTED)
        System.out.println(height(t));                // 3   (balanced: height ~ log2 n, so search/insert/delete are O(log n))

        TreeNode skewed = bst(1, 2, 3, 4, 5, 6, 7);   // inserting sorted data gives a chain
        System.out.println(height(skewed));           // 7   (skewed: height = n, so operations degrade to O(n))

        TreeNode dup = bst(5, 3, 5, 3, 7);
        List<Integer> d = new ArrayList<>();
        inorder(dup, d);
        System.out.println(d);                        // [3, 5, 7]  (duplicates ignored)
        System.out.println(height(null));             // 0
    }
}
