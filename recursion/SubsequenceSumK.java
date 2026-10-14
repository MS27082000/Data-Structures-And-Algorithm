import java.util.ArrayList;
import java.util.List;

/** Check if there exists a subsequence with sum K (and print one such subsequence) */
public class SubsequenceSumK {

    // Take / not-take recursion that RETURNS a boolean, so we stop at the first success. Worst case O(2^n), O(n) stack
    static boolean exists(int index, int[] a, int remaining, List<Integer> current, List<Integer> answer) {
        if (remaining == 0) {                              // sum reached (stop even if the rest are zeros)
            answer.addAll(current);
            return true;
        }
        if (index == a.length) return false;
        current.add(a[index]);
        if (exists(index + 1, a, remaining - a[index], current, answer)) return true;
        current.remove(current.size() - 1);                // backtrack
        return exists(index + 1, a, remaining, current, answer);
    }

    // Pruning variant for POSITIVE numbers only: if remaining < 0 the branch can never recover
    static boolean existsPositive(int index, int[] a, int remaining) {
        if (remaining == 0) return true;
        if (remaining < 0 || index == a.length) return false;
        return existsPositive(index + 1, a, remaining - a[index]) || existsPositive(index + 1, a, remaining);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        List<Integer> ans = new ArrayList<>();
        System.out.println(exists(0, a, 9, new ArrayList<>(), ans) + " " + ans);   // true [1, 2, 3, ... first found]
        System.out.println(exists(0, a, 100, new ArrayList<>(), new ArrayList<>())); // false
        System.out.println(exists(0, new int[]{}, 0, new ArrayList<>(), new ArrayList<>())); // true (empty subsequence sums to 0)
        System.out.println(existsPositive(0, new int[]{4, 3, 9, 2}, 10));           // false
        System.out.println(existsPositive(0, new int[]{4, 3, 9, 2}, 13));           // true (4 + 9)
    }
}
