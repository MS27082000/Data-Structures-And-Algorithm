import java.util.ArrayDeque;
import java.util.Queue;

/** Largest BST in a Binary Tree (LC 333): the size (number of nodes) of the largest subtree that is itself a valid BST */
public class LargestBSTSubtree {

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

    private static int best;

    // Postorder: each subtree reports {isBST (1/0), size, min, max}. A node forms a BST if both children are BSTs and
    // left.max < node.val < right.min. Then size = left + right + 1. An empty subtree is a BST with min = +inf, max = -inf.
    // Checking the children first avoids re-validating subtrees. O(n) time, O(h) stack
    static int largestBSTSubtree(TreeNode root) {
        best = 0;
        solve(root);
        return best;
    }

    private static long[] solve(TreeNode node) {                      // {isBST, size, min, max}
        if (node == null) return new long[]{1, 0, Long.MAX_VALUE, Long.MIN_VALUE};
        long[] left = solve(node.left), right = solve(node.right);
        if (left[0] == 1 && right[0] == 1 && left[3] < node.val && node.val < right[2]) {
            int size = (int) (left[1] + right[1] + 1);
            best = Math.max(best, size);
            return new long[]{1, size, Math.min(left[2], node.val), Math.max(right[3], node.val)};
        }
        return new long[]{0, Math.max(left[1], right[1]), 0, 0};     // not a BST: min/max no longer matter
    }

    public static void main(String[] args) {
        System.out.println(largestBSTSubtree(build(10, 5, 15, 1, 8, null, 7)));      // 3  (the subtree rooted at 5)
        System.out.println(largestBSTSubtree(build(50, 30, 60, 5, 20, 45, 70, null, null, null, null, null, null, 65, 80))); // 5  (subtree rooted at 60: 60, 45, 70, 65, 80)
        System.out.println(largestBSTSubtree(build(2, 1, 3)));                        // 3  (the whole tree)
        System.out.println(largestBSTSubtree(build(5, 4, 6, null, null, 3, 7)));      // 3  (the whole tree fails because 3 < 5 sits in the right subtree; the subtree rooted at 6 is a valid BST of size 3)
        System.out.println(largestBSTSubtree(build(1)));                              // 1
        System.out.println(largestBSTSubtree(build()));                               // 0
    }
}
