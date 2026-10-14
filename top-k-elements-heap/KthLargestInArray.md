# K-th Largest Element in an Array (LC 215)

**Problem:** Return the k-th largest element in sorted order (duplicates count separately).

**Brute force:** Sort and index `n − k` → O(n log n).
**Min-heap of size k:** Push each element; whenever the size exceeds `k`, **poll** (the smallest). The root is then the k-th largest → **O(n log k)** time, O(k) space.
**Quickselect:** Partition around a pivot. The answer sits at index `n − k` of the sorted order, so recurse into **one side only** → **O(n) average**, O(n²) worst case (use a random pivot), O(1) space.

**Intuition (the inversion):** To keep the **k largest**, use a **min**-heap: its root is the *smallest of the k largest*, which is exactly the k-th largest, and it is the element to evict when something bigger arrives.

**Complexity:** Heap O(n log k) / O(k). Quickselect O(n) avg / O(1).

**Edge cases:** `k = 1` (maximum), `k = n` (minimum), duplicates, negatives, a single element.

**Interview traps**
- **Min-heap for k largest** (max-heap for k smallest). A max-heap of all n elements works but costs O(n log n).
- Quickselect needs a **random pivot** (or median of medians) to avoid the O(n²) worst case, and it **mutates** the array.
- k-th largest ≠ k-th **distinct** largest.
- State the trade-off: heap is simple and works on streams; quickselect is faster but offline.

**How to explain:** "I keep a min-heap of the k largest values seen so far. When it grows beyond k I drop the smallest. At the end the root is the k-th largest. Alternatively quickselect finds it in O(n) average."
