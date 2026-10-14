import java.util.ArrayList;
import java.util.List;

/** Majority Element II (LC 229): all elements appearing more than n/3 times */
public class MajorityElementII {

    // Extended Boyer-Moore with 2 candidates (at most 2 elements can exceed n/3). O(n) time, O(1) space
    static List<Integer> majorityElement(int[] nums) {
        int c1 = 0, c2 = 0, n1 = Integer.MIN_VALUE, n2 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x == n1) c1++;
            else if (x == n2) c2++;
            else if (c1 == 0) { n1 = x; c1 = 1; }
            else if (c2 == 0) { n2 = x; c2 = 1; }
            else { c1--; c2--; }
        }
        // Verification pass is mandatory: candidates may not actually qualify
        c1 = 0;
        c2 = 0;
        for (int x : nums) {
            if (x == n1) c1++;
            else if (x == n2) c2++;
        }
        List<Integer> res = new ArrayList<>();
        int limit = nums.length / 3;
        if (c1 > limit) res.add(n1);
        if (c2 > limit) res.add(n2);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));                 // [3]
        System.out.println(majorityElement(new int[]{1}));                       // [1]
        System.out.println(majorityElement(new int[]{1, 2}));                    // [1, 2]
        System.out.println(majorityElement(new int[]{1, 2, 3, 4}));              // []
        System.out.println(majorityElement(new int[]{2, 2, 1, 3}));              // [2]
        System.out.println(majorityElement(new int[]{Integer.MIN_VALUE, 1, 1})); // [1]
    }
}
