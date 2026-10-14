/** Middle of the Linked List (LC 876): for an even length return the SECOND middle node */
public class MiddleOfLinkedList {

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

    // slow moves 1 step, fast moves 2. When fast reaches the end, slow is at the middle. O(n) time, O(1) space
    static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(middleNode(build(1, 2, 3, 4, 5)).val);       // 3
        System.out.println(middleNode(build(1, 2, 3, 4, 5, 6)).val);    // 4 (second middle)
        System.out.println(middleNode(build(7)).val);                   // 7
        System.out.println(middleNode(build(1, 2)).val);                // 2
    }
}
