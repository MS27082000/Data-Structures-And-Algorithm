import java.util.Arrays;

/** Set Matrix Zeroes (LC 73): if a cell is 0, set its whole row and column to 0, in place */
public class SetMatrixZeroes {

    // Use the first row and first column as markers. O(m*n) time, O(1) space
    static void setZeroes(int[][] m) {
        int rows = m.length, cols = m[0].length;
        boolean firstRowZero = false, firstColZero = false;
        for (int j = 0; j < cols; j++) if (m[0][j] == 0) firstRowZero = true;
        for (int i = 0; i < rows; i++) if (m[i][0] == 0) firstColZero = true;

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (m[i][j] == 0) {
                    m[i][0] = 0;     // mark row
                    m[0][j] = 0;     // mark column
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (m[i][0] == 0 || m[0][j] == 0) m[i][j] = 0;
            }
        }
        // Handle the marker row/column last, so we don't destroy the markers early
        if (firstRowZero) for (int j = 0; j < cols; j++) m[0][j] = 0;
        if (firstColZero) for (int i = 0; i < rows; i++) m[i][0] = 0;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(a);
        System.out.println(Arrays.deepToString(a));   // [[1, 0, 1], [0, 0, 0], [1, 0, 1]]

        int[][] b = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(b);
        System.out.println(Arrays.deepToString(b));   // [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]]

        int[][] c = {{1, 0}};
        setZeroes(c);
        System.out.println(Arrays.deepToString(c));   // [[0, 0]]
    }
}
