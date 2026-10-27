/** Merge Two Sorted Lists (LC 21) */
public class MergeTwoSortedLists {

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

    // Dummy node + tail. Attach the smaller node each time. O(m + n) time, O(1) space
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // one list is finished, attach the other one
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return dummy.next;
    }

    // Recursive version. O(m + n) time, O(m + n) stack
    static ListNode mergeRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeRecursive(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        System.out.println(str(mergeTwoLists(build(1, 2, 4), build(1, 3, 4))));    // 1->1->2->3->4->4
        System.out.println(str(mergeTwoLists(null, null)));                        // null
        System.out.println(str(mergeTwoLists(null, build(0))));                    // 0
        System.out.println(str(mergeTwoLists(build(5), build(1, 2, 3))));          // 1->2->3->5
        System.out.println(str(mergeRecursive(build(1, 5, 9), build(2, 3, 10))));  // 1->2->3->5->9->10
    }
}
