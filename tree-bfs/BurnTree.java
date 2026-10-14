import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/** Minimum Time to Burn the Binary Tree from a Given Node: fire spreads to the parent, left child and right child each minute */
public class BurnTree {

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

    static TreeNode find(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode l = find(root.left, val);
        return l != null ? l : find(root.right, val);
    }

    // Same graph view as "nodes at distance K": parent map + multi-direction BFS. The answer is the number of BFS levels
    // after the start (the farthest node's distance). O(n) time, O(n) space
    static int minutesToBurn(TreeNode root, TreeNode start) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.left != null) { parent.put(n.left, n); q.offer(n.left); }
            if (n.right != null) { parent.put(n.right, n); q.offer(n.right); }
        }
        Set<TreeNode> burnt = new HashSet<>();
        q.offer(start);
        burnt.add(start);
        int minutes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean spread = false;                                // did the fire reach any NEW node this minute?
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                for (TreeNode next : new TreeNode[]{n.left, n.right, parent.get(n)}) {
                    if (next != null && burnt.add(next)) {
                        q.offer(next);
                        spread = true;
                    }
                }
            }
            if (spread) minutes++;
        }
        return minutes;
    }

    public static void main(String[] args) {
        TreeNode t = build(1, 2, 3, 4, 5, 6, 7);
        System.out.println(minutesToBurn(t, find(t, 2)));          // 3
        System.out.println(minutesToBurn(t, find(t, 4)));          // 4
        System.out.println(minutesToBurn(t, find(t, 1)));          // 2
        System.out.println(minutesToBurn(build(1), build(1)));     // 0  (single node: burns instantly)
        TreeNode skew = build(1, 2, null, 3);
        System.out.println(minutesToBurn(skew, find(skew, 3)));    // 2
    }
}
