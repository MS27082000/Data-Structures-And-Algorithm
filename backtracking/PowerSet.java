import java.util.ArrayList;
import java.util.List;

/** Power Set: all subsets of a set (bit-manipulation approach). Same output as Subsets I but iterative */
public class PowerSet {

    // Each mask from 0 to 2^n - 1 picks a subset: bit i set => include a[i]. O(n * 2^n) time and space
    static List<List<Integer>> powerSet(int[] a) {
        int n = a.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) subset.add(a[i]);
            }
            res.add(subset);
        }
        return res;
    }

    // Same idea on a String: all non-empty subsequences
    static List<String> powerSetOfString(String s) {
        List<String> res = new ArrayList<>();
        for (int mask = 1; mask < (1 << s.length()); mask++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) if ((mask & (1 << i)) != 0) sb.append(s.charAt(i));
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(powerSet(new int[]{1, 2, 3}));      // [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
        System.out.println(powerSet(new int[]{}));             // [[]]
        System.out.println(powerSetOfString("abc"));           // [a, b, ab, c, ac, bc, abc]
        System.out.println(powerSet(new int[]{5}).size());     // 2
    }
}
