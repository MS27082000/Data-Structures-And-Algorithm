/** Longest Bitonic Subsequence: strictly increasing then strictly decreasing (either part may be a single element, as in an all-increasing array) */
public class LongestBitonicSubsequence {

    // inc[i] = LIS ending at i (left to right). dec[i] = longest decreasing subsequence STARTING at i (= LIS ending at i from the right).
    // Peak at i gives inc[i] + dec[i] - 1 (the peak is counted twice). O(n^2) time, O(n) space
    static int longestBitonic(int[] a) {
        int n = a.length;
        if (n == 0) return 0;
        int[] inc = new int[n], dec = new int[n];
        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) if (a[j] < a[i]) inc[i] = Math.max(inc[i], inc[j] + 1);
        }
        for (int i = n - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = n - 1; j > i; j--) if (a[j] < a[i]) dec[i] = Math.max(dec[i], dec[j] + 1);
        }
        int best = 0;
        for (int i = 0; i < n; i++) best = Math.max(best, inc[i] + dec[i] - 1);
        return best;
    }

    public static void main(String[] args) {
        System.out.println(longestBitonic(new int[]{1, 11, 2, 10, 4, 5, 2, 1}));      // 6  (1, 2, 10, 4, 2, 1)
        System.out.println(longestBitonic(new int[]{12, 11, 40, 5, 3, 1}));           // 5  (12, 40, 5, 3, 1)
        System.out.println(longestBitonic(new int[]{80, 60, 30, 40, 20, 10}));        // 5  (80, 60, 30, 20, 10)
        System.out.println(longestBitonic(new int[]{1, 2, 3, 4}));                    // 4  (only the increasing part)
        System.out.println(longestBitonic(new int[]{5}));                             // 1
        System.out.println(longestBitonic(new int[]{3, 3, 3}));                       // 1
    }
}
