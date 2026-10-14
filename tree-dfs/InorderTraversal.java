import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/** Inorder Traversal (LC 94): Left, Root, Right. For a BST this visits values in sorted order */
public class InorderTraversal {

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

    // Recursive: O(n) time, O(h) stack (h = height; O(n) for a skewed tree)
    static void inorderRec(TreeNode node, List<Integer> out) {
        if (node == null) return;
        inorderRec(node.left, out);
        out.add(node.val);
        inorderRec(node.right, out);
    }

    // Iterative with an explicit stack: go as far LEFT as possible, visit, then move to the right subtree. O(n), O(h)
    static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {                 // dive left, remembering the path
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();                    // leftmost unvisited node
            out.add(cur.val);
            cur = cur.right;                      // then its right subtree
        }
        return out;
    }

    public static void main(String[] args) {
        TreeNode t = build(1, 2, 3, 4, 5, 6, 7);
        List<Integer> rec = new ArrayList<>();
        inorderRec(t, rec);
        System.out.println(rec);                                       // [4, 2, 5, 1, 6, 3, 7]
        System.out.println(inorderIterative(t));                       // [4, 2, 5, 1, 6, 3, 7]
        System.out.println(inorderIterative(build(1, null, 2, 3)));    // [1, 3, 2]
        System.out.println(inorderIterative(build(2, 1, 3)));          // [1, 2, 3]
        System.out.println(inorderIterative(build()));                 // []
        System.out.println(inorderIterative(build(1, 2, null, 3)));    // [3, 2, 1]
    }
}
