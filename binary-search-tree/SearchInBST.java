/** Search in a Binary Search Tree (LC 700): return the node holding `val`, or null */
public class SearchInBST {

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

    // Iterative: at each node discard half the tree. O(h) time (O(log n) balanced, O(n) skewed), O(1) space
    static TreeNode search(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null && cur.val != val) {
            cur = (val < cur.val) ? cur.left : cur.right;
        }
        return cur;
    }

    // Recursive: O(h) time, O(h) stack
    static TreeNode searchRec(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return val < root.val ? searchRec(root.left, val) : searchRec(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode t = bst(4, 2, 7, 1, 3);
        System.out.println(search(t, 2).val);                 // 2
        System.out.println(search(t, 5));                     // null
        System.out.println(searchRec(t, 7).val);              // 7
        System.out.println(search(t, 4) == t);                // true (found at the root)
        System.out.println(search(null, 1));                  // null
        System.out.println(searchRec(t, 1).val);              // 1
    }
}
