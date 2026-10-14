/** Find Peak Element (LC 162): return the index of ANY element greater than its neighbours (a[-1] = a[n] = -infinity) */
public class FindPeakElement {

    // Follow the upward slope: if a[mid] < a[mid+1] a peak exists on the right, else on the left (including mid).
    // O(log n), O(1). Works even with several peaks.
    static int findPeakElement(int[] a) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < a[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));            // 2
        int p = findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4});
        System.out.println(p == 1 || p == 5);                                  // true (either peak is valid)
        System.out.println(findPeakElement(new int[]{1}));                     // 0
        System.out.println(findPeakElement(new int[]{1, 2}));                  // 1
        System.out.println(findPeakElement(new int[]{3, 2, 1}));               // 0
    }
}
