/** Search in Rotated Sorted Array (LC 33) - distinct elements */
public class SearchRotatedSortedArrayI {

    // At every step ONE half is sorted. Check if the target lies in the sorted half; otherwise go to the other. O(log n), O(1)
    static int search(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) return mid;
            if (a[low] <= a[mid]) {                          // left half sorted
                if (a[low] <= target && target < a[mid]) high = mid - 1;
                else low = mid + 1;
            } else {                                         // right half sorted
                if (a[mid] < target && target <= a[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));   // 4
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));   // -1
        System.out.println(search(new int[]{1}, 1));                     // 0
        System.out.println(search(new int[]{3, 1}, 1));                  // 1
        System.out.println(search(new int[]{1, 2, 3}, 3));               // 2 (not rotated)
    }
}
