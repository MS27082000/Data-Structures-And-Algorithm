/** Median of Two Sorted Arrays (LC 4) in O(log(min(m, n))) */
public class MedianOfTwoSortedArrays {

    // Binary search the partition of the SMALLER array. A valid partition has
    // maxLeft(a) <= minRight(b) and maxLeft(b) <= minRight(a). O(log min(m,n)), O(1)
    static double findMedian(int[] a, int[] b) {
        if (a.length > b.length) return findMedian(b, a);        // binary search on the smaller array
        int m = a.length, n = b.length;
        int half = (m + n + 1) / 2;                              // size of the combined left part
        int low = 0, high = m;
        while (low <= high) {
            int i = low + (high - low) / 2;                      // elements taken from a
            int j = half - i;                                    // elements taken from b
            int aLeft = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int aRight = (i == m) ? Integer.MAX_VALUE : a[i];
            int bLeft = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int bRight = (j == n) ? Integer.MAX_VALUE : b[j];
            if (aLeft <= bRight && bLeft <= aRight) {
                if (((m + n) & 1) == 1) return Math.max(aLeft, bLeft);
                return (Math.max(aLeft, bLeft) + (double) Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                high = i - 1;                                    // took too many from a
            } else {
                low = i + 1;                                     // took too few from a
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{1, 3}, new int[]{2}));                 // 2.0
        System.out.println(findMedian(new int[]{1, 2}, new int[]{3, 4}));              // 2.5
        System.out.println(findMedian(new int[]{}, new int[]{1}));                     // 1.0
        System.out.println(findMedian(new int[]{0, 0}, new int[]{0, 0}));              // 0.0
        System.out.println(findMedian(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7}));     // 4.0
        System.out.println(findMedian(new int[]{2147483647}, new int[]{2147483647}));  // 2.147483647E9
    }
}
