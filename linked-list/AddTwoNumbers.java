/** Add Two Numbers (LC 2): digits are stored in REVERSE order (least significant digit first) */
public class AddTwoNumbers {

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

    // Add digit by digit with a carry. O(max(m, n)) time
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
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
