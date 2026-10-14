/** Flattening a Linked List: each node has `next` (to the next column) and `bottom` (a sorted list below it).
 *  Flatten everything into ONE sorted list connected through `bottom`. */
public class FlattenLinkedList {

    static class Node {
        int data;
        Node next, bottom;
        Node(int d) { data = d; }
    }

    // Build one column from values (linked by bottom)
    static Node column(int... a) {
        Node dummy = new Node(0), tail = dummy;
        for (int x : a) { tail.bottom = new Node(x); tail = tail.bottom; }
        return dummy.bottom;
    }

    // Merge two sorted lists that are linked by `bottom`
    private static Node merge(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        while (a != null && b != null) {
            if (a.data <= b.data) { tail.bottom = a; a = a.bottom; }
            else { tail.bottom = b; b = b.bottom; }
            tail = tail.bottom;
        }
        tail.bottom = (a != null) ? a : b;
        return dummy.bottom;
    }

    // Recursively flatten the rest (to the right), then merge the current column with it.
    // O(N) total nodes per merge level => O(N * k) worst case for k columns; O(k) stack
    static Node flatten(Node head) {
        if (head == null || head.next == null) return head;
        Node merged = merge(head, flatten(head.next));
        head.next = null;                                    // the result uses only `bottom`
        return merged;
    }

    static String str(Node h) {
        StringBuilder sb = new StringBuilder();
        for (; h != null; h = h.bottom) sb.append(h.data).append(h.bottom != null ? "->" : "");
        return sb.length() == 0 ? "null" : sb.toString();
    }

    public static void main(String[] args) {
        Node a = column(5, 7, 8, 30), b = column(10, 20), c = column(19, 22, 50), d = column(28, 35, 40, 45);
        a.next = b; b.next = c; c.next = d;
        System.out.println(str(flatten(a)));        // 5->7->8->10->19->20->22->28->30->35->40->45->50

        Node x = column(1, 4), y = column(2, 3);
        x.next = y;
        System.out.println(str(flatten(x)));        // 1->2->3->4

        System.out.println(str(flatten(column(3, 9))));   // 3->9
        System.out.println(str(flatten(null)));           // null
    }
}
