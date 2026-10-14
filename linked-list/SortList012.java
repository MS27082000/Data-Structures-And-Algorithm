/** Sort a Linked List of 0's, 1's and 2's (by relinking nodes, not by overwriting values) */
public class SortList012 {

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

    // Three dummy-headed lists (zeros, ones, twos); append each node to its list, then stitch them. O(n) time, O(1) space
    static ListNode sortList(ListNode head) {
        ListNode zeroD = new ListNode(-1), oneD = new ListNode(-1), twoD = new ListNode(-1);
        ListNode zero = zeroD, one = oneD, two = twoD;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val == 0) { zero.next = cur; zero = cur; }
            else if (cur.val == 1) { one.next = cur; one = cur; }
            else { two.next = cur; two = cur; }
        }
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;   // skip the 1s list if it is empty
        one.next = twoD.next;
        two.next = null;                                           // IMPORTANT: terminate to avoid a cycle
        return zeroD.next;
    }

    public static void main(String[] args) {
        System.out.println(str(sortList(build(1, 2, 0, 1, 2, 0))));    // 0->0->1->1->2->2
        System.out.println(str(sortList(build(2, 2, 0, 1))));          // 0->1->2->2
        System.out.println(str(sortList(build(1, 1, 1))));             // 1->1->1
        System.out.println(str(sortList(build(2, 0))));                // 0->2
        System.out.println(str(sortList(null)));                       // null
    }
}
