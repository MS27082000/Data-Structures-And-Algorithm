/** Count Inversions: pairs (i < j) with a[i] > a[j] */
public class CountInversions {

    // Merge sort; while merging, if right element is smaller, it forms inversions with ALL remaining left elements.
    // O(n log n) time, O(n) space. Count is a long (up to n(n-1)/2)
    static long countInversions(int[] a) {
        int[] copy = a.clone();                         // keep the caller's array unchanged
        return sort(copy, 0, copy.length - 1, new int[copy.length]);
    }

    private static long sort(int[] a, int low, int high, int[] tmp) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        long count = sort(a, low, mid, tmp) + sort(a, mid + 1, high, tmp);
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (a[i] <= a[j]) tmp[k++] = a[i++];
            else {
                count += mid - i + 1;                   // a[i..mid] are all > a[j]
                tmp[k++] = a[j++];
            }
        }
        while (i <= mid) tmp[k++] = a[i++];
        while (j <= high) tmp[k++] = a[j++];
        for (k = low; k <= high; k++) a[k] = tmp[k];
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countInversions(new int[]{5, 3, 2, 4, 1}));   // 8
        System.out.println(countInversions(new int[]{1, 2, 3, 4, 5}));   // 0
        System.out.println(countInversions(new int[]{5, 4, 3, 2, 1}));   // 10
        System.out.println(countInversions(new int[]{2, 2, 2}));         // 0 (equal is not an inversion)
        System.out.println(countInversions(new int[]{}));                // 0
    }
}
