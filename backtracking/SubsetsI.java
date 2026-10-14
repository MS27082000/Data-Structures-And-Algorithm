import java.util.ArrayList;
import java.util.List;

/** Subsets (LC 78): all subsets of an array of DISTINCT integers */
public class SubsetsI {

    // Backtracking: at every node the current path is a valid subset; extend it with each later element.
    // O(n * 2^n) time, O(n) recursion stack
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));                  // record a copy of the current subset
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);                           // choose
            backtrack(i + 1, nums, path, res);           // explore
            path.remove(path.size() - 1);                // un-choose
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));  // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
        System.out.println(subsets(new int[]{0}));        // [[], [0]]
        System.out.println(subsets(new int[]{}));         // [[]]
        System.out.println(subsets(new int[]{1, 2, 3, 4}).size()); // 16
    }
}
