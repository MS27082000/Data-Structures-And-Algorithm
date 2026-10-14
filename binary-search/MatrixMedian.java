/** Median of a Row-wise Sorted Matrix: m x n matrix with m*n odd, each row sorted */
public class MatrixMedian {

    // Binary search on the VALUE in [min, max]. The median is the smallest value with at least (m*n+1)/2 elements <= it.
    // Count per row with upper bound. O(32 * m * log n), O(1)
    static int median(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int[] row : mat) {
            low = Math.min(low, row[0]);
            high = Math.max(high, row[cols - 1]);
        }
        int need = (rows * cols + 1) / 2;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int[] row : mat) count += upperBound(row, mid);   // elements <= mid
            if (count >= need) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static int upperBound(int[] row, int x) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (row[mid] > x) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(median(new int[][]{{1, 3, 5}, {2, 6, 9}, {3, 6, 9}}));           // 5
        System.out.println(median(new int[][]{{1, 3, 8}, {2, 3, 4}, {1, 2, 5}}));           // 3
        System.out.println(median(new int[][]{{1}}));                                       // 1
        System.out.println(median(new int[][]{{1, 2, 3, 4, 5}}));                           // 3
        System.out.println(median(new int[][]{{-5, -3, 0}, {-4, 2, 8}, {-1, 1, 9}}));       // 0
    }
}
