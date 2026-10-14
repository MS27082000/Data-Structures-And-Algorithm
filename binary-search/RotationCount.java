/** Find out how many times a sorted array has been rotated (distinct elements) = index of the minimum */
public class RotationCount {

    // O(log n), O(1)
    static int countRotations(int[] a) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > a[high]) low = mid + 1;
            else high = mid;
        }
        return low;                               // index of the minimum
    }

    public static void main(String[] args) {
        System.out.println(countRotations(new int[]{4, 5, 6, 7, 0, 1, 2, 3}));  // 4
        System.out.println(countRotations(new int[]{3, 4, 5, 1, 2}));           // 3
        System.out.println(countRotations(new int[]{1, 2, 3}));                 // 0
        System.out.println(countRotations(new int[]{2, 1}));                    // 1
        System.out.println(countRotations(new int[]{7}));                       // 0
    }
}
