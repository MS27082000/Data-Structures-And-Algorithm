import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Children Sum Property: every node's value must equal the sum of its children's values (a leaf is always fine).
 *  Make a tree satisfy it by only INCREASING node values (decrementing is not allowed). */
public class ChildrenSumProperty {

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

    // Checker: does the tree satisfy the property? O(n)
    static boolean isChildrenSum(TreeNode n) {
        if (n == null || (n.left == null && n.right == null)) return true;
        int sum = (n.left != null ? n.left.val : 0) + (n.right != null ? n.right.val : 0);
        return n.val == sum && isChildrenSum(n.left) && isChildrenSum(n.right);
    }

    // Going DOWN: if the children sum is smaller than the node, raise the children to the node's value (push the value down).
    // Coming UP : set the node to the sum of its children (which can now only be >= the old value). O(n) time, O(h) stack
    static void changeTree(TreeNode node) {
        if (node == null) return;
        int childSum = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
        if (childSum < node.val) {                       // not enough below: lift the children up to the parent's value
            if (node.left != null) node.left.val = node.val;
            if (node.right != null) node.right.val = node.val;
        }
        changeTree(node.left);
        changeTree(node.right);
        int total = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
        if (node.left != null || node.right != null) node.val = total;   // leaves keep their (possibly raised) value
    }

    static List<Integer> levelOrder(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.add(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            out.add(n.val);
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        return out;
    }

    public static void main(String[] args) {
        TreeNode t = build(50, 7, 2, 3, 5, 1, 30);
        System.out.println(isChildrenSum(t));                          // false
        changeTree(t);
        System.out.println(isChildrenSum(t) + " " + levelOrder(t));    // true [200, 100, 100, 50, 50, 50, 50]  (children raised to 50, sums rise back up to the root)
        TreeNode ok = build(10, 4, 6);
        changeTree(ok);
        System.out.println(isChildrenSum(ok) + " " + levelOrder(ok));  // true [10, 4, 6]  (already valid: unchanged)
        TreeNode small = build(1, 5, 5);
        changeTree(small);
        System.out.println(isChildrenSum(small) + " " + levelOrder(small));  // true [10, 5, 5]
        System.out.println(isChildrenSum(build(1)));                   // true (a single node)
    }
}
