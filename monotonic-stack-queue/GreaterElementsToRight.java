import java.util.Arrays;
import java.util.TreeMap;

/** Number of Greater Elements to the Right: for each query index i, count elements to the right of i that are > arr[i] */
public class GreaterElementsToRight {

    // Brute force per query: O(n) per query, O(q * n) total. Fine for few queries
    static int[] bruteForce(int[] arr, int[] queries) {
        int[] res = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q];
            for (int j = idx + 1; j < arr.length; j++) if (arr[j] > arr[idx]) res[q]++;
        }
        return res;
    }

    // Offline for ALL indices at once: process right to left with a Fenwick tree (BIT) over coordinate-compressed values.
    // count[i] = how many already-inserted (right-side) values are strictly greater than arr[i]. O(n log n) time, O(n) space
    static int[] countAll(int[] arr) {
        int n = arr.length;
        int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();
        int m = sorted.length;
        int[] bit = new int[m + 2];
        int[] count = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int rank = Arrays.binarySearch(sorted, arr[i]) + 1;             // 1-based rank of arr[i]
            int notGreater = query(bit, rank);                               // inserted values with rank <= rank (i.e. <= arr[i])
            int inserted = n - 1 - i;
            count[i] = inserted - notGreater;                                // the rest are strictly greater
            update(bit, rank, m + 1);
        }
        return count;
    }

    private static void update(int[] bit, int i, int size) {
        for (; i <= size; i += i & -i) bit[i]++;
    }

    private static int query(int[] bit, int i) {
        int s = 0;
        for (; i > 0; i -= i & -i) s += bit[i];
        return s;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        System.out.println(Arrays.toString(bruteForce(arr, new int[]{0, 5})));          // [6, 1]
        System.out.println(Arrays.toString(countAll(arr)));                             // [6, 5, 5, 2, 3, 1, 0, 0]
        int[] dup = {5, 5, 5, 1};
        System.out.println(Arrays.toString(countAll(dup)));                             // [0, 0, 0, 0] (equal is not greater)
        int[] check = {9, 1, 8, 2, 7, 3};
        System.out.println(Arrays.equals(countAll(check), bruteForce(check, new int[]{0, 1, 2, 3, 4, 5})));   // true
    }
}
