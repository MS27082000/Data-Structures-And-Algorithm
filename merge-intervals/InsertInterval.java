import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Insert Interval (LC 57): the input intervals are sorted and non-overlapping; insert one and merge if needed */
public class InsertInterval {

    // Three phases in one pass: (1) copy intervals that end before the new one starts, (2) merge everything that overlaps,
    // (3) copy the rest. O(n) time, O(n) output
    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        int start = newInterval[0], end = newInterval[1];

        while (i < n && intervals[i][1] < start) result.add(intervals[i++]);        // entirely before

        while (i < n && intervals[i][0] <= end) {                                   // overlapping: absorb into the new one
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start, end});

        while (i < n) result.add(intervals[i++]);                                   // entirely after
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));   // [[1, 5], [6, 9]]
        System.out.println(Arrays.deepToString(insert(
                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));               // [[1, 2], [3, 10], [12, 16]]
        System.out.println(Arrays.deepToString(insert(new int[][]{}, new int[]{5, 7})));                  // [[5, 7]]
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{2, 3})));            // [[1, 5]]
        System.out.println(Arrays.deepToString(insert(new int[][]{{1, 5}}, new int[]{6, 8})));            // [[1, 5], [6, 8]]
        System.out.println(Arrays.deepToString(insert(new int[][]{{3, 5}}, new int[]{1, 2})));            // [[1, 2], [3, 5]]
    }
}
