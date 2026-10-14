import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Construct Binary Tree from Inorder and Postorder Traversal (LC 106): values are UNIQUE */
public class ConstructFromPostorderInorder {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    // Postorder's LAST element is the ROOT. Split inorder around it. Build the RIGHT subtree first when consuming postorder
    // from the back, or compute sizes (as here). O(n) time, O(n) space
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indexOf = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) indexOf.put(inorder[i], i);
        return build(postorder, 0, postorder.length - 1, 0, inorder.length - 1, indexOf);
    }

    private static TreeNode build(int[] post, int postLo, int postHi, int inLo, int inHi, Map<Integer, Integer> indexOf) {
        if (postLo > postHi || inLo > inHi) return null;
        TreeNode root = new TreeNode(post[postHi]);                     // last element of this postorder range
        int rootIn = indexOf.get(root.val);
        int leftSize = rootIn - inLo;
        root.left = build(post, postLo, postLo + leftSize - 1, inLo, rootIn - 1, indexOf);
        root.right = build(post, postLo + leftSize, postHi - 1, rootIn + 1, inHi, indexOf);
        return root;
    }

    static void inorder(TreeNode n, List<Integer> out) {
        if (n == null) return;
        inorder(n.left, out);
        out.add(n.val);
        inorder(n.right, out);
    }

    static void postorder(TreeNode n, List<Integer> out) {
        if (n == null) return;
        postorder(n.left, out);
        postorder(n.right, out);
        out.add(n.val);
    }

    static void check(int[] in, int[] post) {
        TreeNode t = buildTree(in, post);
        List<Integer> i = new ArrayList<>(), p = new ArrayList<>();
        inorder(t, i);
        postorder(t, p);
        System.out.println(i + " " + p);                                // must reproduce the inputs
    }

    public static void main(String[] args) {
        check(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});  // [9, 3, 15, 20, 7] [9, 15, 7, 20, 3]
        check(new int[]{-1}, new int[]{-1});                            // [-1] [-1]
        check(new int[]{3, 2, 1}, new int[]{3, 2, 1});                  // left chain
        check(new int[]{1, 2, 3}, new int[]{3, 2, 1});                  // right chain
        check(new int[]{4, 2, 5, 1, 6, 3, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});   // complete tree
    }
}
