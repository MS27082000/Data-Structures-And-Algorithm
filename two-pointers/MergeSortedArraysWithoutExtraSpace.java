import java.util.Arrays;

/** Merge Two Sorted Arrays Without Extra Space: after merging, a holds the smallest n, b the largest m (both sorted) */
public class MergeSortedArraysWithoutExtraSpace {

    // Approach 1: two pointers from opposite ends, swap, then sort both. O((n+m) + n log n + m log m), O(1) space
    static void mergeSwapAndSort(long[] a, long[] b) {
        int i = a.length - 1, j = 0;
        while (i >= 0 && j < b.length && a[i] > b[j]) {
            long t = a[i];
            a[i] = b[j];
            b[j] = t;
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    // Approach 2: Shell-sort "gap" method. O((n+m) log(n+m)) time, O(1) space
    static void mergeGap(long[] a, long[] b) {
        int n = a.length, m = b.length, total = n + m;
        int gap = (total + 1) / 2;
        while (gap > 0) {
            int l = 0, r = l + gap;
            while (r < total) {
                if (l < n && r >= n) swapIfGreater(a, l, b, r - n);        // a vs b
                else if (l >= n) swapIfGreater(b, l - n, b, r - n);        // b vs b
                else swapIfGreater(a, l, a, r);                            // a vs a
                l++;
                r++;
            }
            if (gap == 1) break;
            gap = (gap + 1) / 2;
        }
    }

    private static void swapIfGreater(long[] x, int i, long[] y, int j) {
        if (x[i] > y[j]) {
            long t = x[i];
            x[i] = y[j];
            y[j] = t;
        }
    }

    public static void main(String[] args) {
        long[] a = {1, 4, 8, 10}, b = {2, 3, 9};
        mergeSwapAndSort(a, b);
        System.out.println(Arrays.toString(a) + " " + Arrays.toString(b));   // [1, 2, 3, 4] [8, 9, 10]

        long[] c = {1, 3, 5, 7}, d = {0, 2, 6, 8, 9};
        mergeGap(c, d);
        System.out.println(Arrays.toString(c) + " " + Arrays.toString(d));   // [0, 1, 2, 3] [5, 6, 7, 8, 9]

        long[] e = {5, 6}, f = {1, 2};
        mergeGap(e, f);
        System.out.println(Arrays.toString(e) + " " + Arrays.toString(f));   // [1, 2] [5, 6]

        long[] g = {1, 2}, h = {3, 4};
        mergeGap(g, h);
        System.out.println(Arrays.toString(g) + " " + Arrays.toString(h));   // [1, 2] [3, 4]
    }
}
