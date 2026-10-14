import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/** Two Sum IV - Input is a BST (LC 653): do two different nodes sum to k? */
public class TwoSumInBST {

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

    // Easy: traverse with a HashSet of seen values. O(n) time, O(n) space (ignores the BST property)
    static boolean findTargetHashSet(TreeNode root, int k) {
        return dfs(root, k, new HashSet<>());
    }

    private static boolean dfs(TreeNode n, int k, Set<Integer> seen) {
        if (n == null) return false;
        if (seen.contains(k - n.val)) return true;
        seen.add(n.val);
        return dfs(n.left, k, seen) || dfs(n.right, k, seen);
    }

    // Optimal space: two-pointer technique with TWO controlled inorder walks (ascending from the left, descending from the right),
    // like Two Sum II on a sorted array. O(n) time, O(h) space
    static boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> asc = new ArrayDeque<>(), desc = new ArrayDeque<>();
        pushLeft(asc, root);
        pushRight(desc, root);
        TreeNode lo = nextAsc(asc), hi = nextDesc(desc);
        while (lo != null && hi != null && lo != hi) {          // two DIFFERENT nodes
            int sum = lo.val + hi.val;
            if (sum == k) return true;
            if (sum < k) lo = nextAsc(asc);
            else hi = nextDesc(desc);
        }
        return false;
    }

    private static void pushLeft(Deque<TreeNode> s, TreeNode n) {
        for (; n != null; n = n.left) s.push(n);
    }

    private static void pushRight(Deque<TreeNode> s, TreeNode n) {
        for (; n != null; n = n.right) s.push(n);
    }

    private static TreeNode nextAsc(Deque<TreeNode> s) {
        if (s.isEmpty()) return null;
        TreeNode n = s.pop();
        pushLeft(s, n.right);
        return n;
    }

    private static TreeNode nextDesc(Deque<TreeNode> s) {
        if (s.isEmpty()) return null;
        TreeNode n = s.pop();
        pushRight(s, n.left);
        return n;
    }

    public static void main(String[] args) {
        TreeNode t = bst(5, 3, 6, 2, 4, 7);
        System.out.println(findTarget(t, 9) + " " + findTargetHashSet(t, 9));      // true true  (2 + 7)
        System.out.println(findTarget(t, 28) + " " + findTargetHashSet(t, 28));    // false false
        System.out.println(findTarget(bst(1), 2));                                  // false (the same node can't be used twice)
        System.out.println(findTarget(bst(2, 1, 3), 4));                            // true  (1 + 3)
        System.out.println(findTarget(null, 0));                                    // false
        System.out.println(findTarget(bst(-3, -5, 0), -3));                         // true  (-3 + 0)
    }
}
