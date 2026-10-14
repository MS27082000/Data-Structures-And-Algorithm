/** Implement a Queue using a Linked List: keep BOTH head and tail so enqueue (at the tail) and dequeue (at the head) are O(1) */
public class QueueUsingLinkedList {

    private static class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    private Node head, tail;
    private int size;

    void enqueue(int x) {
        Node n = new Node(x);
        if (tail == null) head = tail = n;   // first element is both head and tail
        else {
            tail.next = n;
            tail = n;
        }
        size++;
    }

    int dequeue() {
        if (head == null) throw new IllegalStateException("Queue underflow");
        int x = head.val;
        head = head.next;
        if (head == null) tail = null;       // TRAP: the queue became empty, so the tail must be cleared too
        size--;
        return x;
    }

    int peek() {
        if (head == null) throw new IllegalStateException("Queue is empty");
        return head.val;
    }

    boolean isEmpty() { return head == null; }
    int size() { return size; }

    public static void main(String[] args) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.peek() + " " + q.size());                  // 1 3
        System.out.println(q.dequeue() + " " + q.dequeue());             // 1 2
        q.enqueue(4);
        System.out.println(q.dequeue() + " " + q.dequeue());             // 3 4
        System.out.println(q.isEmpty());                                 // true
        q.enqueue(7);                                                    // works again after becoming empty (tail was reset)
        System.out.println(q.peek());                                    // 7
    }
}
