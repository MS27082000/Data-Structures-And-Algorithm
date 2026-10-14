/** Implement Trie II (advanced operations): insert, countWordsEqualTo, countWordsStartingWith, erase */
public class ImplementTrieII {

    private static class Node {
        Node[] next = new Node[26];
        int endCount;        // how many words end exactly here
        int prefixCount;     // how many words pass through this node
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (cur.next[i] == null) cur.next[i] = new Node();
            cur = cur.next[i];
            cur.prefixCount++;
        }
        cur.endCount++;
    }

    public int countWordsEqualTo(String word) {
        Node cur = root;
        for (char ch : word.toCharArray()) {
            cur = cur.next[ch - 'a'];
            if (cur == null) return 0;
        }
        return cur.endCount;
    }

    public int countWordsStartingWith(String prefix) {
        Node cur = root;
        for (char ch : prefix.toCharArray()) {
            cur = cur.next[ch - 'a'];
            if (cur == null) return 0;
        }
        return cur.prefixCount;
    }

    // Erase one copy. Guaranteed to exist per the problem; here we check first so a missing word is a harmless no-op.
    // Counts are decremented along the path (nodes are left in place, which is fine; they just have count 0)
    public void erase(String word) {
        if (countWordsEqualTo(word) == 0) return;
        Node cur = root;
        for (char ch : word.toCharArray()) {
            cur = cur.next[ch - 'a'];
            cur.prefixCount--;
        }
        cur.endCount--;
    }

    public static void main(String[] args) {
        ImplementTrieII t = new ImplementTrieII();
        t.insert("apple");
        t.insert("apple");
        System.out.println(t.countWordsEqualTo("apple"));         // 2
        System.out.println(t.countWordsStartingWith("app"));      // 2
        t.erase("apple");
        System.out.println(t.countWordsEqualTo("apple"));         // 1
        System.out.println(t.countWordsStartingWith("app"));      // 1
        t.erase("apple");
        System.out.println(t.countWordsStartingWith("app"));      // 0
        t.insert("app");
        t.insert("apple");
        System.out.println(t.countWordsStartingWith("app") + " " + t.countWordsEqualTo("app"));   // 2 1
        t.erase("zzz");                                                                            // no-op
        System.out.println(t.countWordsEqualTo("zzz"));           // 0
    }
}
