import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Z-function: z[i] = length of the longest substring starting at i that is also a PREFIX of s (z[0] is set to 0 by convention here) */
public class ZFunction {

    // Keep a window [l, r) = the rightmost segment that matches a prefix. For i inside it, start from the mirrored value z[i - l] (capped at the
    // window end); then extend by direct comparison. Each extension moves r right, so total O(n)
    static int[] zArray(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i < r) z[i] = Math.min(r - i, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) z[i]++;
            if (i + z[i] > r) { l = i; r = i + z[i]; }
        }
        return z;
    }

    // Pattern matching: z-array of pattern + '#' + text; every position with z == m is a match. O(n + m)
    static List<Integer> search(String text, String pat) {
        List<Integer> res = new ArrayList<>();
        if (pat.isEmpty()) return res;
        String s = pat + "#" + text;                                // '#' must not occur in either string
        int[] z = zArray(s);
        int m = pat.length();
        for (int i = m + 1; i < s.length(); i++) if (z[i] == m) res.add(i - m - 1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(zArray("aabxaabxcaabxaabxay")));    // [0, 1, 0, 0, 4, 1, 0, 0, 0, 8, 1, 0, 0, 5, 1, 0, 0, 1, 0]
        System.out.println(Arrays.toString(zArray("aaaaa")));                   // [0, 4, 3, 2, 1]
        System.out.println(Arrays.toString(zArray("abcd")));                    // [0, 0, 0, 0]
        System.out.println(search("abracadabra", "abra"));                      // [0, 7]
        System.out.println(search("aaaaa", "aa"));                              // [0, 1, 2, 3]
        System.out.println(search("hello", "xyz"));                             // []
    }
}
