import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/** Word Ladder II (LC 126): ALL shortest transformation sequences from beginWord to endWord */
public class WordLadderII {

    // Phase 1 (BFS): compute each word's distance from beginWord AND record, for every word, its PARENTS (words one step closer).
    // Phase 2 (DFS from endWord back to beginWord over the parent links): enumerate every shortest path.
    // Only words on shortest paths are ever expanded, so it is far cheaper than exploring all paths.
    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!words.contains(endWord)) return result;
        Map<String, List<String>> parents = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        dist.put(beginWord, 0);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            for (int i = q.size(); i > 0; i--) {                  // one BFS level at a time
                String word = q.poll();
                int d = dist.get(word);
                char[] chars = word.toCharArray();
                for (int p = 0; p < chars.length; p++) {
                    char original = chars[p];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;
                        chars[p] = ch;
                        String next = new String(chars);
                        if (!words.contains(next)) continue;
                        if (!dist.containsKey(next)) {            // first time reached: it is exactly one level further
                            dist.put(next, d + 1);
                            q.offer(next);
                        }
                        if (dist.get(next) == d + 1) {            // a shortest-path edge word -> next
                            parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                            if (next.equals(endWord)) found = true;
                        }
                    }
                    chars[p] = original;
                }
            }
        }
        if (found) build(endWord, beginWord, parents, new ArrayList<>(Collections.singletonList(endWord)), result);
        return result;
    }

    private static void build(String word, String begin, Map<String, List<String>> parents, List<String> path, List<List<String>> result) {
        if (word.equals(begin)) {
            List<String> seq = new ArrayList<>(path);
            Collections.reverse(seq);                             // the path was built from the end backwards
            result.add(seq);
            return;
        }
        for (String p : parents.getOrDefault(word, Collections.emptyList())) {
            path.add(p);
            build(p, begin, parents, path, result);
            path.remove(path.size() - 1);                         // backtrack
        }
    }

    static String show(List<List<String>> r) {
        List<String> rows = new ArrayList<>();
        for (List<String> l : r) rows.add(String.join("->", l));
        Collections.sort(rows);                                   // the order of sequences is unspecified: sort for a stable print
        return rows.toString();
    }

    public static void main(String[] args) {
        System.out.println(show(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
        // [hit->hot->dot->dog->cog, hit->hot->lot->log->cog]
        System.out.println(show(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"))));   // []
        System.out.println(show(findLadders("a", "c", Arrays.asList("a", "b", "c"))));                            // [a->c]
        System.out.println(show(findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee"))));
        // [red->ted->tad->tax, red->ted->tex->tax, red->rex->tex->tax]
    }
}
