import java.util.ArrayList;
import java.util.List;

/** Delete a Node in a BST (LC 450): three cases - leaf, one child, two children */
public class DeleteNodeInBST {

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

    // Find the node, then:
    //   0 children : return null
    //   1 child    : return that child (it takes the node's place)
    //   2 children : copy the INORDER SUCCESSOR (smallest value in the right subtree) into the node, then delete that successor
    // O(h) time, O(h) stack
    static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;           // covers leaf and "only right child"
            if (root.right == null) return root.left;           // "only left child"
            TreeNode succ = root.right;
            while (succ.left != null) succ = succ.left;         // smallest node of the right subtree
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);      // remove the successor from the right subtree
        }
        return root;
    }

    static List<Integer> inorder(TreeNode n) {
        List<Integer> out = new ArrayList<>();
        walk(n, out);
        return out;
    }

    private static void walk(TreeNode n, List<Integer> out) {
        if (n == null) return;
        walk(n.left, out);
        out.add(n.val);
        walk(n.right, out);
    }

    public static void main(String[] args) {
        TreeNode t = bst(5, 3, 6, 2, 4, 7);
        System.out.println(inorder(deleteNode(t, 3)));                        // [2, 4, 5, 6, 7]  (two children)
        System.out.println(inorder(deleteNode(bst(5, 3, 6, 2, 4, 7), 2)));    // [3, 4, 5, 6, 7]  (leaf)
        System.out.println(inorder(deleteNode(bst(5, 3, 6, 2, 4, 7), 5)));    // [2, 3, 4, 6, 7]  (root, two children)
        System.out.println(inorder(deleteNode(bst(5, 3, 6, 2), 3)));          // [2, 5, 6]        (one child)
        System.out.println(inorder(deleteNode(bst(5, 3, 6), 99)));            // [3, 5, 6]        (key absent: unchanged)
        System.out.println(inorder(deleteNode(bst(5), 5)));                   // []               (only node)
        TreeNode r = deleteNode(bst(5, 3, 6, 2, 4, 7), 5);
        System.out.println(r.val);                                            // 6  (successor replaced the root)
    }
}
