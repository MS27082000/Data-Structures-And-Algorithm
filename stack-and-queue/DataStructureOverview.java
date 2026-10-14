import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/** Implementation using different data structures: which Java class to use for a stack, a queue, a deque, a priority queue */
public class DataStructureOverview {

    public static void main(String[] args) {
        // STACK (LIFO): prefer ArrayDeque. java.util.Stack is legacy (extends Vector, synchronised, slower)
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek() + " " + stack.pop() + " " + stack);      // 3 3 [2, 1]

        Stack<Integer> legacy = new Stack<>();                                    // works, but avoid in new code
        legacy.push(10);
        System.out.println(legacy.peek());                                        // 10

        // QUEUE (FIFO): ArrayDeque or LinkedList (LinkedList allows null elements, ArrayDeque doesn't)
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek() + " " + queue.poll() + " " + queue);      // 1 1 [2, 3]

        Queue<Integer> linked = new LinkedList<>();
        linked.add(7);
        System.out.println(linked.poll());                                        // 7

        // DEQUE: add/remove at both ends in O(1). Backs monotonic-queue problems (sliding window maximum)
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(1);
        deque.offerLast(2);
        deque.offerFirst(0);
        System.out.println(deque + " " + deque.pollLast() + " " + deque.pollFirst()); // [0, 1, 2] 2 0

        // PRIORITY QUEUE: min-heap by default. O(log n) offer/poll, O(1) peek. Max-heap via a reversed comparator
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int x : new int[]{5, 1, 8, 3}) {
            minHeap.offer(x);
            maxHeap.offer(x);
        }
        System.out.println(minHeap.poll() + " " + maxHeap.poll());                // 1 8

        // Behaviour on empty: pop() throws NoSuchElementException, poll()/peek() return null
        Deque<Integer> empty = new ArrayDeque<>();
        System.out.println(empty.peek() + " " + empty.poll());                    // null null
        try {
            empty.pop();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("pop() on empty throws");                          // pop() on empty throws
        }
    }
}
