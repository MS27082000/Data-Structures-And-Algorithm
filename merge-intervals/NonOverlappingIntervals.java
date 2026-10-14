import java.util.Arrays;

/** Non-overlapping Intervals (LC 435): minimum number of intervals to REMOVE so the rest don't overlap */
public class NonOverlappingIntervals {

    // Classic activity selection: sort by END time, keep an interval if it starts at/after the last kept end.
    // Removals = total - kept. O(n log n) time, O(1) extra space
    static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[1], b[1]));
        int kept = 1, lastEnd = sorted[0][1];
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] >= lastEnd) {            // touching intervals ([1,2],[2,3]) do NOT overlap
                kept++;
                lastEnd = sorted[i][1];
            }                                         // else: overlap, drop this one (it ends later than the kept one)
        }
        return sorted.length - kept;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));   // 1
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));           // 2
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));                   // 0
        System.out.println(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}})); // 2
        System.out.println(eraseOverlapIntervals(new int[][]{}));                                 // 0
    }
}
