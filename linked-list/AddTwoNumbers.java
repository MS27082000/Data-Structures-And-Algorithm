/** Add Two Numbers (LC 2): digits are stored in REVERSE order (least significant digit first) */
public class AddTwoNumbers {

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

    // Walk both lists together adding digits and a carry. O(max(m, n)) time, O(1) extra (besides the result)
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {      // "|| carry != 0" handles a final carry digit
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(str(addTwoNumbers(build(2, 4, 3), build(5, 6, 4))));          // 7->0->8   (342 + 465 = 807)
        System.out.println(str(addTwoNumbers(build(0), build(0))));                       // 0
        System.out.println(str(addTwoNumbers(build(9, 9, 9, 9), build(9, 9))));           // 8->9->0->0->1 (9999 + 99)
        System.out.println(str(addTwoNumbers(build(5), build(5))));                       // 0->1
        System.out.println(str(addTwoNumbers(build(1, 8), build(0))));                    // 1->8
    }
}
