/** Remove Nth Node From End of List (LC 19), in ONE pass */
public class RemoveNthNodeFromEnd {

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

    // Move `fast` n steps ahead, then move both until fast hits the last node: slow is just BEFORE the target.
    // A dummy head handles removing the first node. O(n) time, O(1) space
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(str(removeNthFromEnd(build(1, 2, 3, 4, 5), 2)));   // 1->2->3->5
        System.out.println(str(removeNthFromEnd(build(1), 1)));               // null
        System.out.println(str(removeNthFromEnd(build(1, 2), 1)));            // 1
        System.out.println(str(removeNthFromEnd(build(1, 2), 2)));            // 2   (remove the head)
        System.out.println(str(removeNthFromEnd(build(1, 2, 3), 3)));         // 2->3
    }
}
