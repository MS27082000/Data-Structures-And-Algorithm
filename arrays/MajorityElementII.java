import java.util.ArrayList;
import java.util.List;

/**
 * Majority Element II (LC 229): all elements appearing MORE than n/3 times.
 *
 * At most 2 elements can appear more than n/3 times, so we keep 2 candidates, each with its own vote count
 * (extended Boyer-Moore voting).
 *
 * Time O(n), space O(1).
 */
public class MajorityElementII {

    static List<Integer> majorityElement(int[] nums) {
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        // Pass 1: find the (at most) two possible candidates.
        for (int x : nums) {
            if (x == candidate1) {
                count1++;                       // vote for candidate1
            } else if (x == candidate2) {
                count2++;                       // vote for candidate2
            } else if (count1 == 0) {
                candidate1 = x;                 // candidate1 slot is free, take it
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = x;                 // candidate2 slot is free, take it
                count2 = 1;
            } else {
                count1--;                       // x is different from both: cancels one vote of each
                count2--;
            }
        }

        // Pass 2: the candidates might not really appear more than n/3 times, so count them again.
        count1 = 0;
        count2 = 0;
        for (int x : nums) {
            if (x == candidate1) {
                count1++;
            } else if (x == candidate2) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int limit = nums.length / 3;
        if (count1 > limit) result.add(candidate1);
        if (count2 > limit) result.add(candidate2);
        return result;
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
