import java.util.HashMap;
import java.util.Map;

/** Fruit Into Baskets (LC 904): longest subarray with at most TWO distinct values */
public class FruitIntoBaskets {

    // Window with a frequency map; shrink while it holds more than 2 distinct fruit types. O(n) time, O(1) space (<= 3 keys)
    static int totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<>();
        int left = 0, best = 0;
        for (int right = 0; right < fruits.length; right++) {
            count.merge(fruits[right], 1, Integer::sum);
            while (count.size() > 2) {
                int f = fruits[left++];
                if (count.merge(f, -1, Integer::sum) == 0) count.remove(f);   // remove the key at 0 so size() is accurate
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));                          // 3
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));                       // 3
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));                    // 4
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));  // 5
        System.out.println(totalFruit(new int[]{5}));                                // 1
        System.out.println(totalFruit(new int[]{}));                                 // 0
    }
}
