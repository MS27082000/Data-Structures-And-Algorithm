import java.util.Arrays;

/** Find a Peak Element II (LC 1901): a cell strictly greater than its 4 neighbours (outside the grid = -1); neighbouring cells are never equal */
public class FindPeakElementII {

    // Binary search on columns: take the max of the middle column, compare with its left/right neighbours and move
    // toward the larger side. O(m log n), O(1)
    static int[] findPeakGrid(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int low = 0, high = cols - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRow = 0;
            for (int i = 1; i < rows; i++) if (mat[i][mid] > mat[maxRow][mid]) maxRow = i;
            int left = mid > 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid < cols - 1 ? mat[maxRow][mid + 1] : -1;
            int cur = mat[maxRow][mid];
            if (cur > left && cur > right) return new int[]{maxRow, mid};
            if (left > cur) high = mid - 1;
            else low = mid + 1;
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPeakGrid(new int[][]{{1, 4}, {3, 2}})));                       // [1, 0] (or [0, 1]; any peak is valid)
        System.out.println(Arrays.toString(findPeakGrid(new int[][]{{10, 20, 15}, {21, 30, 14}, {7, 16, 32}}))); // [1, 1] or [2, 2]
        System.out.println(Arrays.toString(findPeakGrid(new int[][]{{5}})));                                  // [0, 0]
        System.out.println(Arrays.toString(findPeakGrid(new int[][]{{1, 2, 3, 4, 5}})));                      // [0, 4]
    }
}
