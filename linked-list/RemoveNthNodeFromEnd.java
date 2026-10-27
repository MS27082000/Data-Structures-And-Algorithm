/** Remove Nth Node From End of List (LC 19), in ONE pass */
public class RemoveNthNodeFromEnd {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static ListNode build(int... a) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int x : a) {
            tail.next = new ListNode(x);
            tail = tail.next;
        }
        return dummy.next;
    }

    static String str(ListNode head) {
        if (head == null) {
            return "null";
        }
        String s = "";
        ListNode cur = head;
        while (cur != null) {
            s = s + cur.val;
            if (cur.next != null) {
                s = s + "->";
            }
            cur = cur.next;
        }
        return s;
    }

    // Move fast n steps ahead, then move both together. When fast is at the last node, slow is just before the target.
    // Dummy node handles removing the head. O(n) time, O(1) space
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;    // delete the target
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
