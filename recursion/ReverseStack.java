import java.util.ArrayDeque;
import java.util.Deque;

/** Reverse a Stack using recursion only (no extra data structure) */
public class ReverseStack {

    // Pop everything via recursion, then insert each element at the BOTTOM on the way back up.
    // O(n^2) time, O(n) recursion stack
    static void reverse(Deque<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        reverse(stack);                    // reverse the rest
        insertAtBottom(stack, top);        // put the old top at the bottom
    }

    private static void insertAtBottom(Deque<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, x);
        stack.push(top);
    }

    public static void main(String[] args) {
        Deque<Integer> s = new ArrayDeque<>();
        for (int x : new int[]{1, 2, 3, 4}) s.push(x);        // top = 4
        System.out.println("before: " + s);                   // [4, 3, 2, 1]
        reverse(s);
        System.out.println("after:  " + s);                   // [1, 2, 3, 4]

        Deque<Integer> one = new ArrayDeque<>();
        one.push(7);
        reverse(one);
        System.out.println(one);                              // [7]

        Deque<Integer> empty = new ArrayDeque<>();
        reverse(empty);
        System.out.println(empty);                            // []
    }
}
