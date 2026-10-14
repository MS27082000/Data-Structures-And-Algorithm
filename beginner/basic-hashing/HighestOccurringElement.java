import java.util.HashMap;
import java.util.Map;

/** Highest occurring (most frequent) element in an array; ties go to the SMALLER element (the usual convention on the sheet) */
public class HighestOccurringElement {

    // Count with a HashMap, then pick the max frequency (smaller value on a tie). O(n) time, O(n) space
    static int highestFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.merge(x, 1, Integer::sum);
        int best = arr[0], bestCount = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() > bestCount || (e.getValue() == bestCount && e.getKey() < best)) {
                best = e.getKey();
                bestCount = e.getValue();
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(highestFrequency(new int[]{1, 2, 2, 3, 3, 3}));       // 3
        System.out.println(highestFrequency(new int[]{4, 4, 5, 5}));             // 4  (tie: the smaller)
        System.out.println(highestFrequency(new int[]{7}));                      // 7
        System.out.println(highestFrequency(new int[]{-1, -1, 2}));              // -1
        System.out.println(highestFrequency(new int[]{1, 2, 3}));                // 1  (all tie)
    }
}
