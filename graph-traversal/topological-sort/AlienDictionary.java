import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/** Alien Dictionary (LC 269): the words are sorted in an unknown alien alphabet. Return the order of the letters, or "" if invalid */
public class AlienDictionary {

    // 1) Every letter is a node. 2) Compare each ADJACENT pair of words: the first position where they differ gives an edge
    //    (letter in the earlier word -> letter in the later word). 3) Topologically sort. If a cycle exists, or a longer word comes
    //    before its own prefix ("abc" before "ab"), the input is invalid. O(total characters + alphabet) time
    static String alienOrder(String[] words) {
        Map<Character, Set<Character>> g = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                g.putIfAbsent(c, new HashSet<>());
                indeg.putIfAbsent(c, 0);
            }
        }
        for (int i = 0; i + 1 < words.length; i++) {
            String a = words[i], b = words[i + 1];
            if (a.length() > b.length() && a.startsWith(b)) return "";        // "abc" cannot precede its prefix "ab"
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                char x = a.charAt(j), y = b.charAt(j);
                if (x != y) {
                    if (g.get(x).add(y)) indeg.merge(y, 1, Integer::sum);     // add the edge ONCE (a Set dedupes repeats)
                    break;                                                    // later letters say nothing about the order
                }
            }
        }
        Queue<Character> q = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> e : indeg.entrySet()) if (e.getValue() == 0) q.offer(e.getKey());
        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            char c = q.poll();
            order.append(c);
            for (char nb : g.get(c)) if (indeg.merge(nb, -1, Integer::sum) == 0) q.offer(nb);
        }
        return order.length() == g.size() ? order.toString() : "";            // fewer letters than nodes => cycle
    }

    // Validity checker: for every adjacent pair, the first differing letter must be ordered correctly by `order`
    static boolean consistent(String[] words, String order) {
        Map<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < order.length(); i++) pos.put(order.charAt(i), i);
        for (int i = 0; i + 1 < words.length; i++) {
            String a = words[i], b = words[i + 1];
            for (int j = 0; j < Math.min(a.length(), b.length()); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    if (pos.get(a.charAt(j)) > pos.get(b.charAt(j))) return false;
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] w1 = {"wrt", "wrf", "er", "ett", "rftt"};
        String o1 = alienOrder(w1);
        System.out.println(o1 + " " + consistent(w1, o1));                          // wertf true
        String[] w2 = {"z", "x"};
        System.out.println(alienOrder(w2));                                          // zx
        System.out.println("[" + alienOrder(new String[]{"z", "x", "z"}) + "]");     // []  (z < x < z is a cycle)
        System.out.println("[" + alienOrder(new String[]{"abc", "ab"}) + "]");       // []  (prefix rule violated)
        System.out.println(alienOrder(new String[]{"a"}));                           // a
        String[] w3 = {"baa", "abcd", "abca", "cab", "cad"};
        String o3 = alienOrder(w3);
        System.out.println(o3 + " " + consistent(w3, o3));                           // bdac true
    }
}
