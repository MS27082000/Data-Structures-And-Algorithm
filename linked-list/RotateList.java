/** Rotate List (LC 61): rotate the list to the right by k places */
public class RotateList {

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

    // Find length, join tail to head (circle), then cut at the new tail. O(n) time, O(1) space
    static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1) find length and the last node
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2) rotating by len gives the same list
        k = k % len;
        if (k == 0) {
            return head;
        }

        // 3) make a circle
        tail.next = head;

        // 4) new tail is at position (len - k)
        ListNode newTail = head;
        for (int i = 1; i < len - k; i++) {
            newTail = newTail.next;
        }

        // 5) cut the circle
        ListNode newHead = newTail.next;
        newTail.next = null;
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
