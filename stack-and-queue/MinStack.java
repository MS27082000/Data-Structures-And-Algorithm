import java.util.ArrayDeque;
import java.util.Deque;

/** Min Stack (LC 155): push, pop, top and getMin all in O(1) */
public class MinStack {

    // Approach 1: a second stack that tracks the minimum at every depth. O(1) per operation, O(n) extra space
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> mins = new ArrayDeque<>();

    void push(int x) {
        stack.push(x);
        mins.push(mins.isEmpty() ? x : Math.min(x, mins.peek()));   // the min of everything at or below this element
    }

    void pop() {
        stack.pop();
        mins.pop();
    }

    int top() { return stack.peek(); }
    int getMin() { return mins.peek(); }

    // Approach 2: O(1) EXTRA space. Store (x - min) encoded; a negative stored value marks "x was a new minimum".
    static class MinStackConstantSpace {
        private final Deque<Long> st = new ArrayDeque<>();
        private long min;

        void push(int x) {
            if (st.isEmpty()) {
                st.push(0L);
                min = x;
            } else {
                st.push((long) x - min);              // negative when x is the new minimum
                if (x < min) min = x;
            }
        }

        void pop() {
            long diff = st.pop();
            if (diff < 0) min = min - diff;           // the popped element was the min: restore the previous min
        }

        int top() {
            long diff = st.peek();
            return (int) (diff > 0 ? min + diff : min);
        }

        int getMin() { return (int) min; }
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        System.out.println(s.getMin());                   // -3
        s.pop();
        System.out.println(s.top() + " " + s.getMin());   // 0 -2

        MinStackConstantSpace c = new MinStackConstantSpace();
        c.push(-2);
        c.push(0);
        c.push(-3);
        System.out.println(c.getMin());                   // -3
        c.pop();
        System.out.println(c.top() + " " + c.getMin());   // 0 -2
        c.push(Integer.MIN_VALUE);                        // long encoding avoids int overflow
        c.push(Integer.MAX_VALUE);
        System.out.println(c.getMin() + " " + c.top());   // -2147483648 2147483647
    }
}
