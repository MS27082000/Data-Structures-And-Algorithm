import java.util.ArrayDeque;
import java.util.Queue;

/** Diameter of a Binary Tree (LC 543): the length (in EDGES) of the longest path between any two nodes. It may not pass through the root */
public class DiameterOfBinaryTree {

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

    // The longest path through a node = height(left) + height(right) (in edges, heights counted in nodes). Compute the height
    // bottom-up and update the best diameter at every node. O(n) time, O(h) stack
    static int diameterOfBinaryTree(TreeNode root) {
        best = 0;
        height(root);
        return best;
    }

    private static int height(TreeNode node) {              // height in NODES
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        best = Math.max(best, left + right);                // path through this node, measured in edges
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(build(1, 2, 3, 4, 5)));                    // 3   (4-2-1-3 or 5-2-1-3)
        System.out.println(diameterOfBinaryTree(build(1, 2)));                             // 1
        System.out.println(diameterOfBinaryTree(build(1)));                                // 0
        System.out.println(diameterOfBinaryTree(build()));                                 // 0
        // the longest path does not go through the root:
        System.out.println(diameterOfBinaryTree(build(1, 2, null, 3, 4, 5, null, 6, null, null, 7))); // 5
        System.out.println(diameterOfBinaryTree(build(1, 2, 3, 4, 5, 6, 7)));              // 4
    }
}
