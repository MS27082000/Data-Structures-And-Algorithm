import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Combination Sum II (LC 40): candidates may contain duplicates, each element used AT MOST ONCE; unique combinations */
public class CombinationSumII {

    // Sort, move to i+1 after picking, and skip same-level duplicates. O(2^n) time, O(n) stack
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, int[] c, int remaining, List<Integer> path, List<List<Integer>> res) {
        if (remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < c.length; i++) {
            if (i > start && c[i] == c[i - 1]) continue;    // skip duplicate at the same level
            if (c[i] > remaining) break;
            path.add(c[i]);
            backtrack(i + 1, c, remaining - c[i], path, res);   // i + 1: each element used once
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));  // [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));          // [[1, 2, 2], [5]]
        System.out.println(combinationSum2(new int[]{1}, 2));                      // []
        System.out.println(combinationSum2(new int[]{1, 1, 1}, 2));                // [[1, 1]]
    }
}
