import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/** LFU Cache (LC 460): get and put in O(1); evict the LEAST FREQUENTLY used key (ties: the least recently used among them) */
public class LFUCache {

    private final int capacity;
    private int minFreq = 0;
    private final Map<Integer, Integer> values = new HashMap<>();                    // key -> value
    private final Map<Integer, Integer> freq = new HashMap<>();                      // key -> use count
    private final Map<Integer, LinkedHashSet<Integer>> buckets = new HashMap<>();    // use count -> keys in LRU order (oldest first)

    LFUCache(int capacity) {
        this.capacity = capacity;
    }

    int get(int key) {
        if (!values.containsKey(key)) return -1;
        touch(key);
        return values.get(key);
    }

    void put(int key, int value) {
        if (capacity == 0) return;
        if (values.containsKey(key)) {
            values.put(key, value);
            touch(key);
            return;
        }
        if (values.size() == capacity) {
            LinkedHashSet<Integer> lowest = buckets.get(minFreq);
            int evict = lowest.iterator().next();           // oldest key among the least frequently used
            lowest.remove(evict);
            if (lowest.isEmpty()) buckets.remove(minFreq);
            values.remove(evict);
            freq.remove(evict);
        }
        values.put(key, value);
        freq.put(key, 1);
        buckets.computeIfAbsent(1, f -> new LinkedHashSet<>()).add(key);
        minFreq = 1;                                         // a brand-new key always has the lowest frequency
    }

    // Move key from bucket f to bucket f + 1 (it was just used)
    private void touch(int key) {
        int f = freq.get(key);
        LinkedHashSet<Integer> set = buckets.get(f);
        set.remove(key);
        if (set.isEmpty()) {
            buckets.remove(f);
            if (minFreq == f) minFreq++;                     // the lowest bucket emptied: the min moves up
        }
        freq.put(key, f + 1);
        buckets.computeIfAbsent(f + 1, x -> new LinkedHashSet<>()).add(key);
    }

    public static void main(String[] args) {
        LFUCache c = new LFUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));    // 1      (key 1 now used twice)
        c.put(3, 3);                     // evicts key 2 (used once)
        System.out.println(c.get(2));    // -1
        System.out.println(c.get(3));    // 3      (key 3 now used twice)
        c.put(4, 4);                     // keys 1 and 3 tie at freq 2: evicts the older one, key 1
        System.out.println(c.get(1));    // -1
        System.out.println(c.get(3));    // 3
        System.out.println(c.get(4));    // 4
        LFUCache zero = new LFUCache(0);
        zero.put(1, 1);
        System.out.println(zero.get(1)); // -1
    }
}
