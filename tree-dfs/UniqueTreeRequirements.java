import java.util.ArrayList;
import java.util.List;

/** Requirements needed to construct a UNIQUE binary tree (theory + a runnable demonstration).
 *   Inorder + Preorder  => unique.     Inorder + Postorder => unique.     Preorder + Postorder => NOT unique.
 *   Preorder alone / Postorder alone / Inorder alone => NOT unique. */
public class UniqueTreeRequirements {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static void pre(TreeNode n, List<Integer> out) {
        if (n == null) return;
        out.add(n.val);
        pre(n.left, out);
        pre(n.right, out);
    }

    static void in(TreeNode n, List<Integer> out) {
        if (n == null) return;
        in(n.left, out);
        out.add(n.val);
        in(n.right, out);
    }

    static void post(TreeNode n, List<Integer> out) {
        if (n == null) return;
        post(n.left, out);
        post(n.right, out);
        out.add(n.val);
    }

    static String describe(TreeNode t) {
        List<Integer> a = new ArrayList<>(), b = new ArrayList<>(), c = new ArrayList<>();
        pre(t, a);
        in(t, b);
        post(t, c);
        return "pre=" + a + " in=" + b + " post=" + c;
    }

    public static void main(String[] args) {
        // Two DIFFERENT trees: 2 is the LEFT child of 1, versus 2 is the RIGHT child of 1
        TreeNode leftChild = new TreeNode(1);
        leftChild.left = new TreeNode(2);
        TreeNode rightChild = new TreeNode(1);
        rightChild.right = new TreeNode(2);
        System.out.println(describe(leftChild));    // pre=[1, 2] in=[2, 1] post=[2, 1]
        System.out.println(describe(rightChild));   // pre=[1, 2] in=[1, 2] post=[2, 1]
        // Same preorder AND same postorder for two different trees => preorder+postorder cannot identify a tree.
        // But the INORDER differs, so inorder + (preorder or postorder) does identify it.

        // Another pair: a single node with one child vs the same values: [1,2,3] as a left chain vs a right chain
        TreeNode chainL = new TreeNode(1);
        chainL.left = new TreeNode(2);
        chainL.left.left = new TreeNode(3);
        TreeNode chainR = new TreeNode(1);
        chainR.right = new TreeNode(2);
        chainR.right.right = new TreeNode(3);
        System.out.println(describe(chainL));       // pre=[1, 2, 3] in=[3, 2, 1] post=[3, 2, 1]
        System.out.println(describe(chainR));       // pre=[1, 2, 3] in=[1, 2, 3] post=[3, 2, 1]
    }
}
