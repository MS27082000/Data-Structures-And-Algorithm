import java.util.ArrayList;
import java.util.List;

/** Pascal's Triangle I / II / III (Striver variants; III is LC 118, II is LC 119) */
public class PascalsTriangle {

    // I: value at row r, column c (1-indexed) = C(r-1, c-1). O(min(c, r-c)) time, O(1) space
    static long elementAt(int r, int c) {
        int n = r - 1, k = c - 1;
        k = Math.min(k, n - k);
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);     // multiply then divide: always an exact integer at every step
        }
        return res;
    }

    // II: print the n-th row (1-indexed). Build each value from the previous one. O(n) time
    static List<Integer> row(int n) {
        List<Integer> res = new ArrayList<>();
        long val = 1;
        res.add(1);
        for (int c = 1; c < n; c++) {
            val = val * (n - c) / c;           // C(n-1, c) = C(n-1, c-1) * (n-c) / c
            res.add((int) val);
        }
        return res;
    }

    // III: first n rows. O(n^2) time and space (output size)
    static List<List<Integer>> generate(int n) {
        List<List<Integer>> tri = new ArrayList<>();
        for (int r = 1; r <= n; r++) tri.add(row(r));
        return tri;
    }

    public static void main(String[] args) {
        System.out.println(elementAt(5, 3));   // 6
        System.out.println(elementAt(1, 1));   // 1
        System.out.println(row(5));            // [1, 4, 6, 4, 1]
        System.out.println(row(1));            // [1]
        System.out.println(generate(5));       // [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
    }
}
