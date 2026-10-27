/** Odd Even Linked List (LC 328): odd POSITIONS first, then even POSITIONS, keeping order */
public class OddEvenLinkedList {

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

    // Two chains (odd and even), then join odd tail to even head. O(n) time, O(1) space
    static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;     // odd -> next odd
            odd = odd.next;

            even.next = odd.next;     // even -> next even
            even = even.next;
        }

        odd.next = evenHead;          // odd chain then even chain
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
