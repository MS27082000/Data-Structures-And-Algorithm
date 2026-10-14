/** Implement a Queue using an Array: a CIRCULAR buffer so freed slots at the front are reused. All operations O(1) */
public class QueueUsingArray {

    private final int[] data;
    private int front = 0;                   // index of the first element
    private int size = 0;

    QueueUsingArray(int capacity) {
        data = new int[capacity];
    }

    void enqueue(int x) {
        if (size == data.length) throw new IllegalStateException("Queue overflow");
        data[(front + size) % data.length] = x;        // next free slot, wrapping around
        size++;
    }

    int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue underflow");
        int x = data[front];
        front = (front + 1) % data.length;
        size--;
        return x;
    }

    int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return data[front];
    }

    boolean isEmpty() { return size == 0; }
    int size() { return size; }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.peek() + " " + q.size());                  // 1 3
        try {
            q.enqueue(4);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());                          // Queue overflow
        }
        System.out.println(q.dequeue() + " " + q.dequeue());             // 1 2
        q.enqueue(4);                                                    // reuses the freed front slots (wraps around)
        q.enqueue(5);
        System.out.println(q.dequeue() + " " + q.dequeue() + " " + q.dequeue()); // 3 4 5
        System.out.println(q.isEmpty());                                 // true
    }
}
