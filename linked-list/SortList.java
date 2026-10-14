/** Sort List (LC 148): sort a linked list in O(n log n) time */
public class SortList {

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

    // Merge sort: split at the middle (slow/fast), sort both halves recursively, merge. O(n log n) time, O(log n) stack
    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;              // fast starts one ahead so slow ends at the END of the first half
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;                                    // cut the list in two
        return merge(sortList(head), sortList(second));
    }

    private static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(str(sortList(build(4, 2, 1, 3))));          // 1->2->3->4
        System.out.println(str(sortList(build(-1, 5, 3, 4, 0))));      // -1->0->3->4->5
        System.out.println(str(sortList(build(1))));                   // 1
        System.out.println(str(sortList(null)));                       // null
        System.out.println(str(sortList(build(3, 3, 1, 1, 2))));       // 1->1->2->3->3
    }
}
