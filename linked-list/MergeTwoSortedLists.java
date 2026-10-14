/** Merge Two Sorted Lists (LC 21) */
public class MergeTwoSortedLists {

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

    // Dummy head + tail pointer; take the smaller front node each time; attach the leftover list. O(m + n), O(1) space
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { tail.next = l1; l1 = l1.next; }      // <= keeps the merge stable
            else { tail.next = l2; l2 = l2.next; }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;                               // one list is exhausted: attach the rest
        return dummy.next;
    }

    // Recursive version. O(m + n) time, O(m + n) stack
    static ListNode mergeRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeRecursive(l1.next, l2);
            return l1;
        }
        l2.next = mergeRecursive(l1, l2.next);
        return l2;
    }

    public static void main(String[] args) {
        System.out.println(str(mergeTwoLists(build(1, 2, 4), build(1, 3, 4))));    // 1->1->2->3->4->4
        System.out.println(str(mergeTwoLists(null, null)));                        // null
        System.out.println(str(mergeTwoLists(null, build(0))));                    // 0
        System.out.println(str(mergeTwoLists(build(5), build(1, 2, 3))));          // 1->2->3->5
        System.out.println(str(mergeRecursive(build(1, 5, 9), build(2, 3, 10))));  // 1->2->3->5->9->10
    }
}
