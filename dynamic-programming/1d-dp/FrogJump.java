import java.util.Arrays;

/** Frog Jump: a frog on stone 0 wants to reach stone n-1. From stone i it can jump to i+1 or i+2; a jump costs |height[i] - height[j]|.
 *  Minimum total energy. */
public class FrogJump {

    // State: f(i) = min energy to reach stone i. Recurrence: f(i) = min(f(i-1) + |h[i]-h[i-1]|, f(i-2) + |h[i]-h[i-2]|). Base f(0) = 0.
    static int memo(int i, int[] h, int[] dp) {
        if (i == 0) return 0;
        if (dp[i] != -1) return dp[i];
        int one = memo(i - 1, h, dp) + Math.abs(h[i] - h[i - 1]);
        int two = i > 1 ? memo(i - 2, h, dp) + Math.abs(h[i] - h[i - 2]) : Integer.MAX_VALUE;   // no stone i-2 for i = 1
        return dp[i] = Math.min(one, two);
    }

    // O(n) time, O(1) space (only the previous two states are needed)
    static int frogJump(int[] h) {
        int n = h.length;
        if (n <= 1) return 0;
        int prev2 = 0, prev = Math.abs(h[1] - h[0]);
        for (int i = 2; i < n; i++) {
            int cur = Math.min(prev + Math.abs(h[i] - h[i - 1]), prev2 + Math.abs(h[i] - h[i - 2]));
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(frogJump(new int[]{10, 20, 30, 10}));                // 20
        System.out.println(frogJump(new int[]{10, 50, 10}));                    // 0   (jump 0 -> 2 directly)
        System.out.println(frogJump(new int[]{30, 10, 60, 10, 60, 50}));        // 40
        System.out.println(frogJump(new int[]{7}));                             // 0
        System.out.println(frogJump(new int[]{5, 9}));                          // 4
        int[] h = {30, 10, 60, 10, 60, 50};
        int[] dp = new int[h.length];
        Arrays.fill(dp, -1);
        System.out.println(memo(h.length - 1, h, dp));                          // 40 (matches)
    }
}
