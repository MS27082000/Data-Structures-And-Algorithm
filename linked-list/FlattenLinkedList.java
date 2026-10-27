/** Flattening a Linked List: each node has `next` (to the next column) and `bottom` (a sorted list below it).
 *  Flatten everything into ONE sorted list connected through `bottom`. */
public class FlattenLinkedList {

    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
        }
    }

    // Build one column from values (linked by bottom)
    static Node column(int... a) {
        Node dummy = new Node(0);
        Node tail = dummy;
        for (int x : a) {
            tail.bottom = new Node(x);
            tail = tail.bottom;
        }
        return dummy.bottom;
    }

    // Merge two sorted lists that are linked by `bottom`
    static Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.bottom = a;
                a = a.bottom;
            } else {
                tail.bottom = b;
                b = b.bottom;
            }
            tail = tail.bottom;
        }

        if (a != null) {
            tail.bottom = a;
        } else {
            tail.bottom = b;
        }
        return dummy.bottom;
    }

    // Flatten the columns on the right first, then merge the current column with that result.
    // O(N * k) worst case for k columns; O(k) stack
    static Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node rest = flatten(head.next);
        Node merged = merge(head, rest);
        head.next = null;    // result uses only `bottom`
        return merged;
    }

    static String str(Node head) {
        if (head == null) {
            return "null";
        }
        String s = "";
        Node cur = head;
        while (cur != null) {
            s = s + cur.data;
            if (cur.bottom != null) {
                s = s + "->";
            }
            cur = cur.bottom;
        }
        return s;
    }

    public static void main(String[] args) {
        Node a = column(5, 7, 8, 30);
        Node b = column(10, 20);
        Node c = column(19, 22, 50);
        Node d = column(28, 35, 40, 45);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(str(flatten(a)));        // 5->7->8->10->19->20->22->28->30->35->40->45->50

        Node x = column(1, 4);
        Node y = column(2, 3);
        x.next = y;
        System.out.println(str(flatten(x)));        // 1->2->3->4

        System.out.println(str(flatten(column(3, 9))));   // 3->9
        System.out.println(str(flatten(null)));           // null
    }
}
