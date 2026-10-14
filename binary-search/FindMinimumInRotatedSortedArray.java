/** Find Minimum in Rotated Sorted Array (LC 153) - distinct elements */
public class FindMinimumInRotatedSortedArray {

    // Compare mid with high: if a[mid] > a[high] the minimum is to the right, else mid could be the minimum. O(log n), O(1)
    static int findMin(int[] a) {
        int low = 0, high = a.length - 1;
        while (low < high) {                      // note: low < high (not <=)
            int mid = low + (high - low) / 2;
            if (a[mid] > a[high]) low = mid + 1;
            else high = mid;
        }
        return a[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));        // 1
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));  // 0
        System.out.println(findMin(new int[]{11, 13, 15, 17}));       // 11 (not rotated)
        System.out.println(findMin(new int[]{2, 1}));                 // 1
        System.out.println(findMin(new int[]{5}));                    // 5
    }
}
