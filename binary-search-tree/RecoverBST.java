import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Recover Binary Search Tree (LC 99): exactly TWO nodes of a BST were swapped by mistake. Fix it without changing the structure */
public class RecoverBST {

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

    private static TreeNode first, second, prev;

    // In a valid BST the inorder sequence is increasing. Swapping two nodes creates one or two "descents" (prev > cur):
    //   adjacent swap     -> ONE descent:  first = prev, second = cur
    //   non-adjacent swap -> TWO descents: first = prev of the 1st descent, second = cur of the 2nd descent
    // Swap the VALUES of first and second. O(n) time, O(h) stack
    static void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private static void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null && prev.val > node.val) {
            if (first == null) first = prev;       // first descent: the bigger value is out of place
            second = node;                          // keep overwriting: the last descent's smaller value is the other one
        }
        prev = node;
        inorder(node.right);
    }

    static List<Integer> inorderList(TreeNode n) {
        List<Integer> out = new ArrayList<>();
        walk(n, out);
        return out;
    }

    private static void walk(TreeNode n, List<Integer> out) {
        if (n == null) return;
        walk(n.left, out);
        out.add(n.val);
        walk(n.right, out);
    }

    public static void main(String[] args) {
        TreeNode a = build(1, 3, null, null, 2);               // 1 and 3 swapped (non-adjacent in inorder)
        System.out.println(inorderList(a));                    // [3, 2, 1] before (two descents)
        recoverTree(a);
        System.out.println(inorderList(a));                    // [1, 2, 3] after

        TreeNode b = build(3, 1, 4, null, null, 2);            // 2 and 3 swapped (ADJACENT in inorder)
        System.out.println(inorderList(b));                    // [1, 3, 2, 4]  (one descent)
        recoverTree(b);
        System.out.println(inorderList(b));                    // [1, 2, 3, 4]

        // Non-adjacent swap: the valid BST was 5(3(2,4), 8(6,9)); 3 and 8 were swapped => 5(8(2,4), 3(6,9))
        TreeNode c = build(5, 8, 3, 2, 4, 6, 9);
        System.out.println(inorderList(c));                    // [2, 8, 4, 5, 6, 3, 9]  (two descents: 8>4 and 6>3)
        recoverTree(c);
        System.out.println(inorderList(c));                    // [2, 3, 4, 5, 6, 8, 9]
    }
}
