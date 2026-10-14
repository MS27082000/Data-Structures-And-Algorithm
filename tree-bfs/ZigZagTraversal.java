import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/** Binary Tree Zigzag (Spiral) Level Order Traversal (LC 103): left-to-right, then right-to-left, alternating */
public class ZigZagTraversal {

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

    // Normal level-order BFS; reverse every second level (or write directly to the right index). O(n) time, O(w) space
    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer[] level = new Integer[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = leftToRight ? i : size - 1 - i;     // fill the slot directly: no reversal pass needed
                level[index] = node.val;
                if (node.left != null) queue.offer(node.left);  // children are ALWAYS enqueued left then right
                if (node.right != null) queue.offer(node.right);
            }
            List<Integer> list = new ArrayList<>(size);
            Collections.addAll(list, level);
            result.add(list);
            leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(zigzagLevelOrder(build(3, 9, 20, null, null, 15, 7)));   // [[3], [20, 9], [15, 7]]
        System.out.println(zigzagLevelOrder(build(1, 2, 3, 4, 5, 6, 7)));           // [[1], [3, 2], [4, 5, 6, 7]]
        System.out.println(zigzagLevelOrder(build(1)));                             // [[1]]
        System.out.println(zigzagLevelOrder(build()));                              // []
        System.out.println(zigzagLevelOrder(build(1, 2, 3, 4, null, null, 5)));     // [[1], [3, 2], [4, 5]]
    }
}
