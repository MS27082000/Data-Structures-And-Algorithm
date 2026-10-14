/** Remove Duplicates from a Sorted Doubly Linked List: keep one node of each value */
public class RemoveDuplicatesSortedDLL {

    static class Node {
        int val;
        Node prev, next;
        Node(int v) { val = v; }
    }

    static Node build(int... a) {
        Node dummy = new Node(0), tail = dummy;
        for (int x : a) {
            Node n = new Node(x);
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        if (dummy.next != null) dummy.next.prev = null;
        return dummy.next;
    }

    static String forward(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node t = head; t != null; t = t.next) sb.append(t.val).append(t.next != null ? "<->" : "");
        return sb.length() == 0 ? "null" : sb.toString();
    }

    static String backward(Node head) {
        if (head == null) return "null";
        Node t = head;
        while (t.next != null) t = t.next;
        StringBuilder sb = new StringBuilder();
        for (; t != null; t = t.prev) sb.append(t.val).append(t.prev != null ? "<->" : "");
        return sb.toString();
    }

    // Equal values are adjacent, so while the next node has the same value, unlink it. The head never changes.
    // O(n) time, O(1) space
    static Node removeDuplicates(Node head) {
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                Node dup = cur.next;
                cur.next = dup.next;
                if (dup.next != null) dup.next.prev = cur;     // fix the back pointer too
            } else {
                cur = cur.next;                                 // advance only when no duplicate was removed
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node a = removeDuplicates(build(1, 1, 1, 2, 3, 3, 4));
        System.out.println(forward(a) + " | " + backward(a));      // 1<->2<->3<->4 | 4<->3<->2<->1
        System.out.println(forward(removeDuplicates(build(1, 2, 3))));      // 1<->2<->3
        System.out.println(forward(removeDuplicates(build(5, 5, 5, 5))));   // 5
        Node b = removeDuplicates(build(1, 1, 2, 2));
        System.out.println(forward(b) + " | " + backward(b));      // 1<->2 | 2<->1
        System.out.println(forward(removeDuplicates(null)));       // null
    }
}
