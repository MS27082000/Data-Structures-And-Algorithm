/** Implement Trie / Prefix Tree (LC 208): insert, search (whole word), startsWith (prefix) */
public class ImplementTrie {

    private static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }

    private final Node root = new Node();

    // O(L) time per call (L = word length); O(total characters) space overall
    public void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.next[i] == null) cur.next[i] = new Node();
            cur = cur.next[i];
        }
        cur.isEnd = true;
    }

    // walk the path; returns the last node, or null if the path breaks
    private Node walk(String s) {
        Node cur = root;
        for (char ch : s.toCharArray()) {
            cur = cur.next[ch - 'a'];
            if (cur == null) return null;
        }
        return cur;
    }

    public boolean search(String word) {
        Node n = walk(word);
        return n != null && n.isEnd;                       // the path exists AND a word ends here
    }

    public boolean startsWith(String prefix) {
        return walk(prefix) != null;
    }

    public static void main(String[] args) {
        ImplementTrie t = new ImplementTrie();
        t.insert("apple");
        System.out.println(t.search("apple"));        // true
        System.out.println(t.search("app"));          // false  (a prefix but not an inserted word)
        System.out.println(t.startsWith("app"));      // true
        t.insert("app");
        System.out.println(t.search("app"));          // true
        System.out.println(t.search("apples"));       // false
        System.out.println(t.startsWith("b"));        // false
        System.out.println(t.startsWith(""));         // true   (the empty prefix matches everything)
    }
}
