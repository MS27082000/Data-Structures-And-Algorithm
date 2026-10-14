/** Search a 2D Matrix II (LC 240): each row sorted left to right, each column sorted top to bottom */
public class Search2DMatrixII {

    // Staircase search from the top-right corner: too big => move left, too small => move down. O(m + n), O(1)
    static boolean searchMatrix(int[][] m, int target) {
        if (m.length == 0 || m[0].length == 0) return false;
        int row = 0, col = m[0].length - 1;
        while (row < m.length && col >= 0) {
            int val = m[row][col];
            if (val == target) return true;
            if (val > target) col--;       // everything below in this column is even larger
            else row++;                    // everything to the left in this row is even smaller
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println(searchMatrix(m, 5));      // true
        System.out.println(searchMatrix(m, 20));     // false
        System.out.println(searchMatrix(m, 30));     // true
        System.out.println(searchMatrix(m, 1));      // true
        System.out.println(searchMatrix(new int[][]{{-5}}, -10));   // false
    }
}
