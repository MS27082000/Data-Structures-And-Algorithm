/** Add One to a Number Represented by a Linked List (LC 369): digits stored MOST significant first */
public class AddOneToLinkedList {

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

    // Find the LAST node that is not 9. Increment it and zero every node after it.
    // If every digit is 9, a new leading 1 is needed (sentinel node). O(n) time, O(1) space
    static ListNode plusOne(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode notNine = sentinel;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val != 9) notNine = cur;
        }
        notNine.val++;
        for (ListNode cur = notNine.next; cur != null; cur = cur.next) cur.val = 0;
        return sentinel.val == 0 ? head : sentinel;
    }

    // Alternative: recursion returns the carry. O(n) time, O(n) stack
    static ListNode plusOneRecursive(ListNode head) {
        int carry = helper(head);
        if (carry == 0) return head;
        ListNode n = new ListNode(carry);
        n.next = head;
        return n;
    }

    private static int helper(ListNode node) {
        if (node == null) return 1;               // the "+1" enters at the end
        int sum = node.val + helper(node.next);
        node.val = sum % 10;
        return sum / 10;
    }

    public static void main(String[] args) {
        System.out.println(str(plusOne(build(1, 2, 3))));            // 1->2->4
        System.out.println(str(plusOne(build(1, 9, 9))));            // 2->0->0
        System.out.println(str(plusOne(build(9, 9, 9))));            // 1->0->0->0
        System.out.println(str(plusOne(build(0))));                  // 1
        System.out.println(str(plusOne(build(4, 9, 3, 9))));         // 4->9->4->0
        System.out.println(str(plusOneRecursive(build(9, 9))));      // 1->0->0
        System.out.println(str(plusOneRecursive(build(8, 9))));      // 9->0
    }
}
