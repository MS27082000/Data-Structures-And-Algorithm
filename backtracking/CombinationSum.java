import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Combination Sum (LC 39): distinct candidates, each can be used UNLIMITED times; find unique combinations summing to target */
public class CombinationSum {

    // Stay at index i after picking it (reuse allowed); move to i+1 to skip. Sorting enables an early break.
    // O(2^target) roughly, O(target / min) stack depth
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (c[i] > remaining) break;                    // sorted: nothing after this can fit
            path.add(c[i]);
            backtrack(i, c, remaining - c[i], path, res);   // i, not i+1: the same number may be reused
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));       // [[2, 2, 3], [7]]
        System.out.println(combinationSum(new int[]{2, 3, 5}, 8));          // [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        System.out.println(combinationSum(new int[]{2}, 1));                // []
        System.out.println(combinationSum(new int[]{1}, 3));                // [[1, 1, 1]]
    }
}
