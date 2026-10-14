import java.util.ArrayDeque;
import java.util.Deque;

/** Remove K Digits (LC 402): remove k digits from the number string to make the smallest possible number */
public class RemoveKDigits {

    // Monotonic INCREASING stack of digits: while the top is bigger than the incoming digit (and removals remain), pop it.
    // O(n) time, O(n) space
    static String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {   // peekLast = top (we use the deque like a stack from the tail)
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }
        while (k > 0 && !stack.isEmpty()) {                               // non-decreasing number: remove from the END
            stack.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean leading = true;
        for (char c : stack) {                                            // iterate from the front: strip leading zeros
            if (leading && c == '0') continue;
            leading = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));    // 1219
        System.out.println(removeKdigits("10200", 1));      // 200   (leading zeros stripped)
        System.out.println(removeKdigits("10", 2));         // 0     (empty result becomes "0")
        System.out.println(removeKdigits("9", 1));          // 0
        System.out.println(removeKdigits("112", 1));        // 11    (increasing: remove from the end)
        System.out.println(removeKdigits("123456", 3));     // 123
        System.out.println(removeKdigits("100", 1));        // 0
    }
}
