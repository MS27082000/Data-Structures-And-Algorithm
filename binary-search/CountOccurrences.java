/** Count Occurrences of x in a Sorted Array */
public class CountOccurrences {

    // count = upperBound(x) - lowerBound(x). O(log n), O(1)
    static int count(int[] a, int x) {
        return upperBound(a, x) - lowerBound(a, x);
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
        int[] a = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(count(a, 2));    // 4
        System.out.println(count(a, 4));    // 0
        System.out.println(count(a, 1));    // 2
        System.out.println(count(new int[]{}, 1)); // 0
        System.out.println(count(new int[]{5, 5, 5}, 5)); // 3
    }
}
