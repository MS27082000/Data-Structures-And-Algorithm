import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/** Vertical Order Traversal of a Binary Tree (LC 987): group by column (left to right); within a column sort by row, then by value */
public class VerticalOrderTraversal {

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

    // BFS tracking (column, row). columns: TreeMap(col -> list of {row, value}); sort each column by (row, value).
    // O(n log n) time, O(n) space
    static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<int[]>> columns = new TreeMap<>();
        Queue<Object[]> queue = new ArrayDeque<>();                         // {node, col, row}
        if (root != null) queue.offer(new Object[]{root, 0, 0});
        while (!queue.isEmpty()) {
            Object[] cur = queue.poll();
            TreeNode node = (TreeNode) cur[0];
            int col = (int) cur[1], row = (int) cur[2];
            columns.computeIfAbsent(col, k -> new ArrayList<>()).add(new int[]{row, node.val});
            if (node.left != null) queue.offer(new Object[]{node.left, col - 1, row + 1});
            if (node.right != null) queue.offer(new Object[]{node.right, col + 1, row + 1});
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> list : columns.values()) {
            list.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));   // row, then value
            List<Integer> vals = new ArrayList<>();
            for (int[] p : list) vals.add(p[1]);
            result.add(vals);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(verticalTraversal(build(3, 9, 20, null, null, 15, 7)));     // [[9], [3, 15], [20], [7]]
        System.out.println(verticalTraversal(build(1, 2, 3, 4, 5, 6, 7)));             // [[4], [2], [1, 5, 6], [3], [7]]
        System.out.println(verticalTraversal(build(1, 2, 3, 4, 6, 5, 7)));             // [[4], [2], [1, 5, 6], [3], [7]] (5 and 6 same row/col: sorted by value)
        System.out.println(verticalTraversal(build(1)));                               // [[1]]
        System.out.println(verticalTraversal(build()));                                // []
    }
}
