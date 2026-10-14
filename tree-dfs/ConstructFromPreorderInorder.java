import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Construct Binary Tree from Preorder and Inorder Traversal (LC 105): values are UNIQUE */
public class ConstructFromPreorderInorder {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // Preorder's first element is the ROOT. Find it in inorder: everything to its left is the left subtree, to its right the
    // right subtree. A HashMap of value -> inorder index makes each lookup O(1). O(n) time, O(n) space
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexOf = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) indexOf.put(inorder[i], i);
        return build(preorder, 0, preorder.length - 1, 0, inorder.length - 1, indexOf);
    }

    private static TreeNode build(int[] pre, int preLo, int preHi, int inLo, int inHi, Map<Integer, Integer> indexOf) {
        if (preLo > preHi || inLo > inHi) return null;
        TreeNode root = new TreeNode(pre[preLo]);
        int rootIn = indexOf.get(root.val);
        int leftSize = rootIn - inLo;                                   // number of nodes in the left subtree
        root.left = build(pre, preLo + 1, preLo + leftSize, inLo, rootIn - 1, indexOf);
        root.right = build(pre, preLo + leftSize + 1, preHi, rootIn + 1, inHi, indexOf);
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

    static void check(int[] pre, int[] in) {
        TreeNode t = buildTree(pre, in);
        List<Integer> p = new ArrayList<>(), i = new ArrayList<>();
        preorder(t, p);
        inorder(t, i);
        System.out.println(p + " " + i);                                // must reproduce the inputs
    }

    public static void main(String[] args) {
        check(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});  // [3, 9, 20, 15, 7] [9, 3, 15, 20, 7]
        check(new int[]{-1}, new int[]{-1});                            // [-1] [-1]
        check(new int[]{1, 2, 3}, new int[]{3, 2, 1});                  // left chain
        check(new int[]{1, 2, 3}, new int[]{1, 2, 3});                  // right chain
        check(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 2, 5, 1, 6, 3, 7});   // complete tree
    }
}
