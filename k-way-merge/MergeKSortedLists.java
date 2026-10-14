import java.util.PriorityQueue;

/** Merge k Sorted Lists (LC 23) */
public class MergeKSortedLists {

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

    // Min-heap of the CURRENT head of each list. Poll the smallest, append it, and push that node's successor.
    // N = total nodes, k = number of lists: O(N log k) time, O(k) space
    static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode head : lists) if (head != null) heap.offer(head);        // skip empty lists
        ListNode dummy = new ListNode(0), tail = dummy;
        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            tail.next = smallest;
            tail = smallest;
            if (smallest.next != null) heap.offer(smallest.next);
        }
        return dummy.next;
    }

    // Divide and conquer: merge lists in pairs, like merge sort. O(N log k) time, O(log k) stack, no heap needed
    static ListNode mergeDivide(ListNode[] lists, int lo, int hi) {
        if (lo > hi) return null;
        if (lo == hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        return mergeTwo(mergeDivide(lists, lo, mid), mergeDivide(lists, mid + 1, hi));
    }

    private static ListNode mergeTwo(ListNode a, ListNode b) {
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
        System.out.println(str(mergeKLists(new ListNode[]{build(1, 4, 5), build(1, 3, 4), build(2, 6)})));   // 1->1->2->3->4->4->5->6
        System.out.println(str(mergeKLists(new ListNode[]{})));                                             // null
        System.out.println(str(mergeKLists(new ListNode[]{null})));                                         // null
        System.out.println(str(mergeKLists(new ListNode[]{build(), build(1)})));                            // 1
        ListNode[] again = {build(1, 4, 5), build(1, 3, 4), build(2, 6)};
        System.out.println(str(mergeDivide(again, 0, again.length - 1)));                                   // 1->1->2->3->4->4->5->6
        System.out.println(str(mergeKLists(new ListNode[]{build(-5, 0), build(-3), build(7, 8, 9)})));      // -5->-3->0->7->8->9
    }
}
