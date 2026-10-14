/** Linked List Cycle (LC 141): detect a loop in a linked list */
public class LinkedListCycle {

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

    // Floyd's tortoise and hare: if there is a cycle, fast catches slow. O(n) time, O(1) space
    static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;        // compare NODES (references), not values
        }
        return false;                             // fast reached the end: no cycle
    }

    // Test helper: connect the tail to the node at position `pos` (0-indexed)
    static void makeCycle(ListNode head, int pos) {
        ListNode target = head, tail = head;
        for (int i = 0; i < pos; i++) target = target.next;
        while (tail.next != null) tail = tail.next;
        tail.next = target;
    }

    public static void main(String[] args) {
        ListNode a = build(3, 2, 0, -4);
        makeCycle(a, 1);
        System.out.println(hasCycle(a));                       // true
        System.out.println(hasCycle(build(1, 2, 3)));          // false
        ListNode single = build(1);
        makeCycle(single, 0);
        System.out.println(hasCycle(single));                  // true (self loop)
        System.out.println(hasCycle(null));                    // false
        System.out.println(hasCycle(build(1, 1, 1)));          // false (equal values are not a cycle)
    }
}
