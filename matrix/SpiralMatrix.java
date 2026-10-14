import java.util.ArrayList;
import java.util.List;

/** Spiral Matrix (LC 54) */
public class SpiralMatrix {

    // Shrink four boundaries: top, bottom, left, right. O(m*n) time, O(1) extra space
    static List<Integer> spiralOrder(int[][] m) {
        List<Integer> res = new ArrayList<>();
        if (m.length == 0) return res;
        int top = 0, bottom = m.length - 1, left = 0, right = m[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) res.add(m[top][j]);          // left -> right
            top++;
            for (int i = top; i <= bottom; i++) res.add(m[i][right]);        // top -> bottom
            right--;
            if (top <= bottom) {                                             // guard: single remaining row
                for (int j = right; j >= left; j--) res.add(m[bottom][j]);   // right -> left
                bottom--;
            }
            if (left <= right) {                                             // guard: single remaining column
                for (int i = bottom; i >= top; i--) res.add(m[i][left]);     // bottom -> top
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));          // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})); // [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}}));                                  // [1, 2, 3]
        System.out.println(spiralOrder(new int[][]{{1}, {2}, {3}}));                              // [1, 2, 3]
    }
}
