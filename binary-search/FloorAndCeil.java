import java.util.Arrays;

/** Floor and Ceil in a Sorted Array: floor = largest <= x, ceil = smallest >= x (-1 if it doesn't exist) */
public class FloorAndCeil {

    // floor = element just before upper bound, ceil = element at lower bound. O(log n), O(1)
    static int[] floorAndCeil(int[] a, int x) {
        int floor = -1, ceil = -1;
        int low = 0, high = a.length - 1;
        while (low <= high) {                       // single loop: record candidates while narrowing
            int mid = low + (high - low) / 2;
            if (a[mid] == x) return new int[]{x, x};
            if (a[mid] < x) {
                floor = a[mid];
                low = mid + 1;
            } else {
                ceil = a[mid];
                high = mid - 1;
            }
        }
        return new int[]{floor, ceil};
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 4, 7, 8, 10};
        System.out.println(Arrays.toString(floorAndCeil(a, 5)));    // [4, 7]
        System.out.println(Arrays.toString(floorAndCeil(a, 8)));    // [8, 8]
        System.out.println(Arrays.toString(floorAndCeil(a, 1)));    // [-1, 3]
        System.out.println(Arrays.toString(floorAndCeil(a, 11)));   // [10, -1]
    }
}
