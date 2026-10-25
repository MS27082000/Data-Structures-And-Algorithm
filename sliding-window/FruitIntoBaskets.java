import java.util.HashMap;
import java.util.Map;

/**
 * Fruit Into Baskets (LC 904).
 *
 * Two baskets, one fruit type each. Starting anywhere, pick one fruit per tree moving right, and stop when a tree's
 * fruit doesn't fit. Rephrased: the LONGEST SUBARRAY WITH AT MOST 2 DISTINCT VALUES.
 *
 *   State to track      : map of fruit type -> count inside the window
 *   Window is invalid   : map.size() > 2   (more than 2 types)
 *   When left leaves    : decrease its count, and REMOVE the key when the count reaches 0
 *
 * Order inside the loop: add -> shrink while invalid -> update answer.
 *
 * Time O(n), space O(1) (the map never holds more than 3 keys).
 */
public class FruitIntoBaskets {

    static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int k = 2;                                   // number of baskets = max distinct types allowed

        for (int right = 0; right < fruits.length; right++) {
            // 1. add the new fruit to the window
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // 2. too many types: shrink from the left
            while (map.size() > k) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);        // remove the key at 0, or size() overcounts
                }
                left++;
            }

            // 3. the window is valid here, so update the answer
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));                          // 3
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));                       // 3
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));                    // 4
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));  // 5
        System.out.println(totalFruit(new int[]{1, 2, 3}));                          // 2
        System.out.println(totalFruit(new int[]{5}));                                // 1
        System.out.println(totalFruit(new int[]{}));                                 // 0
    }
}
