/** Search Insert Position (LC 35): index of target, or where it would be inserted */
public class SearchInsertPosition {

    // This is exactly lower bound. O(log n), O(1)
    static int searchInsert(int[] a, int target) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        System.out.println(searchInsert(a, 5));   // 2
        System.out.println(searchInsert(a, 2));   // 1
        System.out.println(searchInsert(a, 7));   // 4
        System.out.println(searchInsert(a, 0));   // 0
        System.out.println(searchInsert(new int[]{}, 1)); // 0
    }
}
