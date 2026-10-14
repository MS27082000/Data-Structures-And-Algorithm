import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/** Preorder, Inorder and Postorder in ONE traversal: a stack of (node, state) pairs */
public class PrePostInOneTraversal {

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

    // Each node is visited up to THREE times, once per state:
    //   state 1 (first arrival)       -> PREORDER  add; go to the left child
    //   state 2 (back from the left)  -> INORDER   add; go to the right child
    //   state 3 (back from the right) -> POSTORDER add; pop the node
    // O(n) time (3 visits per node), O(n) space
    static List<List<Integer>> allTraversals(TreeNode root) {
        List<Integer> pre = new ArrayList<>(), in = new ArrayList<>(), post = new ArrayList<>();
        if (root != null) {
            Deque<Object[]> stack = new ArrayDeque<>();                  // {node, state}
            stack.push(new Object[]{root, 1});
            while (!stack.isEmpty()) {
                Object[] top = stack.pop();
                TreeNode node = (TreeNode) top[0];
                int state = (int) top[1];
                if (state == 1) {
                    pre.add(node.val);
                    stack.push(new Object[]{node, 2});                   // come back for state 2
                    if (node.left != null) stack.push(new Object[]{node.left, 1});
                } else if (state == 2) {
                    in.add(node.val);
                    stack.push(new Object[]{node, 3});                   // come back for state 3
                    if (node.right != null) stack.push(new Object[]{node.right, 1});
                } else {
                    post.add(node.val);                                  // done with this node
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(allTraversals(build(1, 2, 3, 4, 5, 6, 7)));
        // [[1, 2, 4, 5, 3, 6, 7], [4, 2, 5, 1, 6, 3, 7], [4, 5, 2, 6, 7, 3, 1]]
        System.out.println(allTraversals(build(1, 2, 3)));            // [[1, 2, 3], [2, 1, 3], [2, 3, 1]]
        System.out.println(allTraversals(build(1, null, 2, 3)));      // [[1, 2, 3], [1, 3, 2], [3, 2, 1]]
        System.out.println(allTraversals(build(5)));                  // [[5], [5], [5]]
        System.out.println(allTraversals(build()));                   // [[], [], []]
    }
}
