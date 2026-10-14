import java.util.HashMap;
import java.util.Map;

/** Copy List with Random Pointer (LC 138): deep copy a list where each node also has a `random` pointer */
public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next, random;
        Node(int v) { val = v; }
    }

    // Approach 1: HashMap original -> copy. Two passes. O(n) time, O(n) space
    static Node copyRandomListMap(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) map.put(cur, new Node(cur.val));
        for (Node cur = head; cur != null; cur = cur.next) {
            map.get(cur).next = map.get(cur.next);              // map.get(null) is null: handles the ends
            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }

    // Approach 2 (optimal): interleave copies, set randoms, then separate. O(n) time, O(1) extra space
    static Node copyRandomList(Node head) {
        if (head == null) return null;
        for (Node cur = head; cur != null; cur = cur.next.next) {       // 1) A -> A' -> B -> B' ...
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {       // 2) copy.random = original.random.next
            if (cur.random != null) cur.next.random = cur.random.next;
        }
        Node newHead = head.next;
        for (Node cur = head; cur != null; cur = cur.next) {            // 3) split the two lists back apart
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
        }
        return newHead;
    }

    // Helper: describe a list as val(randomVal) so we can compare structure
    static String describe(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.val).append('(').append(cur.random == null ? "null" : cur.random.val).append(')');
            if (cur.next != null) sb.append("->");
        }
        return sb.length() == 0 ? "null" : sb.toString();
    }

    public static void main(String[] args) {
        Node a = new Node(7), b = new Node(13), c = new Node(11), d = new Node(10), e = new Node(1);
        a.next = b; b.next = c; c.next = d; d.next = e;
        b.random = a; c.random = e; d.random = c; e.random = a;
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
        System.out.println(c1.random == c1 && c1 != one);                    // true (self random pointer)
    }
}
