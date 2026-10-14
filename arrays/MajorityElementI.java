/** Majority Element (LC 169): element appearing more than n/2 times (guaranteed to exist) */
public class MajorityElementI {

    // Boyer-Moore Voting: O(n) time, O(1) space
    static int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int x : nums) {
            if (count == 0) candidate = x;
            count += (x == candidate) ? 1 : -1;
        }
        return candidate;   // valid because a majority is guaranteed; otherwise verify with a 2nd pass
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));                 // 3
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));     // 2
        System.out.println(majorityElement(new int[]{1}));                       // 1
        System.out.println(majorityElement(new int[]{-1, -1, 2}));               // -1
    }
}
