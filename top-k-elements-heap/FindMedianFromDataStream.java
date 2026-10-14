import java.util.Collections;
import java.util.PriorityQueue;

/** Find Median from Data Stream (LC 295): addNum(x) in O(log n), findMedian() in O(1) */
public class FindMedianFromDataStream {

    // Two heaps split the numbers around the median:
    //   `low`  = MAX-heap holding the smaller half,   `high` = MIN-heap holding the larger half.
    // Invariants: every element of low <= every element of high, and low.size() == high.size() or low.size() == high.size() + 1.
    private final PriorityQueue<Integer> low = new PriorityQueue<>(Collections.reverseOrder());
    private final PriorityQueue<Integer> high = new PriorityQueue<>();

    void addNum(int num) {
        low.offer(num);                         // 1) put it in the lower half...
        high.offer(low.poll());                 // 2) ...then move that half's maximum up, so the halves stay ordered
        if (high.size() > low.size()) low.offer(high.poll());   // 3) rebalance: low may hold one extra element
    }

    double findMedian() {
        if (low.isEmpty()) throw new IllegalStateException("no data");
        if (low.size() > high.size()) return low.peek();                       // odd count: the extra element of `low`
        return ((long) low.peek() + high.peek()) / 2.0;                         // even count: mean of the two middle values
    }

    public static void main(String[] args) {
        FindMedianFromDataStream m = new FindMedianFromDataStream();
        m.addNum(1);
        m.addNum(2);
        System.out.println(m.findMedian());      // 1.5
        m.addNum(3);
        System.out.println(m.findMedian());      // 2.0
        FindMedianFromDataStream n = new FindMedianFromDataStream();
        for (int x : new int[]{5, 15, 1, 3}) {
            n.addNum(x);
            System.out.print(n.findMedian() + " ");   // 5.0 10.0 5.0 4.0
        }
        System.out.println();
        FindMedianFromDataStream big = new FindMedianFromDataStream();
        big.addNum(Integer.MAX_VALUE);
        big.addNum(Integer.MAX_VALUE);
        System.out.println(big.findMedian());    // 2.147483647E9  (the sum is computed in long: no overflow)
    }
}
