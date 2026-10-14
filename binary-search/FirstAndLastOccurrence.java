import java.util.Arrays;

/** Find First and Last Position of Element in Sorted Array (LC 34) */
public class FirstAndLastOccurrence {

    // first = lowerBound(x) if a[first] == x; last = upperBound(x) - 1. Two O(log n) searches, O(1) space
    static int[] searchRange(int[] a, int x) {
        int first = lowerBound(a, x);
        if (first == a.length || a[first] != x) return new int[]{-1, -1};
        int last = upperBound(a, x) - 1;
        return new int[]{first, last};
    }

    private static int lowerBound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= x) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static int upperBound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > x) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));  // [3, 4]
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));  // [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));                   // [-1, -1]
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));               // [0, 1]
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));                  // [0, 0]
    }
}
