import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/** All Nodes Distance K in a Binary Tree (LC 863): nodes at distance k from a given target node (distance is counted along edges, in any direction) */
public class NodesAtDistanceK {

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

    // A tree edge only goes DOWN. To also go UP we record every node's parent, then BFS outwards from the target treating the
    // tree as an undirected graph (left, right, parent) with a visited set. O(n) time, O(n) space
    static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {                                  // pass 1: parent pointers
            TreeNode n = q.poll();
            if (n.left != null) { parent.put(n.left, n); q.offer(n.left); }
            if (n.right != null) { parent.put(n.right, n); q.offer(n.right); }
        }
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int distance = 0;
        while (!q.isEmpty()) {                                  // pass 2: BFS level by level from the target
            if (distance == k) break;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                for (TreeNode next : new TreeNode[]{n.left, n.right, parent.get(n)}) {
                    if (next != null && visited.add(next)) q.offer(next);
                }
            }
            distance++;
        }
        List<Integer> result = new ArrayList<>();
        for (TreeNode n : q) result.add(n.val);                 // whatever is left in the queue is exactly distance k away
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = build(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        System.out.println(distanceK(root, find(root, 5), 2));    // [7, 4, 1]
        System.out.println(distanceK(root, find(root, 5), 0));    // [5]
        System.out.println(distanceK(root, find(root, 6), 3));    // [7, 4, 1]  (6 -> 5 -> 2 -> 7 / 4,  6 -> 5 -> 3 -> 1)
        TreeNode one = build(1);
        System.out.println(distanceK(one, one, 3));               // []
        System.out.println(distanceK(root, find(root, 3), 1));    // [5, 1]
    }
}
