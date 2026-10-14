/** Check if an Array Represents a Min Heap */
public class CheckMinHeap {

    // Only INTERNAL nodes (indices 0 .. (n-2)/2) have children, so check each against its children. O(n) time, O(1) space.
    // Checking just parent <= child at every internal node is enough: the property then holds transitively down the tree.
    static boolean isMinHeap(int[] a) {
        int n = a.length;
        for (int i = 0; i <= (n - 2) / 2; i++) {
            int l = 2 * i + 1, r = 2 * i + 2;
            if (l < n && a[i] > a[l]) return false;
            if (r < n && a[i] > a[r]) return false;
        }
        return true;
    }

    // Recursive version of the same check
    static boolean isMinHeapRec(int[] a, int i) {
        int n = a.length;
        if (i > (n - 2) / 2) return true;                                    // a leaf
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && a[i] > a[l]) return false;
        if (r < n && a[i] > a[r]) return false;
        return isMinHeapRec(a, l) && isMinHeapRec(a, r);
    }

    public static void main(String[] args) {
        System.out.println(isMinHeap(new int[]{10, 15, 14, 25, 30}));         // true
        System.out.println(isMinHeap(new int[]{30, 56, 22, 49, 30, 51, 2, 67})); // false
        System.out.println(isMinHeap(new int[]{5}));                          // true
        System.out.println(isMinHeap(new int[]{}));                           // true
        System.out.println(isMinHeap(new int[]{2, 2, 2}));                    // true (equal values are allowed)
        System.out.println(isMinHeap(new int[]{1, 3, 2, 4, 5, 6, 7}));        // true
        System.out.println(isMinHeapRec(new int[]{10, 15, 14, 25, 30}, 0));   // true
        System.out.println(isMinHeap(new int[]{1, 2, 3, 0}));                 // false (0 is below its parent 2)
    }
}
