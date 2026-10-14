import java.util.Arrays;

/** Implement a Min Heap (array-backed): insert, peek, extractMin, size */
public class MinHeap {

    private int[] a = new int[8];
    private int size = 0;

    // Insert at the end, then SIFT UP. O(log n) (amortised, counting the occasional array doubling)
    void insert(int x) {
        if (size == a.length) a = Arrays.copyOf(a, size * 2);
        a[size] = x;
        siftUp(size++);
    }

    int peek() {
        if (size == 0) throw new IllegalStateException("heap is empty");
        return a[0];
    }

    // Take the root, move the LAST element to the root, then SIFT DOWN. O(log n)
    int extractMin() {
        if (size == 0) throw new IllegalStateException("heap is empty");
        int min = a[0];
        a[0] = a[--size];
        if (size > 0) siftDown(0);
        return min;
    }

    int size() { return size; }
    boolean isEmpty() { return size == 0; }

    private void siftUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (a[p] <= a[i]) break;
            swap(p, i);
            i = p;
        }
    }

    private void siftDown(int i) {
        while (true) {
            int smallest = i, l = 2 * i + 1, r = 2 * i + 2;
            if (l < size && a[l] < a[smallest]) smallest = l;
            if (r < size && a[r] < a[smallest]) smallest = r;
            if (smallest == i) break;
            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap();
        for (int x : new int[]{5, 3, 8, 1, 9, 2, 7, 4, 6, 0}) h.insert(x);       // 10 inserts force the array to grow from 8
        System.out.println(h.peek() + " " + h.size());                           // 0 10
        StringBuilder sb = new StringBuilder();
        while (!h.isEmpty()) sb.append(h.extractMin()).append(' ');
        System.out.println(sb.toString().trim());                                // 0 1 2 3 4 5 6 7 8 9
        h.insert(4);
        h.insert(4);
        System.out.println(h.extractMin() + " " + h.extractMin() + " " + h.isEmpty());   // 4 4 true (duplicates fine)
        try {
            h.extractMin();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());                                  // heap is empty
        }
    }
}
