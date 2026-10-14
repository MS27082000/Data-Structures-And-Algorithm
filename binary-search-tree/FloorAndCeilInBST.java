/** Floor and Ceil in a BST: floor = largest key <= x, ceil = smallest key >= x (-1 if none) */
public class FloorAndCeilInBST {

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

    // Walk down once. If node.val <= x it is a floor candidate (try for a larger one on the right); otherwise go left.
    // O(h) time, O(1) space
    static int floor(TreeNode root, int x) {
        int ans = -1;
        while (root != null) {
            if (root.val == x) return x;
            if (root.val < x) {
                ans = root.val;                // candidate: keep looking for a bigger one
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }

    // Mirror image: node.val >= x is a ceil candidate (try for a smaller one on the left)
    static int ceil(TreeNode root, int x) {
        int ans = -1;
        while (root != null) {
            if (root.val == x) return x;
            if (root.val > x) {
                ans = root.val;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = bst(8, 4, 12, 2, 6, 10, 14);
        System.out.println(floor(t, 5) + " " + ceil(t, 5));       // 4 6
        System.out.println(floor(t, 8) + " " + ceil(t, 8));       // 8 8   (exact match)
        System.out.println(floor(t, 1) + " " + ceil(t, 1));       // -1 2  (nothing <= 1)
        System.out.println(floor(t, 15) + " " + ceil(t, 15));     // 14 -1 (nothing >= 15)
        System.out.println(floor(t, 11) + " " + ceil(t, 11));     // 10 12
        System.out.println(floor(null, 3) + " " + ceil(null, 3)); // -1 -1
    }
}
