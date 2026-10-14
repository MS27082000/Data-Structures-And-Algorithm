import java.util.*;

/** Java Collections cheat sheet: the structures and methods used in almost every DSA solution */
public class JavaCollections {

    public static void main(String[] args) {
        // List: ordered, index access. ArrayList = dynamic array (get O(1), add at end O(1) amortised), LinkedList = doubly linked
        List<Integer> list = new ArrayList<>(List.of(3, 1, 2));
        list.add(5);
        Collections.sort(list);
        System.out.println(list + " " + list.get(0) + " " + list.contains(2));        // [1, 2, 3, 5] 1 true

        // Set: no duplicates. HashSet O(1) average, unordered; TreeSet sorted O(log n); LinkedHashSet keeps insertion order
        Set<Integer> hs = new HashSet<>(List.of(1, 2, 2, 3));
        TreeSet<Integer> ts = new TreeSet<>(hs);
        System.out.println(hs.size() + " " + ts.first() + " " + ts.floor(2) + " " + ts.ceiling(4));   // 3 1 2 null

        // Map: key -> value. HashMap O(1) average; TreeMap sorted by key; merge/getOrDefault avoid null checks
        Map<String, Integer> freq = new HashMap<>();
        for (String w : "a b a c a b".split(" ")) freq.merge(w, 1, Integer::sum);
        System.out.println(new TreeMap<>(freq));                                       // {a=3, b=2, c=1}

        // Stack / Queue / Deque: prefer ArrayDeque over the legacy Stack class
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1); stack.push(2);
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); queue.offer(2);
        System.out.println(stack.pop() + " " + queue.poll());                          // 2 1

        // PriorityQueue: min-heap by default; pass a comparator for a max-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(List.of(5, 1, 3));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(List.of(5, 1, 3));
        System.out.println(minHeap.poll() + " " + maxHeap.poll());                     // 1 5

        // Arrays / sorting with a comparator / String helpers
        int[][] intervals = {{3, 4}, {1, 2}};
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        System.out.println(Arrays.deepToString(intervals));                            // [[1, 2], [3, 4]]
        int[] filled = new int[3];
        Arrays.fill(filled, -1);
        System.out.println(Arrays.toString(filled));                                   // [-1, -1, -1]
        StringBuilder sb = new StringBuilder("abc").reverse();
        System.out.println(sb + " " + String.valueOf(new char[]{'x', 'y'}));           // cba xy

        // Pitfall: compare boxed Integers with equals(), not ==  (cache is only -128..127)
        Integer a = 1000, b = 1000;
        System.out.println(a.equals(b));                                               // true
    }
}
