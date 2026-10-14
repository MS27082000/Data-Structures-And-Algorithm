/** Delete the Middle Node of a Linked List (LC 2095): remove the node at index floor(n / 2) */
public class DeleteMiddleNode {

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

    // Start fast one step ahead so slow stops at the node BEFORE the middle. O(n) time, O(1) space
    static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;    // 0 or 1 node: the middle is the only node
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;                            // unlink the middle
        return head;
    }

    public static void main(String[] args) {
        System.out.println(str(deleteMiddle(build(1, 3, 4, 7, 1, 2, 6))));   // 1->3->4->1->2->6
        System.out.println(str(deleteMiddle(build(1, 2, 3, 4))));            // 1->2->4
        System.out.println(str(deleteMiddle(build(2, 1))));                   // 2
        System.out.println(str(deleteMiddle(build(5))));                     // null
        System.out.println(str(deleteMiddle(build(1, 2, 3))));               // 1->3
    }
}
