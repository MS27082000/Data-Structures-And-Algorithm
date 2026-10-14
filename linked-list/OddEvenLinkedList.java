/** Odd Even Linked List (LC 328): group all nodes at ODD positions first, then EVEN positions (positions, not values), keeping order */
public class OddEvenLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    static ListNode build(int... a) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int x : a) { tail.next = new ListNode(x); tail = tail.next; }
        return dummy.next;
    }

    static String str(ListNode h) {
        StringBuilder sb = new StringBuilder();
        for (; h != null; h = h.next) sb.append(h.val).append(h.next != null ? "->" : "");
        return sb.length() == 0 ? "null" : sb.toString();
    }

    // Two chains (odd, even) rewired in place, then join odd's tail to even's head. O(n) time, O(1) space
    static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;          // link odd to the next odd
            odd = odd.next;
            even.next = odd.next;          // link even to the next even
            even = even.next;
        }
        odd.next = evenHead;               // attach the even chain after the odd chain
        return head;
    }

    public static void main(String[] args) {
        System.out.println(str(oddEvenList(build(1, 2, 3, 4, 5))));         // 1->3->5->2->4
        System.out.println(str(oddEvenList(build(2, 1, 3, 5, 6, 4, 7))));   // 2->3->6->7->1->5->4
        System.out.println(str(oddEvenList(build(1, 2))));                  // 1->2
        System.out.println(str(oddEvenList(build(1))));                     // 1
        System.out.println(str(oddEvenList(null)));                         // null
    }
}
