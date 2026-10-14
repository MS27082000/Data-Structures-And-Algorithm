/** Reverse Nodes in k-Group (LC 25): reverse every k consecutive nodes; leave a final group shorter than k as it is */
public class ReverseNodesInKGroup {

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

    // For each group: check that k nodes exist, reverse them in place, and reconnect with the previous group's tail.
    // O(n) time, O(1) space
    static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;                          // node just before the current group
        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break;                          // fewer than k nodes left: stop
            ListNode groupNext = kth.next;                   // first node of the next group
            ListNode prev = groupNext, cur = groupPrev.next; // prev starts at groupNext so the tail links forward
            while (cur != groupNext) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            ListNode oldGroupHead = groupPrev.next;          // it is now the tail of the reversed group
            groupPrev.next = kth;                            // kth is now the head of the reversed group
            groupPrev = oldGroupHead;
        }
        return dummy.next;
    }

    private static ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    public static void main(String[] args) {
        System.out.println(str(reverseKGroup(build(1, 2, 3, 4, 5), 2)));      // 2->1->4->3->5
        System.out.println(str(reverseKGroup(build(1, 2, 3, 4, 5), 3)));      // 3->2->1->4->5
        System.out.println(str(reverseKGroup(build(1, 2, 3, 4, 5, 6), 3)));   // 3->2->1->6->5->4
        System.out.println(str(reverseKGroup(build(1, 2, 3), 1)));            // 1->2->3
        System.out.println(str(reverseKGroup(build(1, 2), 5)));               // 1->2
    }
}
