import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/** Heaps (theory): array representation, min vs max heap, and Java's PriorityQueue in practice */
public class HeapBasics {

    // A heap is a COMPLETE binary tree stored in an array. For index i (0-based):
    static int parent(int i) { return (i - 1) / 2; }
    static int left(int i)   { return 2 * i + 1; }
    static int right(int i)  { return 2 * i + 2; }

    static class Task {
        String name;
        int priority;
        Task(String n, int p) { name = n; priority = p; }
        public String toString() { return name + ":" + priority; }
    }

    public static void main(String[] args) {
        // index layout of [10, 20, 30, 40, 50]:   10
        //                                        /    \
        //                                      20      30
        //                                     /  \
        //                                   40    50
        System.out.println(parent(4) + " " + left(1) + " " + right(1));          // 1 3 4

        // MIN-heap: every parent <= its children, so the SMALLEST is at the root. peek O(1), offer/poll O(log n)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : new int[]{5, 1, 8, 3, 2}) minHeap.offer(x);
        System.out.println(minHeap.peek());                                      // 1
        List<Integer> sorted = new ArrayList<>();
        while (!minHeap.isEmpty()) sorted.add(minHeap.poll());
        System.out.println(sorted);                                              // [1, 2, 3, 5, 8]  (repeated poll = heap sort)

        // MAX-heap: reverse the comparator. Prefer Collections.reverseOrder() / Integer.compare over (a, b) -> b - a (overflow!)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : new int[]{5, 1, 8, 3, 2}) maxHeap.offer(x);
        System.out.println(maxHeap.poll() + " " + maxHeap.poll());               // 8 5

        // Custom objects: supply a comparator
        PriorityQueue<Task> tasks = new PriorityQueue<>((a, b) -> Integer.compare(a.priority, b.priority));
        tasks.offer(new Task("write", 3));
        tasks.offer(new Task("test", 1));
        tasks.offer(new Task("ship", 2));
        System.out.println(tasks.poll() + " " + tasks.poll() + " " + tasks.poll());   // test:1 ship:2 write:3

        // PITFALL 1: iterating / printing a PriorityQueue is NOT sorted (only the root is guaranteed)
        PriorityQueue<Integer> h = new PriorityQueue<>(Arrays.asList(5, 1, 8, 3, 2));
        System.out.println(h);                                                   // heap array order, e.g. [1, 2, 8, 5, 3]
        // PITFALL 2: remove(Object) is O(n); contains is O(n). A heap is not a search structure.
        // PITFALL 3: the comparator (a, b) -> b - a overflows for large/negative ints. Use Integer.compare(b, a).
        PriorityQueue<Integer> wrong = new PriorityQueue<>((a, b) -> b - a);
        wrong.offer(Integer.MIN_VALUE);
        wrong.offer(1);
        System.out.println(wrong.poll());                                        // WRONG: prints -2147483648 instead of 1
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        right.offer(Integer.MIN_VALUE);
        right.offer(1);
        System.out.println(right.poll());                                        // 1
    }
}
