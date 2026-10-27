/** Intersection of Two Linked Lists (LC 160): return the node where two lists meet (Y shape), or null */
public class IntersectionOfTwoLinkedLists {

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

    // Two pointers. When one reaches the end, it jumps to the OTHER list's head.
    // Both walk lenA + lenB steps, so they meet at the intersection (or both become null). O(m + n) time, O(1) space
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
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
