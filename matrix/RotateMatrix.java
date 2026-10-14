import java.util.Arrays;

/** Rotate Image (LC 48): rotate an n x n matrix 90 degrees clockwise, in place */
public class RotateMatrix {

    // Transpose, then reverse each row. O(n^2) time, O(1) space
    static void rotate(int[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {        // j starts at i+1, so each pair swaps only once
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        for (int[] row : m) {
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                int t = row[l];
                row[l] = row[r];
                row[r] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(a);
        System.out.println(Arrays.deepToString(a));   // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

        int[][] b = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(b);
        System.out.println(Arrays.deepToString(b));   // [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]

        int[][] c = {{1}};
        rotate(c);
        System.out.println(Arrays.deepToString(c));   // [[1]]
    }
}
