/** Singly Linked List fundamentals: introduction, traversal, length, search, and every insert / delete variant.
 *  Positions are 1-indexed. Every method returns the (possibly new) head. */
public class SinglyLinkedListBasics {

    static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    // ---- Introduction: build a list from an array. O(n) ----
    static Node arrayToLL(int... a) {
        if (a.length == 0) return null;
        Node head = new Node(a[0]), cur = head;
        for (int i = 1; i < a.length; i++) { cur.next = new Node(a[i]); cur = cur.next; }
        return head;
    }

    // ---- Traversal. O(n) ----
    static String traverse(Node head) {
        StringBuilder sb = new StringBuilder();
        for (Node t = head; t != null; t = t.next) sb.append(t.val).append(t.next != null ? "->" : "");
        return sb.length() == 0 ? "null" : sb.toString();
    }

    // ---- Length. O(n) ----
    static int length(Node head) {
        int n = 0;
        for (Node t = head; t != null; t = t.next) n++;
        return n;
    }

    // ---- Search. O(n) ----
    static boolean search(Node head, int x) {
        for (Node t = head; t != null; t = t.next) if (t.val == x) return true;
        return false;
    }

    // ---- Deletion ----
    static Node deleteHead(Node head) {                      // O(1)
        return head == null ? null : head.next;
    }

    static Node deleteTail(Node head) {                      // O(n)
        if (head == null || head.next == null) return null;
        Node t = head;
        while (t.next.next != null) t = t.next;              // stop at the second-last node
        t.next = null;
        return head;
    }

    static Node deleteKth(Node head, int k) {                // O(k)
        if (head == null || k < 1) return head;
        if (k == 1) return head.next;
        Node prev = head;
        for (int i = 1; i < k - 1 && prev != null; i++) prev = prev.next;   // node just before the k-th
        if (prev == null || prev.next == null) return head;  // k is out of range
        prev.next = prev.next.next;
        return head;
    }

    static Node deleteValue(Node head, int x) {              // deletes the first node holding x. O(n)
        if (head == null) return null;
        if (head.val == x) return head.next;
        Node prev = head;
        while (prev.next != null && prev.next.val != x) prev = prev.next;
        if (prev.next != null) prev.next = prev.next.next;
        return head;
    }

    // ---- Insertion ----
    static Node insertHead(Node head, int val) {             // O(1)
        Node n = new Node(val);
        n.next = head;
        return n;
    }

    static Node insertTail(Node head, int val) {             // O(n)
        Node n = new Node(val);
        if (head == null) return n;
        Node t = head;
        while (t.next != null) t = t.next;
        t.next = n;
        return head;
    }

    static Node insertKth(Node head, int k, int val) {       // new node becomes the k-th. O(k)
        if (k == 1) return insertHead(head, val);
        Node prev = head;
        for (int i = 1; i < k - 1 && prev != null; i++) prev = prev.next;
        if (prev == null) return head;                       // k beyond length + 1
        Node n = new Node(val);
        n.next = prev.next;
        prev.next = n;
        return head;
    }

    static Node insertBeforeValue(Node head, int x, int val) {   // insert val before the first node holding x. O(n)
        if (head == null) return null;
        if (head.val == x) return insertHead(head, val);
        Node prev = head;
        while (prev.next != null && prev.next.val != x) prev = prev.next;
        if (prev.next == null) return head;                  // x not found
        Node n = new Node(val);
        n.next = prev.next;
        prev.next = n;
        return head;
    }

    public static void main(String[] args) {
        Node h = arrayToLL(10, 20, 30, 40);
        System.out.println(traverse(h) + " len=" + length(h));                        // 10->20->30->40 len=4
        System.out.println(search(h, 30) + " " + search(h, 99));                      // true false

        System.out.println(traverse(deleteHead(arrayToLL(1, 2, 3))));                 // 2->3
        System.out.println(traverse(deleteTail(arrayToLL(1, 2, 3))));                 // 1->2
        System.out.println(traverse(deleteKth(arrayToLL(1, 2, 3, 4), 3)));            // 1->2->4
        System.out.println(traverse(deleteKth(arrayToLL(1, 2, 3), 1)));               // 2->3
        System.out.println(traverse(deleteKth(arrayToLL(1, 2, 3), 9)));               // 1->2->3 (out of range)
        System.out.println(traverse(deleteValue(arrayToLL(1, 2, 3, 2), 2)));          // 1->3->2 (first match only)
        System.out.println(traverse(deleteValue(arrayToLL(1, 2, 3), 1)));             // 2->3

        System.out.println(traverse(insertHead(arrayToLL(2, 3), 1)));                 // 1->2->3
        System.out.println(traverse(insertTail(arrayToLL(1, 2), 3)));                 // 1->2->3
        System.out.println(traverse(insertTail(null, 5)));                            // 5
        System.out.println(traverse(insertKth(arrayToLL(1, 3, 4), 2, 2)));            // 1->2->3->4
        System.out.println(traverse(insertKth(arrayToLL(1, 2, 3), 4, 4)));            // 1->2->3->4 (append position)
        System.out.println(traverse(insertBeforeValue(arrayToLL(1, 3, 4), 3, 2)));    // 1->2->3->4
        System.out.println(traverse(insertBeforeValue(arrayToLL(2, 3), 2, 1)));       // 1->2->3
        System.out.println(traverse(deleteTail(arrayToLL(7))));                       // null
    }
}
