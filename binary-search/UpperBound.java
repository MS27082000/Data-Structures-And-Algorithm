/** Upper Bound: smallest index i with a[i] > x (returns n if none) */
public class UpperBound {

    // Same template as lower bound, strict comparison. O(log n), O(1)
    static int upperBound(int[] a, int x) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > x) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 5};
        System.out.println(upperBound(a, 2));    // 3
        System.out.println(upperBound(a, 3));    // 5
        System.out.println(upperBound(a, 5));    // 6 (n)
        System.out.println(upperBound(a, 0));    // 0
        System.out.println(upperBound(new int[]{}, 3)); // 0
    }
}
