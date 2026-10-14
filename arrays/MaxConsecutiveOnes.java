/** Maximum Consecutive Ones (LC 485) */
public class MaxConsecutiveOnes {

    // O(n) time, O(1) space. Reset the running count on a 0; update max on every step.
    static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for (int x : nums) {
            if (x == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));  // 3
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));  // 2
        System.out.println(findMaxConsecutiveOnes(new int[]{0, 0}));              // 0
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 1}));           // 3 (ends on a 1)
    }
}
