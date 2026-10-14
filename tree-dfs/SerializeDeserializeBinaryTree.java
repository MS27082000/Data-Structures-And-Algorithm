import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;

/** Serialize and Deserialize Binary Tree (LC 297): convert a tree to a string and back */
public class SerializeDeserializeBinaryTree {

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

    // Preorder with an explicit "#" marker for every null child. The markers make the structure unambiguous.
    // O(n) time, O(n) space (and O(h) stack)
    static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        write(root, sb);
        return sb.toString();
    }

    private static void write(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(',');
        write(node.left, sb);
        write(node.right, sb);
    }

    // Read tokens in the SAME order: the next token is the root, then the whole left subtree, then the whole right subtree
    static TreeNode deserialize(String data) {
        Deque<String> tokens = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return read(tokens);
    }

    private static TreeNode read(Deque<String> tokens) {
        String t = tokens.poll();
        if (t == null || t.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(t));
        node.left = read(tokens);
        node.right = read(tokens);
        return node;
    }

    public static void main(String[] args) {
        TreeNode t = build(1, 2, 3, null, null, 4, 5);
        String s = serialize(t);
        System.out.println(s);                                                 // 1,2,#,#,3,4,#,#,5,#,#,
        System.out.println(serialize(deserialize(s)).equals(s));               // true  (round trip)
        System.out.println(serialize(build()));                                // #,
        System.out.println(serialize(deserialize(serialize(build()))));        // #,
        TreeNode neg = build(-1, 0, 1);
        System.out.println(serialize(deserialize(serialize(neg))));            // -1,0,#,#,1,#,#,  (negatives and zero work)
        TreeNode skew = build(1, null, 2, null, 3);
        System.out.println(serialize(skew));                                   // 1,#,2,#,3,#,#,
    }
}
