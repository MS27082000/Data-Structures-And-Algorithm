/** Rotate List (LC 61): rotate the list to the right by k places */
public class RotateList {

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

    // Count length, make the list circular, then break it at the new tail (len - k % len nodes from the head).
    // O(n) time, O(1) space
    static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len;                                  // rotating by len is a no-op
        if (k == 0) return head;
        tail.next = head;                          // close the circle
        ListNode newTail = head;
        for (int i = 1; i < len - k; i++) newTail = newTail.next;
        ListNode newHead = newTail.next;
        newTail.next = null;                       // open the circle
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(str(rotateRight(build(1, 2, 3, 4, 5), 2)));    // 4->5->1->2->3
        System.out.println(str(rotateRight(build(0, 1, 2), 4)));          // 2->0->1
        System.out.println(str(rotateRight(build(1, 2), 2)));             // 1->2
        System.out.println(str(rotateRight(build(1), 99)));               // 1
        System.out.println(str(rotateRight(null, 3)));                    // null
        System.out.println(str(rotateRight(build(1, 2, 3), 1)));          // 3->1->2
    }
}
