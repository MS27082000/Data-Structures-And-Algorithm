import java.util.ArrayDeque;
import java.util.Deque;

/** Implement a Queue using Stacks (LC 232): two stacks, `in` for pushes and `out` for pops. Amortised O(1) per operation */
public class QueueUsingStacks {

    private final Deque<Integer> in = new ArrayDeque<>();
    private final Deque<Integer> out = new ArrayDeque<>();

    void push(int x) {
        in.push(x);
    }

    // Move everything from `in` to `out` ONLY when `out` is empty: the order reverses, so the oldest element ends on top
    private void transfer() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
    }

    int pop() {
        transfer();
        return out.pop();
    }

    int peek() {
        transfer();
        return out.peek();
    }

    boolean isEmpty() { return in.isEmpty() && out.isEmpty(); }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());                          // 1
        System.out.println(q.pop());                           // 1
        q.push(3);                                             // goes to `in`; `out` still holds 2
        System.out.println(q.pop() + " " + q.pop());           // 2 3
        System.out.println(q.isEmpty());                       // true
        q.push(9);
        System.out.println(q.peek() + " " + q.isEmpty());      // 9 false
    }
}
