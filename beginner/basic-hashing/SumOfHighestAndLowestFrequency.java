import java.util.HashMap;
import java.util.Map;

/** Sum of the highest and the lowest frequency in an array */
public class SumOfHighestAndLowestFrequency {

    // Count frequencies, then take the max and min of the counts and add them. O(n) time, O(n) space
    static int sumHighLow(int[] arr) {
        if (arr.length == 0) return 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) freq.merge(x, 1, Integer::sum);
        int max = 0, min = Integer.MAX_VALUE;
        for (int f : freq.values()) {
            max = Math.max(max, f);
            min = Math.min(min, f);
        }
        return max + min;
    }

    public static void main(String[] args) {
        System.out.println(sumHighLow(new int[]{1, 2, 2, 3, 3, 3}));      // 4   (3 + 1)
        System.out.println(sumHighLow(new int[]{5, 5, 5}));               // 6   (3 + 3: a single distinct value counts twice)
        System.out.println(sumHighLow(new int[]{1, 2, 3}));               // 2
        System.out.println(sumHighLow(new int[]{4}));                     // 2
        System.out.println(sumHighLow(new int[]{}));                      // 0
    }
}
