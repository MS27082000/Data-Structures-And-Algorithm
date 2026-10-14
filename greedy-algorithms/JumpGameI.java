/** Jump Game (LC 55): nums[i] is the maximum jump length from i. Can you reach the last index? */
public class JumpGameI {

    // Track the farthest reachable index. If we ever stand beyond it, we're stuck. O(n) time, O(1) space
    static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;                   // index i is unreachable
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) return true;     // early exit
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));      // true
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));      // false (stuck at index 3)
        System.out.println(canJump(new int[]{0}));                  // true  (already at the end)
        System.out.println(canJump(new int[]{0, 1}));               // false
        System.out.println(canJump(new int[]{2, 0, 0}));            // true
    }
}
