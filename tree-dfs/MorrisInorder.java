import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Morris Inorder Traversal: inorder in O(n) time and O(1) EXTRA space, using temporary "threads" instead of a stack */
public class MorrisInorder {

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

    // For a node with a left subtree, find its INORDER PREDECESSOR (rightmost node of the left subtree):
    //   first time  : predecessor.right == null  -> create a thread predecessor.right = cur, then go LEFT
    //   second time : predecessor.right == cur   -> remove the thread, VISIT cur, then go RIGHT
    // A node with no left child is visited immediately. The tree is restored to its original shape. O(n) time, O(1) space
    static List<Integer> morrisInorder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                out.add(cur.val);
                cur = cur.right;                          // may follow a thread back up to an ancestor
            } else {
                TreeNode pred = cur.left;
                while (pred.right != null && pred.right != cur) pred = pred.right;
                if (pred.right == null) {
                    pred.right = cur;                     // create the thread
                    cur = cur.left;
                } else {
                    pred.right = null;                    // remove the thread: the left subtree is fully done
                    out.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(morrisInorder(build(1, 2, 3, 4, 5, 6, 7)));      // [4, 2, 5, 1, 6, 3, 7]
        System.out.println(morrisInorder(build(1, null, 2, 3)));            // [1, 3, 2]
        System.out.println(morrisInorder(build(2, 1, 3)));                  // [1, 2, 3]
        System.out.println(morrisInorder(build(1, 2, null, 3)));            // [3, 2, 1]
        System.out.println(morrisInorder(build()));                         // []
        TreeNode t = build(1, 2, 3, 4, 5);
        morrisInorder(t);
        System.out.println(morrisInorder(t));                               // [4, 2, 5, 1, 3]  (run twice: the tree was restored)
    }
}
