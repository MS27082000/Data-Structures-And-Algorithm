/** Jump Game II (LC 45): minimum number of jumps to reach the last index (the end is always reachable) */
public class JumpGameII {

    // BFS by "levels": all indices reachable with k jumps form a window [start, currentEnd]. When we pass currentEnd
    // we must take another jump, and the new window ends at the farthest index seen. O(n) time, O(1) space
    static int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {           // stop BEFORE the last index
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {                            // finished the current level: jump
                jumps++;
                currentEnd = farthest;
                if (currentEnd >= nums.length - 1) break;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));          // 2
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));          // 2
        System.out.println(jump(new int[]{0}));                      // 0
        System.out.println(jump(new int[]{1, 1, 1, 1}));             // 3
        System.out.println(jump(new int[]{10, 1, 1, 1, 1}));         // 1
        System.out.println(jump(new int[]{1, 2}));                   // 1
    }
}
