import java.util.HashMap;
import java.util.Map;

/** Copy List with Random Pointer (LC 138): deep copy a list where each node also has a `random` pointer */
public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }

    // Approach 1: HashMap (original -> copy). Two passes. O(n) time, O(n) space
    static Node copyRandomListMap(Node head) {
        Map<Node, Node> map = new HashMap<>();

        // pass 1: make a copy of every node
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        // pass 2: set next and random of every copy (map.get(null) is null, so ends are fine)
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    // Approach 2 (optimal): put each copy right after its original, set randoms, then separate. O(n) time, O(1) extra space
    static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 1) A -> A' -> B -> B' -> ...
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // 2) copy.random = original.random.next
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3) separate the two lists
        Node newHead = head.next;
        cur = head;
        while (cur != null) {
            Node copy = cur.next;
            cur.next = copy.next;
            if (copy.next != null) {
                copy.next = copy.next.next;
            }
            cur = cur.next;
        }
        return newHead;
    }

    // Helper: print as val(randomVal)
    static String describe(Node head) {
        if (head == null) {
            return "null";
        }
        String s = "";
        Node cur = head;
        while (cur != null) {
            s = s + cur.val + "(";
            if (cur.random == null) {
                s = s + "null";
            } else {
                s = s + cur.random.val;
            }
            s = s + ")";
            if (cur.next != null) {
                s = s + "->";
            }
            cur = cur.next;
        }
        return s;
    }

    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        b.random = a;
        c.random = e;
        d.random = c;
        e.random = a;

        String before = describe(a);
        Node copy = copyRandomList(a);
        System.out.println(describe(copy));                                  // 7(null)->13(7)->11(1)->10(11)->1(7)
        System.out.println(before.equals(describe(a)));                      // true: the original is restored
        System.out.println(copy != a && copy.next != a.next);                // true: these are NEW nodes
        System.out.println(describe(copyRandomListMap(a)));                  // same structure via the map approach
        System.out.println(describe(copyRandomList(null)));                  // null

        Node one = new Node(5);
        one.random = one;
        Node c1 = copyRandomList(one);
        System.out.println(c1.random == c1 && c1 != one);                    // true (random points to itself)
    }
}
