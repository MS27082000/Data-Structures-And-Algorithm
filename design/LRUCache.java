import java.util.HashMap;
import java.util.Map;

/** LRU Cache (LC 146): get and put in O(1); evict the LEAST recently used key when full.
 *  HashMap (key -> node) for O(1) lookup + doubly linked list (most recent at the head) for O(1) reordering. */
public class LRUCache {

    private static class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0), tail = new Node(0, 0);     // dummy sentinels remove all edge cases

    LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    int get(int key) {
        Node n = map.get(key);
        if (n == null) return -1;
        remove(n);
        addFront(n);                           // using a key makes it the most recently used
        return n.value;
    }

    void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.value = value;
            remove(n);
            addFront(n);
            return;
        }
        if (map.size() == capacity) {
            Node lru = tail.prev;              // the node just before the tail sentinel is the least recently used
            remove(lru);
            map.remove(lru.key);               // that is why each node stores its key
        }
        n = new Node(key, value);
        map.put(key, n);
        addFront(n);
    }

    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addFront(Node n) {
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));    // 1
        c.put(3, 3);                     // evicts key 2
        System.out.println(c.get(2));    // -1
        c.put(4, 4);                     // evicts key 1
        System.out.println(c.get(1));    // -1
        System.out.println(c.get(3));    // 3
        System.out.println(c.get(4));    // 4
        c.put(3, 30);                    // update an existing key (no eviction)
        System.out.println(c.get(3));    // 30
        LRUCache one = new LRUCache(1);
        one.put(1, 1);
        one.put(2, 2);
        System.out.println(one.get(1) + " " + one.get(2));   // -1 2
    }
}
