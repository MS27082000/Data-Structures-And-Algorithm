/** Intersection of Two Linked Lists (LC 160): return the node where two lists merge (Y shape), or null */
public class IntersectionOfTwoLinkedLists {

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

    // Two pointers: when one reaches the end it jumps to the OTHER list's head. Both then travel lenA + lenB nodes,
    // so they meet at the intersection (or both become null together). O(m + n) time, O(1) space
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA, b = headB;
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode common = build(8, 4, 5);
        ListNode a = build(4, 1);
        a.next.next = common;                         // 4->1->8->4->5
        ListNode b = build(5, 6, 1);
        b.next.next.next = common;                    // 5->6->1->8->4->5
        System.out.println(getIntersectionNode(a, b).val);                   // 8

        System.out.println(getIntersectionNode(build(2, 6, 4), build(1, 5))); // null (no intersection)

        ListNode shared = build(1);
        System.out.println(getIntersectionNode(shared, shared).val);         // 1 (same list)

        ListNode tail = build(3);
        ListNode x = build(1, 2);
        x.next.next = tail;
        System.out.println(getIntersectionNode(x, tail).val);                // 3 (one list is a suffix of the other)
        System.out.println(getIntersectionNode(null, tail));                 // null
    }
}
