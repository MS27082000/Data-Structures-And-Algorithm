import java.util.ArrayList;
import java.util.List;

/**
 * Union of Two Sorted Arrays: all DISTINCT elements of both arrays, in sorted order.
 *
 * Approach (merge, like merge sort):
 *   - Keep one pointer in each array: i in a, j in b.
 *   - Compare a[i] and b[j]; take the smaller one and move its pointer. If they are equal, take it once and move both.
 *   - Before adding any value to the result, check it is different from the LAST value added.
 *     This removes duplicates inside one array and across both arrays.
 *   - When one array finishes, add the remaining elements of the other (with the same check).
 *
 * Time O(n + m), extra space O(1) (besides the output).
 */
public class UnionOfSortedArrays {

    static List<Integer> union(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                addIfNew(result, a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                addIfNew(result, a[i]);
                i++;
            } else {
                addIfNew(result, b[j]);
                j++;
            }
        }

        // leftovers: only one of these two loops will run
        while (i < a.length) {
            addIfNew(result, a[i]);
            i++;
        }
        while (j < b.length) {
            addIfNew(result, b[j]);
            j++;
        }
        return result;
    }

    // Add value only if the result is empty or the last added value is different.
    private static void addIfNew(List<Integer> result, int value) {
        if (result.isEmpty() || result.get(result.size() - 1) != value) {
            result.add(value);
        }
    }

    public static void main(String[] args) {
        System.out.println(union(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3}));       // [1, 2, 3, 4, 5]
        System.out.println(union(new int[]{2, 2, 3, 4, 5}, new int[]{1, 1, 2, 3, 4})); // [1, 2, 3, 4, 5]
        System.out.println(union(new int[]{}, new int[]{1, 1, 2}));                    // [1, 2]
        System.out.println(union(new int[]{1, 3}, new int[]{2, 4}));                   // [1, 2, 3, 4]
    }
}
