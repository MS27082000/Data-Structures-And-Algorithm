import java.util.ArrayDeque;
import java.util.Deque;

/** Binary Search Tree Iterator (LC 173): next() returns the next smallest key; next() and hasNext() in amortised O(1), O(h) memory */
public class BSTIterator {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static TreeNode bst(int... values) {
        TreeNode root = null;
        for (int v : values) root = insert(root, v);
        return root;
    }

    static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else if (val > root.val) root.right = insert(root.right, val);
        return root;
    }

    // A lazy inorder: the stack holds only the path of "left spine" nodes still waiting to be visited (at most h of them),
    // instead of storing all n values.
    private final Deque<TreeNode> stack = new ArrayDeque<>();

    BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    int next() {
        TreeNode node = stack.pop();           // the smallest unvisited key
        pushLeft(node.right);                  // its successor lies in the left spine of its right subtree
        return node.val;
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        BSTIterator it = new BSTIterator(bst(7, 3, 15, 9, 20));
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) sb.append(it.next()).append(' ');
        System.out.println(sb.toString().trim());                   // 3 7 9 15 20

        BSTIterator two = new BSTIterator(bst(7, 3, 15, 9, 20));
        System.out.println(two.next() + " " + two.next() + " " + two.hasNext());   // 3 7 true
        System.out.println(two.next() + " " + two.next() + " " + two.next() + " " + two.hasNext());   // 9 15 20 false
        System.out.println(new BSTIterator(null).hasNext());       // false
    }
}
