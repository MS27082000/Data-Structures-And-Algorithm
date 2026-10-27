/** Sort a Linked List of 0s, 1s and 2s (by relinking nodes, not by overwriting values) */
public class SortList012 {

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

    // Make three lists (zeros, ones, twos), then join them. O(n) time, O(1) space
    static ListNode sortList(ListNode head) {
        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twoDummy = new ListNode(-1);
        ListNode zero = zeroDummy;
        ListNode one = oneDummy;
        ListNode two = twoDummy;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val == 0) {
                zero.next = cur;
                zero = zero.next;
            } else if (cur.val == 1) {
                one.next = cur;
                one = one.next;
            } else {
                two.next = cur;
                two = two.next;
            }
            cur = cur.next;
        }

        // join: zeros -> ones -> twos
        if (oneDummy.next != null) {
            zero.next = oneDummy.next;
        } else {
            zero.next = twoDummy.next;
        }
        one.next = twoDummy.next;
        two.next = null;    // IMPORTANT: end the list, otherwise a cycle can form

        return zeroDummy.next;
    }

    public static void main(String[] args) {
        System.out.println(str(sortList(build(1, 2, 0, 1, 2, 0))));    // 0->0->1->1->2->2
        System.out.println(str(sortList(build(2, 2, 0, 1))));          // 0->1->2->2
        System.out.println(str(sortList(build(1, 1, 1))));             // 1->1->1
        System.out.println(str(sortList(build(2, 0))));                // 0->2
        System.out.println(str(sortList(null)));                       // null
    }
}
