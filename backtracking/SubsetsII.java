import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Subsets II (LC 90): all UNIQUE subsets of an array that may contain duplicates */
public class SubsetsII {

    // Sort, then at each recursion level skip an element equal to the previous one at the SAME level.
    // O(n * 2^n) time, O(n) stack
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;   // i > start: same-level duplicate (NOT i > 0)
            path.add(nums[i]);
            backtrack(i + 1, nums, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));       // [[], [1], [1, 2], [1, 2, 2], [2], [2, 2]]
        System.out.println(subsetsWithDup(new int[]{0}));             // [[], [0]]
        System.out.println(subsetsWithDup(new int[]{2, 2, 2}));       // [[], [2], [2, 2], [2, 2, 2]]
        System.out.println(subsetsWithDup(new int[]{4, 4, 4, 1, 4})); // 10 subsets
    }
}
