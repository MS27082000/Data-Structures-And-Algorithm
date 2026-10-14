import java.util.HashSet;
import java.util.Set;

/** Number of Distinct Substrings in a String (count the empty string too only if the problem says so; here the NON-EMPTY substrings, plus a variant) */
public class NumberOfDistinctSubstrings {

    private static class Node {
        Node[] next = new Node[26];
    }

    // Insert EVERY suffix into a trie. Each new node created = one new distinct substring (a prefix of a suffix). O(n^2) time and space
    static int countDistinct(String s) {
        Node root = new Node();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Node cur = root;
            for (int j = i; j < s.length(); j++) {
                int c = s.charAt(j) - 'a';
                if (cur.next[c] == null) {
                    cur.next[c] = new Node();
                    count++;
                }
                cur = cur.next[c];
            }
        }
        return count;
    }

    // Brute force with a HashSet: O(n^3) time (substring copy), O(n^3) space
    static int countDistinctBrute(String s) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j <= s.length(); j++) set.add(s.substring(i, j));
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(countDistinct("abab") + " " + countDistinctBrute("abab"));         // 7  (a, b, ab, ba, aba, bab, abab)
        System.out.println(countDistinct("aaa") + " " + countDistinctBrute("aaa"));           // 3  (a, aa, aaa)
        System.out.println(countDistinct("abc") + " " + countDistinctBrute("abc"));           // 6
        System.out.println(countDistinct("a"));                                               // 1
        System.out.println(countDistinct(""));                                                // 0
        System.out.println(countDistinct("ababa") + " " + countDistinctBrute("ababa"));       // 9
        System.out.println((countDistinct("abab") + 1) + " (counting the empty substring too, as some versions ask)");   // 8
    }
}
