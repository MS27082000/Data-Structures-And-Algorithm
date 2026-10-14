import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Level Order Traversal (LC 102): nodes level by level, left to right */
public class LevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // Build a tree from a level-order array where null means "no node" (LeetCode format)
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

    // BFS with a queue. Process exactly `size` nodes per iteration = one level. O(n) time, O(w) space (w = max width)
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();                       // snapshot: the nodes currently in the queue are this level
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(levelOrder(build(3, 9, 20, null, null, 15, 7)));   // [[3], [9, 20], [15, 7]]
        System.out.println(levelOrder(build(1, 2, 3, 4, 5, 6, 7)));           // [[1], [2, 3], [4, 5, 6, 7]]
        System.out.println(levelOrder(build(1)));                             // [[1]]
        System.out.println(levelOrder(build()));                              // []
        System.out.println(levelOrder(build(1, 2, null, 3)));                 // [[1], [2], [3]] (skewed)
    }
}
