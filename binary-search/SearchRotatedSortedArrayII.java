/** Search in Rotated Sorted Array II (LC 81) - duplicates allowed, return true/false */
public class SearchRotatedSortedArrayII {

    // Same as I, but when a[low] == a[mid] == a[high] we can't tell which half is sorted: shrink both ends.
    // O(log n) average, O(n) worst case (e.g. all equal), O(1) space
    static boolean search(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) return true;
            if (a[low] == a[mid] && a[mid] == a[high]) {     // ambiguous: trim duplicates
                low++;
                high--;
            } else if (a[low] <= a[mid]) {                   // left half sorted
                if (a[low] <= target && target < a[mid]) high = mid - 1;
                else low = mid + 1;
            } else {                                         // right half sorted
                if (a[mid] < target && target <= a[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));    // true
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));    // false
        System.out.println(search(new int[]{1, 0, 1, 1, 1}, 0));          // true
        System.out.println(search(new int[]{1, 1, 1, 1, 1}, 2));          // false
        System.out.println(search(new int[]{3, 1, 1}, 3));                // true
    }
}
