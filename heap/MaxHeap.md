# Implement a Max Heap

**Problem:** Implement a max-heap with `insert`, `peek` (get max), `extractMax`, `size`.

**Approach:** The mirror image of [Min Heap](MinHeap.md): flip every comparison.
- **insert(x):** append, then **sift up** while the parent is **smaller**.
- **extractMax():** return `a[0]`, move the last element to the root, **sift down** by swapping with the **larger** child while a child is larger.
- **increaseKey(i, v):** set `a[i] = v` (only if larger), then sift up → O(log n).

**Trick:** A max-heap of numbers is a min-heap of their **negatives**. Handy when a language only has a min-heap, or in Java `new PriorityQueue<>(Collections.reverseOrder())`.

**Complexity:** insert/extract O(log n), peek O(1), space O(n).

**Edge cases:** Empty heap, duplicates, negative values, one element.

**Interview traps**
- Sift down against the **larger** child.
- Don't negate `Integer.MIN_VALUE` (overflow) if using the negation trick. Use a reversed comparator.
- For a max-priority-queue the usual operations are `extractMax` and `increaseKey`; for min-heaps `extractMin` and `decreaseKey`.

**How to explain:** "Same array-based structure as the min-heap, but with the comparisons reversed: parents are at least as large as their children, so the maximum is at the root and extract-max sifts the replacement down."
