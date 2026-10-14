import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Print Root to Leaf Paths in a Binary Tree (LC 257 prints them as "1->2->5") */
public class RootToLeafPaths {

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

    // DFS with a path list: add the node, recurse, REMOVE the node (backtrack). Record when a leaf is reached.
    // O(n * h) time (each path is copied), O(h) stack
    static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private static void dfs(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) result.add(new ArrayList<>(path));   // copy: `path` keeps changing
        else {
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
        path.remove(path.size() - 1);                                                     // backtrack
    }

    // LeetCode 257 format: "1->2->5". Passing the path as an immutable String avoids the explicit backtrack step
    static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        build(root, "", result);
        return result;
    }

    private static void build(TreeNode node, String prefix, List<String> result) {
        if (node == null) return;
        String path = prefix.isEmpty() ? String.valueOf(node.val) : prefix + "->" + node.val;
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        build(node.left, path, result);
        build(node.right, path, result);
    }

    public static void main(String[] args) {
        TreeNode t = build(1, 2, 3, null, 5);
        System.out.println(allPaths(t));                          // [[1, 2, 5], [1, 3]]
        System.out.println(binaryTreePaths(t));                   // [1->2->5, 1->3]
        System.out.println(binaryTreePaths(build(1)));            // [1]
        System.out.println(allPaths(build(1, 2, 3, 4, 5, 6, 7))); // [[1, 2, 4], [1, 2, 5], [1, 3, 6], [1, 3, 7]]
        System.out.println(allPaths(build()));                    // []
        System.out.println(binaryTreePaths(build(1, null, 2)));   // [1->2]
    }
}
