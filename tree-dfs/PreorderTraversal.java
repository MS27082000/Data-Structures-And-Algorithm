import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/** Preorder Traversal (LC 144): Root, Left, Right. Used to copy / serialise a tree */
public class PreorderTraversal {

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

    // Recursive. O(n) time, O(h) stack
    static void preorderRec(TreeNode node, List<Integer> out) {
        if (node == null) return;
        out.add(node.val);
        preorderRec(node.left, out);
        preorderRec(node.right, out);
    }

    // Iterative: pop, visit, push RIGHT first so that LEFT is popped first. O(n) time, O(h) space
    static List<Integer> preorderIterative(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            out.add(node.val);
            if (node.right != null) stack.push(node.right);      // right first (LIFO)
            if (node.left != null) stack.push(node.left);
        }
        return out;
    }

    public static void main(String[] args) {
        TreeNode t = build(1, 2, 3, 4, 5, 6, 7);
        List<Integer> rec = new ArrayList<>();
        preorderRec(t, rec);
        System.out.println(rec);                                       // [1, 2, 4, 5, 3, 6, 7]
        System.out.println(preorderIterative(t));                      // [1, 2, 4, 5, 3, 6, 7]
        System.out.println(preorderIterative(build(1, null, 2, 3)));   // [1, 2, 3]
        System.out.println(preorderIterative(build(1)));               // [1]
        System.out.println(preorderIterative(build()));                // []
    }
}
