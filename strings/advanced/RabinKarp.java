import java.util.ArrayList;
import java.util.List;

/** Rabin-Karp: find every occurrence of a pattern in a text using a rolling hash */
public class RabinKarp {

    static final long MOD = 1_000_000_007L;
    static final long BASE = 131;

    // Hash the pattern and the first window. Slide the window: remove the leading char, shift, add the new char (O(1) per step).
    // On a hash match, COMPARE the actual strings to rule out a collision. Average O(n + m), worst case O(n * m) (many collisions)
    static List<Integer> search(String text, String pat) {
        List<Integer> res = new ArrayList<>();
        int n = text.length(), m = pat.length();
        if (m == 0 || m > n) return res;
        long highPow = 1;                                           // BASE^(m-1), the weight of the leading char
        for (int i = 1; i < m; i++) highPow = highPow * BASE % MOD;
        long ph = 0, wh = 0;
        for (int i = 0; i < m; i++) {
            ph = (ph * BASE + pat.charAt(i)) % MOD;
            wh = (wh * BASE + text.charAt(i)) % MOD;
        }
        for (int i = 0; ; i++) {
            if (ph == wh && text.startsWith(pat, i)) res.add(i);   // verify to avoid a false positive
            if (i + m >= n) break;
            wh = ((wh - text.charAt(i) * highPow) % MOD + MOD) % MOD;      // drop the leading char
            wh = (wh * BASE + text.charAt(i + m)) % MOD;                    // add the next char
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(search("abracadabra", "abra"));            // [0, 7]
        System.out.println(search("aaaaa", "aa"));                    // [0, 1, 2, 3]  (overlapping matches count)
        System.out.println(search("hello", "world"));                 // []
        System.out.println(search("abc", "abcd"));                    // []   (pattern longer than text)
        System.out.println(search("abc", ""));                        // []   (empty pattern: defined as no match here)
        System.out.println(search("GEEKS FOR GEEKS", "GEEKS"));       // [0, 10]
    }
}
