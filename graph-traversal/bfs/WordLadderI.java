import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** Word Ladder (LC 127): length of the shortest transformation sequence from beginWord to endWord, changing ONE letter at a time,
 *  every intermediate word must be in the word list. 0 if impossible. The count includes both endpoints. */
public class WordLadderI {

    // Words are nodes; two words are adjacent if they differ by one letter. Shortest path => BFS. Instead of comparing all pairs
    // (O(N^2 L)), generate all L * 26 one-letter variants of the current word and look them up in a set. Remove a word from the set
    // when first reached (that doubles as the visited marker). O(N * L * 26) time, O(N * L) space
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int steps = 1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                String word = q.poll();
                if (word.equals(endWord)) return steps;
                char[] chars = word.toCharArray();
                for (int p = 0; p < chars.length; p++) {
                    char original = chars[p];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) continue;
                        chars[p] = ch;
                        String next = new String(chars);
                        if (words.remove(next)) q.offer(next);       // remove == mark visited
                    }
                    chars[p] = original;
                }
            }
            steps++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));   // 5  (hit hot dot dog cog)
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));          // 0  (cog not in the list)
        System.out.println(ladderLength("a", "c", Arrays.asList("a", "b", "c")));                                   // 2
        System.out.println(ladderLength("hot", "dog", Arrays.asList("hot", "dog")));                                // 0  (no one-letter chain)
        System.out.println(ladderLength("lost", "cost", Arrays.asList("most", "fist", "lost", "cost", "fish")));    // 2
    }
}
