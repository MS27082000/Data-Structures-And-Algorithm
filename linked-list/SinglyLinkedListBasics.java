/** Singly Linked List fundamentals: introduction, traversal, length, search, and every insert / delete variant.
 *  Positions are 1-indexed. Every method returns the (possibly new) head. */
public class SinglyLinkedListBasics {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // ---- Introduction: build a list from an array. O(n) ----
    static Node arrayToLL(int... a) {
        if (a.length == 0) {
            return null;
        }
        Node head = new Node(a[0]);
        Node cur = head;
        for (int i = 1; i < a.length; i++) {
            cur.next = new Node(a[i]);
            cur = cur.next;
        }
        return head;
    }

    // ---- Traversal. O(n) ----
    static String traverse(Node head) {
        if (head == null) {
            return "null";
        }
        String s = "";
        Node temp = head;
        while (temp != null) {
            s = s + temp.val;
            if (temp.next != null) {
                s = s + "->";
            }
            temp = temp.next;
        }
        return s;
    }

    // ---- Length. O(n) ----
    static int length(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // ---- Search. O(n) ----
    static boolean search(Node head, int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == x) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // ---- Deletion ----
    static Node deleteHead(Node head) {                      // O(1)
        if (head == null) {
            return null;
        }
        return head.next;
    }

    static Node deleteTail(Node head) {                      // O(n)
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {                     // stop at the second-last node
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    static Node deleteKth(Node head, int k) {                // O(k)
        if (head == null || k < 1) {
            return head;
        }
        if (k == 1) {
            return head.next;
        }

        // go to the node just before the k-th node
        Node prev = head;
        int count = 1;
        while (prev != null && count < k - 1) {
            prev = prev.next;
            count++;
        }

        if (prev == null || prev.next == null) {             // k is out of range
            return head;
        }
        prev.next = prev.next.next;
        return head;
    }

    static Node deleteValue(Node head, int x) {              // deletes the first node holding x. O(n)
        if (head == null) {
            return null;
        }
        if (head.val == x) {
            return head.next;
        }

        Node prev = head;
        while (prev.next != null && prev.next.val != x) {
            prev = prev.next;
        }
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
        return head;
    }

    // ---- Insertion ----
    static Node insertHead(Node head, int val) {             // O(1)
        Node newNode = new Node(val);
        newNode.next = head;
        return newNode;
    }

    static Node insertTail(Node head, int val) {             // O(n)
        Node newNode = new Node(val);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    static Node insertKth(Node head, int k, int val) {       // new node becomes the k-th. O(k)
        if (k == 1) {
            return insertHead(head, val);
        }

        // go to the node just before position k
        Node prev = head;
        int count = 1;
        while (prev != null && count < k - 1) {
            prev = prev.next;
            count++;
        }

        if (prev == null) {                                  // k is beyond length + 1
            return head;
        }
        Node newNode = new Node(val);
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }

    static Node insertBeforeValue(Node head, int x, int val) {   // insert val before the first node holding x. O(n)
        if (head == null) {
            return null;
        }
        if (head.val == x) {
            return insertHead(head, val);
        }

        Node prev = head;
        while (prev.next != null && prev.next.val != x) {
            prev = prev.next;
        }
        if (prev.next == null) {                             // x not found
            return head;
        }
        Node newNode = new Node(val);
        newNode.next = prev.next;
        prev.next = newNode;
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
