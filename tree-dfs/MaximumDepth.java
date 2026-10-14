import java.util.ArrayDeque;
import java.util.Queue;

/** Maximum Depth of a Binary Tree (LC 104): number of nodes on the longest root-to-leaf path */
public class MaximumDepth {

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

    // DFS: depth(node) = 1 + max(depth(left), depth(right)). O(n) time, O(h) stack
    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // BFS: count the levels. O(n) time, O(w) space, no recursion (safe for very deep skewed trees)
    static int maxDepthBfs(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode n = queue.poll();
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth(build(3, 9, 20, null, null, 15, 7)));     // 3
        System.out.println(maxDepth(build(1, null, 2)));                      // 2
        System.out.println(maxDepth(build()));                                // 0
        System.out.println(maxDepth(build(1)));                               // 1
        System.out.println(maxDepthBfs(build(3, 9, 20, null, null, 15, 7)));  // 3
        System.out.println(maxDepthBfs(build(1, 2, null, 3, null, 4)));       // 4
    }
}
