/** Search X in a Sorted Array (LC 704) - classic binary search */
public class BinarySearchBasic {

    // O(log n) time, O(1) space (iterative)
    static int search(int[] a, int target) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;       // avoids overflow of (low + high)
            if (a[mid] == target) return mid;
            if (a[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Recursive version (O(log n) stack)
    static int searchRec(int[] a, int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (a[mid] == target) return mid;
        return a[mid] < target ? searchRec(a, mid + 1, high, target) : searchRec(a, low, mid - 1, target);
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 12};
        System.out.println(search(a, 9));                       // 4
        System.out.println(search(a, 2));                       // -1
        System.out.println(search(new int[]{5}, 5));            // 0
        System.out.println(search(new int[]{}, 5));             // -1
        System.out.println(searchRec(a, 0, a.length - 1, -1));  // 0
    }
}
