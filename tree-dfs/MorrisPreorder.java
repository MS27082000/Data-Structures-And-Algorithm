import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Morris Preorder Traversal: preorder in O(n) time and O(1) extra space (same threading as Morris inorder, but VISIT on the first arrival) */
public class MorrisPreorder {

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

    // Identical to Morris inorder except WHERE the node is added:
    //   thread created (first arrival)  -> add cur.val NOW (root before its left subtree), then go left
    //   thread found  (second arrival)  -> just remove the thread and go right (cur was already recorded)
    //   no left child                   -> add cur.val, go right
    // O(n) time, O(1) space
    static List<Integer> morrisPreorder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                out.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pred = cur.left;
                while (pred.right != null && pred.right != cur) pred = pred.right;
                if (pred.right == null) {
                    out.add(cur.val);                     // preorder: record the root on the FIRST visit
                    pred.right = cur;
                    cur = cur.left;
                } else {
                    pred.right = null;
                    cur = cur.right;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(morrisPreorder(build(1, 2, 3, 4, 5, 6, 7)));     // [1, 2, 4, 5, 3, 6, 7]
        System.out.println(morrisPreorder(build(1, null, 2, 3)));           // [1, 2, 3]
        System.out.println(morrisPreorder(build(2, 1, 3)));                 // [2, 1, 3]
        System.out.println(morrisPreorder(build(1, 2, null, 3)));           // [1, 2, 3]
        System.out.println(morrisPreorder(build()));                        // []
        TreeNode t = build(1, 2, 3, 4, 5);
        morrisPreorder(t);
        System.out.println(morrisPreorder(t));                              // [1, 2, 4, 5, 3]  (the tree was restored)
    }
}
