import java.util.ArrayList;
import java.util.List;

/** Insert into a Binary Search Tree (LC 701): the new key always becomes a LEAF */
public class InsertIntoBST {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // Recursive: descend to the first null link and put the new node there. O(h) time, O(h) stack
    static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        else root.right = insertIntoBST(root.right, val);      // equal keys go right here (LeetCode guarantees distinct)
        return root;
    }

    // Iterative: remember the parent while walking down. O(h) time, O(1) space
    static TreeNode insertIterative(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) return node;
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) { cur.left = node; break; }
                cur = cur.left;
            } else {
                if (cur.right == null) { cur.right = node; break; }
                cur = cur.right;
            }
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
        TreeNode t = null;
        for (int v : new int[]{4, 2, 7, 1, 3}) t = insertIntoBST(t, v);
        System.out.println(inorder(t));                           // [1, 2, 3, 4, 7]
        t = insertIntoBST(t, 5);
        System.out.println(inorder(t));                           // [1, 2, 3, 4, 5, 7]  (5 became the left child of 7)
        System.out.println(t.right.left.val);                     // 5
        TreeNode u = null;
        for (int v : new int[]{40, 20, 60, 10, 30, 50, 70}) u = insertIterative(u, v);
        u = insertIterative(u, 25);
        System.out.println(inorder(u));                           // [10, 20, 25, 30, 40, 50, 60, 70]
        System.out.println(inorder(insertIntoBST(null, 9)));      // [9]
    }
}
