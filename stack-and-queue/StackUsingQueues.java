import java.util.ArrayDeque;
import java.util.Queue;

/** Implement a Stack using Queues (LC 225). One queue: after each push, rotate the older elements behind the new one */
public class StackUsingQueues {

    private final Queue<Integer> q = new ArrayDeque<>();

    // push is O(n): add x, then move the n older elements behind it so x sits at the FRONT (top of the stack)
    void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++) q.offer(q.poll());
    }

    int pop() { return q.poll(); }          // O(1): the front is the top of the stack
    int top() { return q.peek(); }          // O(1)
    boolean isEmpty() { return q.isEmpty(); }

    public static void main(String[] args) {
        StackUsingQueues s = new StackUsingQueues();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.top());                           // 3
        System.out.println(s.pop() + " " + s.pop());            // 3 2
        s.push(4);
        System.out.println(s.pop() + " " + s.pop());            // 4 1
        System.out.println(s.isEmpty());                        // true
    }
}
