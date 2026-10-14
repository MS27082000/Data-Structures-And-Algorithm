/** Doubly Linked List fundamentals: introduction, array to DLL, every insert / delete variant, remove a given node, reverse.
 *  Positions are 1-indexed. Methods return the (possibly new) head. */
public class DoublyLinkedListBasics {

    static class Node {
        int val;
        Node prev, next;
        Node(int v) { val = v; }
    }

    // ---- Introduction / Convert array to DLL. O(n) ----
    static Node arrayToDLL(int... a) {
        if (a.length == 0) return null;
        Node head = new Node(a[0]), cur = head;
        for (int i = 1; i < a.length; i++) {
            Node n = new Node(a[i]);
            cur.next = n;
            n.prev = cur;
            cur = n;
        }
        return head;
    }

    // forward and backward views let us verify BOTH prev and next pointers
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

    // ---- Deletion ----
    static Node deleteHead(Node head) {                      // O(1)
        if (head == null || head.next == null) return null;
        Node newHead = head.next;
        newHead.prev = null;
        head.next = null;
        return newHead;
    }

    static Node deleteTail(Node head) {                      // O(n) (O(1) if a tail pointer is kept)
        if (head == null || head.next == null) return null;
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        tail.prev.next = null;
        tail.prev = null;
        return head;
    }

    static Node deleteKth(Node head, int k) {                // O(k)
        if (head == null || k < 1) return head;
        Node t = head;
        for (int i = 1; i < k && t != null; i++) t = t.next;
        if (t == null) return head;                          // k out of range
        return removeNode(head, t);
    }

    // Remove a GIVEN node (we are handed a pointer to it, so no search is needed). O(1)
    static Node removeNode(Node head, Node node) {
        if (node.prev == null) return deleteHead(head);      // node is the head
        node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;   // node is not the tail
        node.prev = node.next = null;
        return head;
    }

    // ---- Insertion ----
    static Node insertBeforeHead(Node head, int val) {       // O(1)
        Node n = new Node(val);
        n.next = head;
        if (head != null) head.prev = n;
        return n;
    }

    static Node insertBeforeTail(Node head, int val) {       // new node goes right before the last node. O(n)
        if (head == null) return new Node(val);
        if (head.next == null) return insertBeforeHead(head, val);
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        insertBefore(tail, val);
        return head;
    }

    static Node insertBeforeKth(Node head, int k, int val) { // new node becomes the k-th. O(k)
        if (k == 1) return insertBeforeHead(head, val);
        Node t = head;
        for (int i = 1; i < k && t != null; i++) t = t.next;
        if (t == null) return head;
        insertBefore(t, val);
        return head;
    }

    // Insert before a GIVEN node (never the head: use insertBeforeHead for that). O(1)
    static void insertBefore(Node node, int val) {
        Node n = new Node(val);
        n.prev = node.prev;
        n.next = node;
        if (node.prev != null) node.prev.next = n;
        node.prev = n;
    }

    // ---- Reverse a DLL: swap prev and next of every node. O(n) time, O(1) space ----
    static Node reverse(Node head) {
        Node cur = head, newHead = head;
        while (cur != null) {
            Node tmp = cur.prev;
            cur.prev = cur.next;
            cur.next = tmp;
            newHead = cur;                                   // the last node visited becomes the head
            cur = cur.prev;                                  // old next (we just swapped the pointers)
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node h = arrayToDLL(1, 2, 3, 4);
        System.out.println(forward(h) + " | " + backward(h));                       // 1<->2<->3<->4 | 4<->3<->2<->1

        System.out.println(forward(deleteHead(arrayToDLL(1, 2, 3))));               // 2<->3
        System.out.println(forward(deleteTail(arrayToDLL(1, 2, 3))));               // 1<->2
        Node d = deleteKth(arrayToDLL(1, 2, 3, 4), 3);
        System.out.println(forward(d) + " | " + backward(d));                       // 1<->2<->4 | 4<->2<->1
        System.out.println(forward(deleteKth(arrayToDLL(1, 2, 3), 1)));             // 2<->3
        System.out.println(forward(deleteKth(arrayToDLL(1, 2, 3), 3)));             // 1<->2
        Node g = arrayToDLL(1, 2, 3);
        g = removeNode(g, g.next);                                                  // remove the node holding 2
        System.out.println(forward(g) + " | " + backward(g));                       // 1<->3 | 3<->1

        System.out.println(forward(insertBeforeHead(arrayToDLL(2, 3), 1)));         // 1<->2<->3
        Node t = insertBeforeTail(arrayToDLL(1, 2, 4), 3);
        System.out.println(forward(t) + " | " + backward(t));                       // 1<->2<->3<->4 | 4<->3<->2<->1
        Node k = insertBeforeKth(arrayToDLL(1, 3, 4), 2, 2);
        System.out.println(forward(k) + " | " + backward(k));                       // 1<->2<->3<->4 | 4<->3<->2<->1
        Node b = arrayToDLL(1, 3);
        insertBefore(b.next, 2);                                                    // before the node holding 3
        System.out.println(forward(b) + " | " + backward(b));                       // 1<->2<->3 | 3<->2<->1

        Node r = reverse(arrayToDLL(1, 2, 3, 4));
        System.out.println(forward(r) + " | " + backward(r));                       // 4<->3<->2<->1 | 1<->2<->3<->4
        System.out.println(forward(reverse(arrayToDLL(7))));                        // 7
        System.out.println(forward(reverse(null)));                                 // null
    }
}
