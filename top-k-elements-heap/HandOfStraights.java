import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/** Hand of Straights (LC 846): can the cards be split into groups of `groupSize` consecutive values? */
public class HandOfStraights {

    // Always start a group from the SMALLEST remaining card (it can only be the start of a group). A TreeMap of counts keeps
    // the cards sorted. O(n log n) time, O(n) space
    static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int c : hand) count.merge(c, 1, Integer::sum);
        while (!count.isEmpty()) {
            int start = count.firstKey();
            for (int v = start; v < start + groupSize; v++) {
                Integer have = count.get(v);
                if (have == null) return false;                   // the next consecutive card is missing
                if (have == 1) count.remove(v);
                else count.put(v, have - 1);
            }
        }
        return true;
    }

    // Min-heap flavour: the heap yields the smallest remaining value; a HashMap holds the remaining counts. When the smallest
    // value still has copies left it starts a group, which consumes one copy of each of the next groupSize - 1 values.
    // O(n log n) time, O(n) space
    static boolean isNStraightHandHeap(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> count = new HashMap<>();
        for (int c : hand) count.merge(c, 1, Integer::sum);
        PriorityQueue<Integer> heap = new PriorityQueue<>(count.keySet());      // distinct values only
        while (!heap.isEmpty()) {
            int start = heap.peek();
            if (count.get(start) == 0) {                          // all copies of this value are already used up
                heap.poll();
                continue;
            }
            for (int v = start; v < start + groupSize; v++) {
                if (count.getOrDefault(v, 0) == 0) return false;  // missing or exhausted card
                count.put(v, count.get(v) - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));    // true  ([1,2,3] [2,3,4] [6,7,8])
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4));                // false (5 cards cannot form groups of 4)
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 2));             // true
        System.out.println(isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 3));             // true
        System.out.println(isNStraightHand(new int[]{1, 2, 4}, 3));                      // false (3 is missing)
        System.out.println(isNStraightHand(new int[]{5}, 1));                            // true
        System.out.println(isNStraightHandHeap(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));// true
        System.out.println(isNStraightHandHeap(new int[]{1, 2, 3, 4, 5, 6}, 2));         // true
        System.out.println(isNStraightHandHeap(new int[]{1, 2, 4}, 3));                  // false
        System.out.println(isNStraightHandHeap(new int[]{1, 1, 2, 3}, 2));               // false ([1,2] then 1,3 cannot pair)
    }
}
