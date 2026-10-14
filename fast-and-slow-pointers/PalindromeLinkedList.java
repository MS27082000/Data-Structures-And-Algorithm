/** Palindrome Linked List (LC 234) in O(n) time and O(1) space */
public class PalindromeLinkedList {

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

    // 1) find the middle (slow/fast)  2) reverse the second half  3) compare both halves  4) restore the list
    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {   // slow ends at the END of the first half
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverse(slow.next);
        ListNode p1 = head, p2 = secondHalf;
        boolean ok = true;
        while (p2 != null) {
            if (p1.val != p2.val) { ok = false; break; }
            p1 = p1.next;
            p2 = p2.next;
        }
        slow.next = reverse(secondHalf);                        // put the list back as it was
        return ok;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(build(1, 2, 2, 1)));       // true
        System.out.println(isPalindrome(build(1, 2, 3, 2, 1)));    // true
        System.out.println(isPalindrome(build(1, 2)));             // false
        System.out.println(isPalindrome(build(1)));                // true
        System.out.println(isPalindrome(null));                    // true
        System.out.println(isPalindrome(build(1, 2, 3, 4)));       // false
    }
}
