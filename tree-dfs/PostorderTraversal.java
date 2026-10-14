import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/** Postorder Traversal (LC 145): Left, Right, Root. Children are processed before their parent (used for deleting a tree, evaluating expressions) */
public class PostorderTraversal {

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
    static void postorderRec(TreeNode node, List<Integer> out) {
        if (node == null) return;
        postorderRec(node.left, out);
        postorderRec(node.right, out);
        out.add(node.val);
    }

    // Iterative, TWO stacks (easy): produce Root, Right, Left, then reverse it. O(n) time, O(n) space
    static List<Integer> postorderTwoStacks(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode n = s.pop();
            out.add(n.val);                                     // Root, Right, Left order
            if (n.left != null) s.push(n.left);
            if (n.right != null) s.push(n.right);
        }
        Collections.reverse(out);                               // reversed = Left, Right, Root
        return out;
    }

    // Iterative, ONE stack: remember the last visited node to know whether the right subtree is done. O(n) time, O(h) space
    static List<Integer> postorderOneStack(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root, lastVisited = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode top = stack.peek();
            if (top.right != null && top.right != lastVisited) {
                cur = top.right;                                // right subtree not processed yet
            } else {
                out.add(top.val);                               // both subtrees done: visit the node
                lastVisited = stack.pop();
            }
        }
        return out;
    }

    public static void main(String[] args) {
        TreeNode t = build(1, 2, 3, 4, 5, 6, 7);
        List<Integer> rec = new ArrayList<>();
        postorderRec(t, rec);
        System.out.println(rec);                                         // [4, 5, 2, 6, 7, 3, 1]
        System.out.println(postorderTwoStacks(t));                       // [4, 5, 2, 6, 7, 3, 1]
        System.out.println(postorderOneStack(t));                        // [4, 5, 2, 6, 7, 3, 1]
        System.out.println(postorderOneStack(build(1, null, 2, 3)));     // [3, 2, 1]
        System.out.println(postorderOneStack(build()));                  // []
        System.out.println(postorderOneStack(build(1, 2, null, 3)));     // [3, 2, 1]
    }
}
