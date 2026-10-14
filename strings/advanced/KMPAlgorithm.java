import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** KMP: pattern matching in O(n + m) using the LPS (longest proper prefix that is also a suffix) array */
public class KMPAlgorithm {

    // lps[i] = length of the longest PROPER prefix of pat[0..i] that is also a suffix of pat[0..i]. Built in O(m): on a mismatch fall back
    // to lps[len - 1] instead of restarting
    static int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;
        for (int i = 1; i < m; ) {
            if (pat.charAt(i) == pat.charAt(len)) lps[i++] = ++len;
            else if (len > 0) len = lps[len - 1];                  // try a shorter border; do NOT advance i
            else lps[i++] = 0;
        }
        return lps;
    }

    // Walk the text with one pointer j into the pattern. On a mismatch, j falls back via lps so the text pointer never moves backwards.
    // O(n + m) time, O(m) space
    static List<Integer> search(String text, String pat) {
        List<Integer> res = new ArrayList<>();
        int n = text.length(), m = pat.length();
        if (m == 0) return res;
        int[] lps = buildLPS(pat);
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pat.charAt(j)) j = lps[j - 1];
            if (text.charAt(i) == pat.charAt(j)) j++;
            if (j == m) {
                res.add(i - m + 1);
                j = lps[j - 1];                                    // keep going to find overlapping matches
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildLPS("aabaaab")));          // [0, 1, 0, 1, 2, 2, 3]
        System.out.println(Arrays.toString(buildLPS("abcabc")));           // [0, 0, 0, 1, 2, 3]
        System.out.println(Arrays.toString(buildLPS("aaaa")));             // [0, 1, 2, 3]
        System.out.println(Arrays.toString(buildLPS("abcd")));             // [0, 0, 0, 0]
        System.out.println(search("abracadabra", "abra"));                 // [0, 7]
        System.out.println(search("aaaaa", "aa"));                         // [0, 1, 2, 3]
        System.out.println(search("ababcabababc", "ababc"));               // [0, 7]  ("ababc" at 0, and at 7)
        System.out.println(search("abc", "xyz"));                          // []
    }
}
