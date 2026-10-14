import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Merge Intervals (LC 56): merge all overlapping intervals */
public class MergeIntervals {

    // Sort by start; extend the last merged interval while the next one overlaps. O(n log n) time, O(n) output
    static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        int[][] sorted = intervals.clone();                          // don't reorder the caller's array
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = sorted[0].clone();
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] <= current[1]) {                        // overlap (touching intervals [1,4],[4,5] merge)
                current[1] = Math.max(current[1], sorted[i][1]);     // max: the next one may be fully inside current
            } else {
                merged.add(current);
                current = sorted[i].clone();
            }
        }
        merged.add(current);
        return merged.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));  // [[1, 6], [8, 10], [15, 18]]
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {4, 5}})));                      // [[1, 5]]
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 4}, {2, 3}})));                      // [[1, 4]] (contained)
        System.out.println(Arrays.deepToString(merge(new int[][]{{8, 10}, {1, 3}, {2, 6}})));             // [[1, 6], [8, 10]] (unsorted input)
        System.out.println(Arrays.deepToString(merge(new int[][]{{5, 5}})));                              // [[5, 5]]
        System.out.println(Arrays.deepToString(merge(new int[][]{})));                                    // []
    }
}
