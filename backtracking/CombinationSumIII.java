import java.util.ArrayList;
import java.util.List;

/** Combination Sum III (LC 216): choose exactly k numbers from 1..9 (each at most once) that sum to n */
public class CombinationSumIII {

    // Increasing order guarantees uniqueness. Prune on size and remaining sum. O(C(9, k)) time
    static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, int k, int remaining, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            if (remaining == 0) res.add(new ArrayList<>(path));
            return;
        }
        for (int num = start; num <= 9; num++) {
            if (num > remaining) break;                      // numbers only get bigger
            path.add(num);
            backtrack(num + 1, k, remaining - num, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));    // [[1, 2, 4]]
        System.out.println(combinationSum3(3, 9));    // [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
        System.out.println(combinationSum3(4, 1));    // []
        System.out.println(combinationSum3(2, 18));   // []
        System.out.println(combinationSum3(9, 45));   // [[1, 2, 3, 4, 5, 6, 7, 8, 9]]
    }
}
