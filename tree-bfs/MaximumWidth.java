import java.util.ArrayDeque;
import java.util.Queue;

/** Maximum Width of a Binary Tree (LC 662): width of a level = distance between its leftmost and rightmost NON-null nodes,
 *  counting the null positions in between as if the tree were complete */
public class MaximumWidth {

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

    // Give every node a heap-style index (left = 2i, right = 2i + 1). Width of a level = lastIndex - firstIndex + 1.
    // Subtract the level's first index before computing children so indices don't overflow. O(n) time, O(w) space
    static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Object[]> queue = new ArrayDeque<>();            // {node, index}
        queue.offer(new Object[]{root, 0L});
        long best = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            long first = (long) queue.peek()[1];                // index of the leftmost node on this level
            long last = first;
            for (int i = 0; i < size; i++) {
                Object[] cur = queue.poll();
                TreeNode node = (TreeNode) cur[0];
                long index = (long) cur[1] - first;             // normalise to start from 0 on every level
                last = index;
                if (node.left != null) queue.offer(new Object[]{node.left, 2 * index});
                if (node.right != null) queue.offer(new Object[]{node.right, 2 * index + 1});
            }
            best = Math.max(best, last + 1);
        }
        return (int) best;
    }

    public static void main(String[] args) {
        System.out.println(widthOfBinaryTree(build(1, 3, 2, 5, 3, null, 9)));              // 4
        System.out.println(widthOfBinaryTree(build(1, 3, 2, 5, null, null, 9, 6, null, 7))); // 7
        System.out.println(widthOfBinaryTree(build(1, 3, 2, 5)));                          // 2
        System.out.println(widthOfBinaryTree(build(1)));                                   // 1
        System.out.println(widthOfBinaryTree(build()));                                    // 0
    }
}
