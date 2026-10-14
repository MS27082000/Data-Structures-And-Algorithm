/** Nth Root of a Number: integer r with r^n == m, or -1 if there is none */
public class NthRoot {

    // Binary search r in [1, m]; compute r^n with an early exit as soon as it exceeds m (prevents overflow).
    // O(log m * n), O(1)
    static int nthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = compare(mid, n, m);
            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // returns -1 if mid^n < m, 0 if == m, 1 if > m
    private static int compare(int mid, int n, int m) {
        long p = 1;
        for (int i = 0; i < n; i++) {
            p *= mid;
            if (p > m) return 1;
        }
        return p == m ? 0 : -1;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(3, 27));     // 3
        System.out.println(nthRoot(4, 69));     // -1
        System.out.println(nthRoot(2, 1));      // 1
        System.out.println(nthRoot(1, 9));      // 9
        System.out.println(nthRoot(5, 32));     // 2
    }
}
