/** Length of the Loop in a Linked List (0 if there is no loop) */
public class LengthOfLoop {

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

    // Floyd's to find a meeting point inside the cycle, then walk once around it counting nodes. O(n) time, O(1) space
    static int lengthOfLoop(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int length = 1;
                ListNode cur = slow.next;
                while (cur != slow) {
                    length++;
                    cur = cur.next;
                }
                return length;
            }
        }
        return 0;
    }

    static void makeCycle(ListNode head, int pos) {
        ListNode target = head, tail = head;
        for (int i = 0; i < pos; i++) target = target.next;
        while (tail.next != null) tail = tail.next;
        tail.next = target;
    }

    public static void main(String[] args) {
        ListNode a = build(1, 2, 3, 4, 5);
        makeCycle(a, 1);
        System.out.println(lengthOfLoop(a));                  // 4
        System.out.println(lengthOfLoop(build(1, 2, 3)));     // 0
        ListNode b = build(1);
        makeCycle(b, 0);
        System.out.println(lengthOfLoop(b));                  // 1
        ListNode c = build(1, 2, 3);
        makeCycle(c, 0);
        System.out.println(lengthOfLoop(c));                  // 3
    }
}
