import java.util.ArrayList;
import java.util.List;

/** Construct a Binary Search Tree from a Preorder Traversal (LC 1008) */
public class ConstructBSTFromPreorder {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    private static int index;

    // Walk the preorder array once. A value belongs in the current subtree only if it is < `bound` (the nearest ancestor above
    // which it would be a right-child ancestor). Build left with bound = node.val, then right with the inherited bound.
    // O(n) time, O(h) stack
    static TreeNode bstFromPreorder(int[] preorder) {
        index = 0;
        return build(preorder, Integer.MAX_VALUE);
    }

    private static TreeNode build(int[] pre, int bound) {
        if (index == pre.length || pre[index] > bound) return null;     // next value belongs to an ancestor's right side
        TreeNode node = new TreeNode(pre[index++]);
        node.left = build(pre, node.val);                                // values < node.val
        node.right = build(pre, bound);                                  // values between node.val and the inherited bound
        return node;
    }

    // Simpler but O(n log n) / O(n^2): insert every value one by one
    static TreeNode viaInsert(int[] preorder) {
        TreeNode root = null;
        for (int v : preorder) root = insert(root, v);
        return root;
    }

    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    static void preorder(TreeNode n, List<Integer> out) {
        if (n == null) return;
        out.add(n.val);
        preorder(n.left, out);
        preorder(n.right, out);
    }

    static void inorder(TreeNode n, List<Integer> out) {
        if (n == null) return;
        inorder(n.left, out);
        out.add(n.val);
        inorder(n.right, out);
    }

    static void show(int[] pre) {
        TreeNode t = bstFromPreorder(pre);
        List<Integer> p = new ArrayList<>(), i = new ArrayList<>();
        preorder(t, p);
        inorder(t, i);
        System.out.println(p + " " + i);                 // preorder reproduces the input; inorder must be sorted
    }

    public static void main(String[] args) {
        show(new int[]{8, 5, 1, 7, 10, 12});             // [8, 5, 1, 7, 10, 12] [1, 5, 7, 8, 10, 12]
        show(new int[]{1, 3});                           // [1, 3] [1, 3]
        show(new int[]{5});                              // [5] [5]
        show(new int[]{4, 2, 1, 3, 6, 5, 7});            // [4, 2, 1, 3, 6, 5, 7] [1, 2, 3, 4, 5, 6, 7]
        show(new int[]{3, 2, 1});                        // [3, 2, 1] [1, 2, 3]
        List<Integer> check = new ArrayList<>();
        preorder(viaInsert(new int[]{8, 5, 1, 7, 10, 12}), check);
        System.out.println(check);                       // [8, 5, 1, 7, 10, 12]
    }
}
