/** Implement a Stack using an Array (fixed capacity). push / pop / peek / isEmpty / size all O(1) */
public class StackUsingArray {

    private final int[] data;
    private int top = -1;                    // index of the top element; -1 means empty

    StackUsingArray(int capacity) {
        data = new int[capacity];
    }

    void push(int x) {
        if (top == data.length - 1) throw new IllegalStateException("Stack overflow");
        data[++top] = x;
    }

    int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack underflow");
        return data[top--];                  // no need to clear the slot for primitives
    }

    int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data[top];
    }

    boolean isEmpty() { return top == -1; }
    int size() { return top + 1; }

    public static void main(String[] args) {
        StackUsingArray s = new StackUsingArray(3);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.peek() + " " + s.size());                // 30 3
        try {
            s.push(40);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());                        // Stack overflow
        }
        System.out.println(s.pop() + " " + s.pop() + " " + s.pop());   // 30 20 10
        System.out.println(s.isEmpty());                               // true
        try {
            s.pop();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());                        // Stack underflow
        }
    }
}
