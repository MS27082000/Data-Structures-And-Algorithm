/** Implement a Stack using a Linked List: the head is the top, so push and pop are O(1) with no capacity limit */
public class StackUsingLinkedList {

    private static class Node {
        int val;
        Node next;
        Node(int v, Node n) { val = v; next = n; }
    }

    private Node head;                       // top of the stack
    private int size;

    void push(int x) {
        head = new Node(x, head);            // new node points to the old top
        size++;
    }

    int pop() {
        if (head == null) throw new IllegalStateException("Stack underflow");
        int x = head.val;
        head = head.next;
        size--;
        return x;
    }

    int peek() {
        if (head == null) throw new IllegalStateException("Stack is empty");
        return head.val;
    }

    boolean isEmpty() { return head == null; }
    int size() { return size; }

    public static void main(String[] args) {
        StackUsingLinkedList s = new StackUsingLinkedList();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek() + " " + s.size());                 // 3 3
        System.out.println(s.pop() + " " + s.pop() + " " + s.pop());   // 3 2 1
        System.out.println(s.isEmpty());                               // true
        try {
            s.pop();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());                        // Stack underflow
        }
    }
}
