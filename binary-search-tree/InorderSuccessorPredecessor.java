/** Inorder Successor (LC 285) and Predecessor in a BST: the next larger / next smaller key (-1 if none) */
public class InorderSuccessorPredecessor {

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

    // Walk down from the root toward `key`. Every time we go LEFT, the current node is a successor candidate (it is larger);
    // the last such candidate is the answer unless `key` has a right subtree (then it is the leftmost node there).
    // O(h) time, O(1) space; works even if `key` is not in the tree (gives the next larger key)
    static int successor(TreeNode root, int key) {
        int ans = -1;
        while (root != null) {
            if (key < root.val) {
                ans = root.val;                  // candidate: bigger than key
                root = root.left;
            } else {
                root = root.right;               // key >= node: the answer is strictly larger, so look right
            }
        }
        return ans;
    }

    // Mirror: going RIGHT makes the current node a predecessor candidate (it is smaller)
    static int predecessor(TreeNode root, int key) {
        int ans = -1;
        while (root != null) {
            if (key > root.val) {
                ans = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = bst(20, 8, 22, 4, 12, 10, 14);
        System.out.println(successor(t, 8) + " " + predecessor(t, 8));       // 10 4
        System.out.println(successor(t, 14) + " " + predecessor(t, 14));     // 20 12   (ancestor is the successor)
        System.out.println(successor(t, 4) + " " + predecessor(t, 4));       // 8 -1
        System.out.println(successor(t, 22) + " " + predecessor(t, 22));     // -1 20   (maximum has no successor)
        System.out.println(successor(t, 11) + " " + predecessor(t, 11));     // 12 10   (key not in the tree)
        System.out.println(successor(null, 3) + " " + predecessor(null, 3)); // -1 -1
    }
}
