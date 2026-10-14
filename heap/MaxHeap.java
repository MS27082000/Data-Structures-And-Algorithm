import java.util.Arrays;

/** Implement a Max Heap (array-backed): insert, peek, extractMax, size. Mirror image of the min heap */
public class MaxHeap {

    private int[] a = new int[8];
    private int size = 0;

    void insert(int x) {
        if (size == a.length) a = Arrays.copyOf(a, size * 2);
        a[size] = x;
        siftUp(size++);
    }

    int peek() {
        if (size == 0) throw new IllegalStateException("heap is empty");
        return a[0];
    }

    int extractMax() {
        if (size == 0) throw new IllegalStateException("heap is empty");
        int max = a[0];
        a[0] = a[--size];
        if (size > 0) siftDown(0);
        return max;
    }

    // Raise an existing element's value (for max-heaps this is the natural "increase key"): O(log n) once you know its index
    void increaseKey(int i, int newValue) {
        if (newValue < a[i]) throw new IllegalArgumentException("new value is smaller");
        a[i] = newValue;
        siftUp(i);
    }

    int size() { return size; }
    boolean isEmpty() { return size == 0; }

    private void siftUp(int i) {
        while (i > 0) {
            int p = (i - 1) / 2;
            if (a[p] >= a[i]) break;
            swap(p, i);
            i = p;
        }
    }

    private void siftDown(int i) {
        while (true) {
            int largest = i, l = 2 * i + 1, r = 2 * i + 2;
            if (l < size && a[l] > a[largest]) largest = l;
            if (r < size && a[r] > a[largest]) largest = r;
            if (largest == i) break;
            swap(i, largest);
            i = largest;
        }
    }

    private void swap(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        for (int x : new int[]{5, 3, 8, 1, 9, 2, 7, 4, 6, 0}) h.insert(x);
        System.out.println(h.peek() + " " + h.size());                          // 9 10
        StringBuilder sb = new StringBuilder();
        while (!h.isEmpty()) sb.append(h.extractMax()).append(' ');
        System.out.println(sb.toString().trim());                               // 9 8 7 6 5 4 3 2 1 0
        h.insert(-5);
        h.insert(100);
        h.insert(-5);
        System.out.println(h.extractMax() + " " + h.extractMax() + " " + h.extractMax());   // 100 -5 -5
        try {
            h.extractMax();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());                                 // heap is empty
        }
    }
}
