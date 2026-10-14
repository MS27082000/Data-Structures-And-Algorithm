import java.util.HashMap;
import java.util.Map;

/** Second highest occurring element: the element with the second largest DISTINCT frequency (-1 if there is only one distinct frequency) */
public class SecondHighestOccurringElement {

    // Count frequencies, then find the highest and the next distinct lower frequency. For ties on that frequency return the smaller value.
    // O(n) time, O(n) space
    static int secondHighest(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.merge(x, 1, Integer::sum);
        int first = 0, second = 0;
        for (int f : freq.values()) {
            if (f > first) { second = first; first = f; }
            else if (f > second && f < first) second = f;
        }
        if (second == 0) return -1;
        int ans = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) if (e.getValue() == second) ans = Math.min(ans, e.getKey());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{1, 1, 1, 2, 2, 3}));      // 2  (frequencies 3, 2, 1)
        System.out.println(secondHighest(new int[]{5, 5, 6, 6}));            // -1 (only one distinct frequency)
        System.out.println(secondHighest(new int[]{4}));                     // -1
        System.out.println(secondHighest(new int[]{1, 1, 1, 1, 2, 3, 3}));   // 3  (frequencies 4, 2, 1)
        System.out.println(secondHighest(new int[]{9, 9, 9, 8, 8, 7, 7}));   // 7  (tie on frequency 2: smaller is 7)
    }
}
