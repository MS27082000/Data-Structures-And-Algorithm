import java.util.ArrayList;
import java.util.List;

/** Intersection of Two Sorted Arrays (keeps duplicates as many times as they occur in both, like LC 350) */
public class IntersectionOfSortedArrays {

    // Two pointers: advance the smaller one, take both on a match. O(n + m) time, O(1) extra space
    static List<Integer> intersection(int[] a, int[] b) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) i++;
            else if (a[i] > b[j]) j++;
            else {
                res.add(a[i]);
                i++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1, 2, 2, 3, 3, 4, 5, 6}, new int[]{2, 3, 3, 5, 6, 6, 7})); // [2, 3, 3, 5, 6]
        System.out.println(intersection(new int[]{1, 2, 3}, new int[]{4, 5}));       // []
        System.out.println(intersection(new int[]{}, new int[]{1}));                 // []
        System.out.println(intersection(new int[]{1, 1, 1}, new int[]{1, 1}));       // [1, 1]
    }
}
