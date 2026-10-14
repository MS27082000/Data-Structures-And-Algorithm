import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Leaders in an Array: element is a leader if it is strictly greater than everything to its right */
public class LeadersInArray {

    // Scan from the right keeping the max so far. O(n) time, O(1) extra space (besides the answer)
    static List<Integer> leaders(int[] a) {
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] > max) {
                res.add(a[i]);
                max = a[i];
            }
        }
        Collections.reverse(res);   // restore left-to-right order
        return res;
    }

    public static void main(String[] args) {
        System.out.println(leaders(new int[]{16, 17, 4, 3, 5, 2}));   // [17, 5, 2]
        System.out.println(leaders(new int[]{1, 2, 3, 4}));           // [4]
        System.out.println(leaders(new int[]{5, 4, 3, 2}));           // [5, 4, 3, 2]
        System.out.println(leaders(new int[]{7, 7, 7}));              // [7]
    }
}
