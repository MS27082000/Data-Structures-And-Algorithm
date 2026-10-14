/** Reverse Pairs (LC 493): pairs (i < j) with nums[i] > 2 * nums[j] */
public class ReversePairs {

    // Merge sort: count the pairs BEFORE merging (both halves are sorted), then merge normally.
    // O(n log n) time, O(n) space
    static int reversePairs(int[] nums) {
        int[] a = nums.clone();
        return sort(a, 0, a.length - 1, new int[a.length]);
    }

    private static int sort(int[] a, int low, int high, int[] tmp) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = sort(a, low, mid, tmp) + sort(a, mid + 1, high, tmp);

        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) a[i] > 2L * a[j]) j++;   // long: 2*a[j] can overflow int
            count += j - (mid + 1);
        }

        int i = low, r = mid + 1, k = low;
        while (i <= mid && r <= high) tmp[k++] = (a[i] <= a[r]) ? a[i++] : a[r++];
        while (i <= mid) tmp[k++] = a[i++];
        while (r <= high) tmp[k++] = a[r++];
        for (k = low; k <= high; k++) a[k] = tmp[k];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));                       // 2
        System.out.println(reversePairs(new int[]{2, 4, 3, 5, 1}));                       // 3
        System.out.println(reversePairs(new int[]{2147483647, 2147483647, 2147483647}));  // 0 (no overflow bug)
        System.out.println(reversePairs(new int[]{-5, -5}));                              // 1
        System.out.println(reversePairs(new int[]{}));                                    // 0
    }
}
