/** Reverse a Linked List (LC 206) */
public class ReverseLinkedList {

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

    // Iterative: re-point each node's next to the previous node. O(n) time, O(1) space
    static ListNode reverseIterative(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;      // 1) save the next node
            cur.next = prev;               // 2) reverse the link
            prev = cur;                    // 3) advance prev
            cur = next;                    // 4) advance cur
        }
        return prev;
    }

    // Recursive: reverse the rest, then make the next node point back to this one. O(n) time, O(n) stack
    static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(str(reverseIterative(build(1, 2, 3, 4, 5))));   // 5->4->3->2->1
        System.out.println(str(reverseIterative(build(1, 2))));            // 2->1
        System.out.println(str(reverseIterative(null)));                   // null
        System.out.println(str(reverseRecursive(build(1, 2, 3, 4, 5))));   // 5->4->3->2->1
        System.out.println(str(reverseRecursive(build(9))));               // 9
    }
}
