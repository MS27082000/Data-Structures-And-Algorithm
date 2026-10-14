import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Right Side View (LC 199) and Left Side View of a Binary Tree: the visible node at each level */
public class LeftRightView {

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

    // BFS: the LAST node of each level is the right view; the FIRST node is the left view. O(n) time, O(w) space
    static List<Integer> rightView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) view.add(node.val);               // last node of the level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return view;
    }

    static List<Integer> leftView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) view.add(node.val);                      // first node of the level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return view;
    }

    // DFS alternative: visit right child first (for the right view); the first node seen at each new depth is visible. O(n), O(h)
    static void rightViewDfs(TreeNode node, int depth, List<Integer> view) {
        if (node == null) return;
        if (depth == view.size()) view.add(node.val);
        rightViewDfs(node.right, depth + 1, view);
        rightViewDfs(node.left, depth + 1, view);
    }

    public static void main(String[] args) {
        TreeNode t = build(1, 2, 3, null, 5, null, 4);
        System.out.println(rightView(t));                         // [1, 3, 4]
        System.out.println(leftView(t));                          // [1, 2, 5]
        List<Integer> viaDfs = new ArrayList<>();
        rightViewDfs(t, 0, viaDfs);
        System.out.println(viaDfs);                               // [1, 3, 4]
        System.out.println(rightView(build(1, null, 3)));         // [1, 3]
        System.out.println(leftView(build(1, 2, 3, 4)));          // [1, 2, 4]  (a deeper left node shows through)
        System.out.println(rightView(build()));                   // []
    }
}
