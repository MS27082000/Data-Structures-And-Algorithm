/** Lowest Common Ancestor of a Binary Search Tree (LC 235) */
public class LCAInBST {

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

    // The LCA is the first node where p and q SPLIT (one goes left, the other right) or where the node equals one of them.
    // Both smaller -> go left; both larger -> go right. O(h) time, O(1) space (vs O(n) for a general binary tree)
    static TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        TreeNode cur = root;
        while (cur != null) {
            if (p < cur.val && q < cur.val) cur = cur.left;
            else if (p > cur.val && q > cur.val) cur = cur.right;
            else return cur;                                    // split point (or one of them): this is the LCA
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode t = bst(6, 2, 8, 0, 4, 7, 9, 3, 5);
        System.out.println(lowestCommonAncestor(t, 2, 8).val);   // 6
        System.out.println(lowestCommonAncestor(t, 2, 4).val);   // 2  (a node is its own ancestor)
        System.out.println(lowestCommonAncestor(t, 3, 5).val);   // 4
        System.out.println(lowestCommonAncestor(t, 7, 9).val);   // 8
        System.out.println(lowestCommonAncestor(t, 0, 9).val);   // 6
        System.out.println(lowestCommonAncestor(bst(2, 1), 2, 1).val);   // 2
    }
}
