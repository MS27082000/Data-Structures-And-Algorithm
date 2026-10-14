import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** Basic Hashing: frequency counting, count queries, and highest / lowest frequency element */
public class BasicHashing {

    // Number frequency with a HashMap: O(n) build, O(1) per query
    static Map<Integer, Integer> frequency(int[] a) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : a) freq.merge(x, 1, Integer::sum);
        return freq;
    }

    // Character frequency: lowercase letters only -> int[26] array (faster than a map)
    static int[] charFrequency(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        return freq;
    }

    // Element with the highest frequency (smallest value on ties) and the lowest frequency (smallest value on ties)
    static int[] highestAndLowest(int[] a) {
        Map<Integer, Integer> freq = frequency(a);
        int high = -1, low = -1, hf = Integer.MIN_VALUE, lf = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey(), f = e.getValue();
            if (f > hf || (f == hf && val < high)) { hf = f; high = val; }
            if (f < lf || (f == lf && val < low)) { lf = f; low = val; }
        }
        return new int[]{high, low};
    }

    public static void main(String[] args) {
        int[] a = {10, 5, 10, 15, 10, 5};
        Map<Integer, Integer> f = frequency(a);
        System.out.println(f.get(10) + " " + f.get(5) + " " + f.getOrDefault(99, 0));   // 3 2 0
        System.out.println(Arrays.toString(charFrequency("aabbbz")).substring(0, 10));  // [2, 3, 0, 0,
        System.out.println(Arrays.toString(highestAndLowest(a)));                       // [10, 15]
        System.out.println(Arrays.toString(highestAndLowest(new int[]{1, 2, 3})));      // [1, 1]
    }
}
