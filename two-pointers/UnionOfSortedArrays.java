import java.util.ArrayList;
import java.util.List;

/** Union of Two Sorted Arrays (distinct elements, sorted) */
public class UnionOfSortedArrays {

    // Merge-style two pointers, skipping duplicates. O(n + m) time, O(1) extra space (besides output)
    static List<Integer> union(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) add(res, a[i++]);
            else add(res, b[j++]);
        }
        while (i < a.length) add(res, a[i++]);
        while (j < b.length) add(res, b[j++]);
        return res;
    }

    // Add only if different from the last added value (handles duplicates within and across arrays)
    private static void add(List<Integer> res, int x) {
        if (res.isEmpty() || res.get(res.size() - 1) != x) res.add(x);
    }

    public static void main(String[] args) {
        System.out.println(union(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3}));     // [1, 2, 3, 4, 5]
        System.out.println(union(new int[]{2, 2, 3, 4, 5}, new int[]{1, 1, 2, 3, 4})); // [1, 2, 3, 4, 5]
        System.out.println(union(new int[]{}, new int[]{1, 1, 2}));                  // [1, 2]
        System.out.println(union(new int[]{1, 3}, new int[]{2, 4}));                 // [1, 2, 3, 4]
    }
}
