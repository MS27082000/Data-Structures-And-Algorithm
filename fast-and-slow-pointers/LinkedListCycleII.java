/** Linked List Cycle II (LC 142): return the node where the cycle begins, or null */
public class LinkedListCycleII {

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

    // Phase 1: slow/fast meet inside the cycle. Phase 2: reset one pointer to head; moving both one step at a time
    // they meet at the cycle start. O(n) time, O(1) space
    static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }
        return null;
    }

    static void makeCycle(ListNode head, int pos) {
        ListNode target = head, tail = head;
        for (int i = 0; i < pos; i++) target = target.next;
        while (tail.next != null) tail = tail.next;
        tail.next = target;
    }

    public static void main(String[] args) {
        ListNode a = build(3, 2, 0, -4);
        makeCycle(a, 1);
        System.out.println(detectCycle(a).val);                // 2
        ListNode b = build(1, 2);
        makeCycle(b, 0);
        System.out.println(detectCycle(b).val);                // 1
        System.out.println(detectCycle(build(1, 2, 3)));       // null
        ListNode c = build(1);
        makeCycle(c, 0);
        System.out.println(detectCycle(c).val);                // 1
        ListNode d = build(1, 2, 3, 4, 5, 6);
        makeCycle(d, 3);
        System.out.println(detectCycle(d).val);                // 4
    }
}
