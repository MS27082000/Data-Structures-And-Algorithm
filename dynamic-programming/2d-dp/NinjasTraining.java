import java.util.Arrays;

/** Ninja's Training: over n days choose one of 3 activities each day (points[day][activity]); the SAME activity cannot be done on two consecutive
 *  days. Maximise the total points. */
public class NinjasTraining {

    // State: f(day, last) = best points from `day` down to day 0 given that `last` is the activity done on day + 1 (3 = nothing yet).
    // f(day, last) = max over task != last of ( points[day][task] + f(day - 1, task) ). Base day 0: best task that is not `last`.
    // 2D state (day, last) => O(n * 4 * 3) time
    static int memo(int day, int last, int[][] pts, int[][] dp) {
        if (day == 0) {
            int best = 0;
            for (int t = 0; t < 3; t++) if (t != last) best = Math.max(best, pts[0][t]);
            return best;
        }
        if (dp[day][last] != -1) return dp[day][last];
        int best = 0;
        for (int t = 0; t < 3; t++) {
            if (t != last) best = Math.max(best, pts[day][t] + memo(day - 1, t, pts, dp));
        }
        return dp[day][last] = best;
    }

    // Tabulation with a 1D rolling array: dp[last] for the previous day. O(n * 12) time, O(1) extra space
    static int ninjaTraining(int[][] pts) {
        int n = pts.length;
        int[] prev = new int[4];
        for (int last = 0; last < 4; last++) {
            for (int t = 0; t < 3; t++) if (t != last) prev[last] = Math.max(prev[last], pts[0][t]);
        }
        for (int day = 1; day < n; day++) {
            int[] cur = new int[4];
            for (int last = 0; last < 4; last++) {
                for (int t = 0; t < 3; t++) {
                    if (t != last) cur[last] = Math.max(cur[last], pts[day][t] + prev[t]);
                }
            }
            prev = cur;
        }
        return prev[3];                                              // 3 = "no previous activity restriction"
    }

    public static void main(String[] args) {
        int[][] a = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        System.out.println(ninjaTraining(a));                                        // 210  (70 + 50 + 90)
        int[][] b = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        System.out.println(ninjaTraining(b));                                        // 11   (5 + 3 + 3)
        System.out.println(ninjaTraining(new int[][]{{18, 11, 19}}));                // 19   (one day: the best task)
        System.out.println(ninjaTraining(new int[][]{{1, 1, 1}, {1, 1, 1}}));        // 2
        int[][] dp = new int[a.length][4];
        for (int[] r : dp) Arrays.fill(r, -1);
        System.out.println(memo(a.length - 1, 3, a, dp));                            // 210 (matches)
    }
}
