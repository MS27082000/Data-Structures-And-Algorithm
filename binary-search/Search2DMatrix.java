/** Search a 2D Matrix (LC 74): rows sorted, and the first element of each row > last element of the previous row */
public class Search2DMatrix {

    // The matrix is a sorted 1D array in disguise: index k -> row k / cols, column k % cols. O(log(m*n)), O(1)
    static boolean searchMatrix(int[][] m, int target) {
        if (m.length == 0 || m[0].length == 0) return false;
        int rows = m.length, cols = m[0].length;
        int low = 0, high = rows * cols - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = m[mid / cols][mid % cols];
            if (val == target) return true;
            if (val < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(m, 3));                  // true
        System.out.println(searchMatrix(m, 13));                 // false
        System.out.println(searchMatrix(m, 60));                 // true
        System.out.println(searchMatrix(new int[][]{{1}}, 1));   // true
        System.out.println(searchMatrix(new int[][]{{}}, 1));    // false
    }
}
