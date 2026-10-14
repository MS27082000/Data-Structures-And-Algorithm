import java.util.Arrays;

/** Longest Word with All Prefixes / Complete String (LC 720 Longest Word in Dictionary): the longest word whose every prefix is also in the list.
 *  Ties: the lexicographically smallest. Return "" if none. */
public class LongestWordWithAllPrefixes {

    private static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }

    // Insert all words; then a word is "complete" if every node on its path is marked as an end. O(total chars) time and space.
    static String longestWord(String[] words) {
        Node root = new Node();
        for (String w : words) {
            Node cur = root;
            for (char ch : w.toCharArray()) {
                int i = ch - 'a';
                if (cur.next[i] == null) cur.next[i] = new Node();
                cur = cur.next[i];
            }
            cur.isEnd = true;
        }
        String best = "";
        for (String w : words) {
            Node cur = root;
            boolean ok = true;
            for (char ch : w.toCharArray()) {
                cur = cur.next[ch - 'a'];
                if (!cur.isEnd) { ok = false; break; }                 // a missing prefix
            }
            if (!ok) continue;
            if (w.length() > best.length() || (w.length() == best.length() && w.compareTo(best) < 0)) best = w;
        }
        return best;
    }

    // Alternative without a trie: sort, then keep a set of words built so far. O(n log n * L)
    static String longestWordSorted(String[] words) {
        String[] sorted = words.clone();
        Arrays.sort(sorted);
        java.util.Set<String> built = new java.util.HashSet<>();
        String best = "";
        for (String w : sorted) {
            if (w.length() == 1 || built.contains(w.substring(0, w.length() - 1))) {
                built.add(w);
                if (w.length() > best.length()) best = w;              // sorted order means the first of a given length is the smallest
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));                       // world
        System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));    // apple  ("apply" ties; "apple" is smaller)
        System.out.println(longestWord(new String[]{"abc", "bc", "ab", "qwe"}));                                // ""  (no word starts a chain: needs "a")
        System.out.println(longestWord(new String[]{"yodn", "yo", "y", "yod"}));                                // yodn
        System.out.println(longestWordSorted(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));   // apple
        System.out.println("[" + longestWord(new String[]{"ab"}) + "]");                                        // []
    }
}
