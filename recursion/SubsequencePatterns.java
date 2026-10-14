import java.util.ArrayList;
import java.util.List;

/** Learn All Patterns of Subsequences (theory): the take / not-take recursion tree that most subsequence problems reuse */
public class SubsequencePatterns {

    // Pattern 1: generate ALL subsequences. At each index choose to TAKE or NOT TAKE. 2^n subsequences, O(n * 2^n) time
    static void allSubsequences(int index, int[] a, List<Integer> current, List<List<Integer>> result) {
        if (index == a.length) {
            result.add(new ArrayList<>(current));          // copy: current keeps changing
            return;
        }
        current.add(a[index]);                             // take
        allSubsequences(index + 1, a, current, result);
        current.remove(current.size() - 1);                // backtrack: undo the take
        allSubsequences(index + 1, a, current, result);    // not take
    }

    // Pattern 2: same recursion on a String (subsequences of "abc")
    static void allStringSubsequences(int index, String s, String current, List<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }
        allStringSubsequences(index + 1, s, current + s.charAt(index), result);   // take
        allStringSubsequences(index + 1, s, current, result);                     // not take
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        allSubsequences(0, new int[]{3, 1, 2}, new ArrayList<>(), res);
        System.out.println(res);        // [[3, 1, 2], [3, 1], [3, 2], [3], [1, 2], [1], [2], []]

        List<String> strs = new ArrayList<>();
        allStringSubsequences(0, "abc", "", strs);
        System.out.println(strs);       // [abc, ab, ac, a, bc, b, c, ]

        List<List<Integer>> empty = new ArrayList<>();
        allSubsequences(0, new int[]{}, new ArrayList<>(), empty);
        System.out.println(empty);      // [[]]  (the empty array has exactly one subsequence: the empty one)
    }
}
