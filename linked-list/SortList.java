/** Sort List (LC 148): sort a linked list in O(n log n) time */
public class SortList {

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

    // Merge sort: find middle, split, sort both halves, merge. O(n log n) time, O(log n) stack
    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find the end of the first half (fast starts one step ahead)
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split into two lists
        ListNode second = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(second);
        return merge(left, right);
    }

    static ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }
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
