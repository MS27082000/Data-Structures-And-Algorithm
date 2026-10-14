/** Delete All Occurrences of a Key in a Doubly Linked List */
public class DeleteAllOccurrencesDLL {

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

    // One pass; unlink every node holding key (prev pointers make this O(1) per deletion). O(n) time, O(1) space
    static Node deleteAllOccurrences(Node head, int key) {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;                        // save before we unlink
            if (cur.val == key) {
                if (cur.prev != null) cur.prev.next = cur.next;
                else head = cur.next;                    // deleting the head: move the head forward
                if (cur.next != null) cur.next.prev = cur.prev;
            }
            cur = next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node a = deleteAllOccurrences(build(2, 2, 10, 8, 4, 2, 5, 2), 2);
        System.out.println(forward(a) + " | " + backward(a));          // 10<->8<->4<->5 | 5<->4<->8<->10
        Node b = deleteAllOccurrences(build(1, 2, 3), 9);
        System.out.println(forward(b));                                // 1<->2<->3 (key absent)
        System.out.println(forward(deleteAllOccurrences(build(7, 7, 7), 7)));   // null
        Node c = deleteAllOccurrences(build(1, 2, 1), 1);
        System.out.println(forward(c) + " | " + backward(c));          // 2 | 2
        System.out.println(forward(deleteAllOccurrences(null, 1)));    // null
    }
}
