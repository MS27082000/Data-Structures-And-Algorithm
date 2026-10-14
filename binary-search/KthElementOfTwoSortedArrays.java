/** Kth Element of Two Sorted Arrays (k is 1-indexed) */
public class KthElementOfTwoSortedArrays {

    // Same partition idea as the median: take i elements from a and k-i from b so that the left parts are valid.
    // O(log min(m, n)), O(1)
    static int kthElement(int[] a, int[] b, int k) {
        if (a.length > b.length) return kthElement(b, a, k);
        int m = a.length, n = b.length;
        int low = Math.max(0, k - n);                    // must take at least k - n from a
        int high = Math.min(k, m);                       // can take at most min(k, m) from a
        while (low <= high) {
            int i = low + (high - low) / 2;
            int j = k - i;
            int aLeft = (i == 0) ? Integer.MIN_VALUE : a[i - 1];
            int aRight = (i == m) ? Integer.MAX_VALUE : a[i];
            int bLeft = (j == 0) ? Integer.MIN_VALUE : b[j - 1];
            int bRight = (j == n) ? Integer.MAX_VALUE : b[j];
            if (aLeft <= bRight && bLeft <= aRight) return Math.max(aLeft, bLeft);
            else if (aLeft > bRight) high = i - 1;
            else low = i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(kthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5));   // 6
        System.out.println(kthElement(new int[]{100, 112, 256, 349, 770}, new int[]{72, 86, 113, 119, 265, 445, 892}, 7)); // 256
        System.out.println(kthElement(new int[]{1, 2}, new int[]{3, 4}, 1));                   // 1
        System.out.println(kthElement(new int[]{1, 2}, new int[]{3, 4}, 4));                   // 4
        System.out.println(kthElement(new int[]{}, new int[]{5, 6}, 2));                       // 6
    }
}
