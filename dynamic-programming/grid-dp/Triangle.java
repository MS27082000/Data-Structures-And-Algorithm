import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Triangle (LC 120): from the top, move to an adjacent number on the next row (index i or i + 1). Minimum path sum from top to bottom */
public class Triangle {

    // BOTTOM-UP: start from the last row. For each cell, best = value + min(the two cells below it). The answer is dp[0] at the top.
    // Going bottom-up avoids special cases at the edges. O(n^2) time (n rows), O(n) space
    static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) dp[j] = triangle.get(n - 1).get(j);     // the last row is the base case
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    static List<List<Integer>> tri(int[]... rows) {
        List<List<Integer>> t = new ArrayList<>();
        for (int[] r : rows) {
            List<Integer> row = new ArrayList<>();
            for (int x : r) row.add(x);
            t.add(row);
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(minimumTotal(tri(new int[]{2}, new int[]{3, 4}, new int[]{6, 5, 7}, new int[]{4, 1, 8, 3})));   // 11  (2 + 3 + 5 + 1)
        System.out.println(minimumTotal(tri(new int[]{-10})));                                                              // -10
        System.out.println(minimumTotal(tri(new int[]{1}, new int[]{2, 3})));                                               // 3
        System.out.println(minimumTotal(tri(new int[]{-1}, new int[]{2, 3}, new int[]{1, -1, -3})));                         // -1  (-1 + 3 + -3)
        System.out.println(minimumTotal(tri(new int[]{5}, new int[]{9, 6}, new int[]{4, 6, 8}, new int[]{0, 7, 1, 5})));    // 18  (5 + 6 + 6 + 1)
    }
}
