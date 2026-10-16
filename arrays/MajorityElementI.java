/**
 * Majority Element (LC 169): the element that appears MORE than n/2 times (guaranteed to exist).
 *
 * Boyer-Moore Voting: think of it as an election.
 * Keep one candidate and a count of "votes" for them.
 *   - same number as the candidate  -> +1 vote
 *   - different number              -> -1 vote (one vote gets cancelled)
 *   - votes hit 0                   -> the next number becomes the new candidate
 * The majority element has more than half of all votes, so it can never be fully cancelled.
 *
 * Time O(n), space O(1).
 */
public class MajorityElementI {

    static int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int x : nums) {
            if (count == 0) {
                candidate = x;      // no candidate left, so pick the current number
            }

            if (x == candidate) {
                count++;            // a vote for the candidate
            } else {
                count--;            // a vote against the candidate
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));                 // 3
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));     // 2
        System.out.println(majorityElement(new int[]{1}));                       // 1
        System.out.println(majorityElement(new int[]{-1, -1, 2}));               // -1
    }
}
