/** Lower Bound: smallest index i with a[i] >= x (returns n if none) */
public class LowerBound {

    // Template: search the "first index where condition is true". O(log n), O(1)
    static int lowerBound(int[] a, int x) {
        int low = 0, high = a.length;            // high = n: the answer can be "past the end"
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] >= x) high = mid;         // mid could be the answer, keep it
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 5};
        System.out.println(lowerBound(a, 2));    // 1
        System.out.println(lowerBound(a, 4));    // 5
        System.out.println(lowerBound(a, 0));    // 0
        System.out.println(lowerBound(a, 9));    // 6 (n)
        System.out.println(lowerBound(new int[]{}, 3)); // 0
    }
}
