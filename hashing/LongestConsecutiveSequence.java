import java.util.HashSet;
import java.util.Set;

/** Longest Consecutive Sequence (LC 128): length of the longest run of consecutive integers (order in the array doesn't matter) */
public class LongestConsecutiveSequence {

    // HashSet; only start counting from a number with no predecessor (x-1 absent). O(n) time, O(n) space
    static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int best = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {            // x is the START of a sequence
                int cur = x, len = 1;
                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }
                best = Math.max(best, len);
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));         // 4
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2}));                   // 3 (duplicates)
        System.out.println(longestConsecutive(new int[]{}));                             // 0
        System.out.println(longestConsecutive(new int[]{-1, -2, -3, 5}));                // 3
    }
}
