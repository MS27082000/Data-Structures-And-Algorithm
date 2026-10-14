# Convert a Min Heap to a Max Heap

**Problem:** The array represents a min-heap. Rearrange it so that it represents a **max-heap**.

**Approach:** The min-heap ordering gives no useful structure for a max-heap, so treat the array as arbitrary and **build a max-heap bottom-up**: `maxHeapify` every internal node from `n/2 − 1` down to `0` → **O(n)** time, O(1) space.

**Why not something cleverer:** Reversing the array does not work. A min-heap's leaves hold large values but not necessarily in an order that satisfies a max-heap, and no known approach beats building from scratch. The bound O(n) is already optimal since every element must be examined.

**Intuition:** A max-heap is just a different arrangement of the **same multiset of values**. The old heap order doesn't help, so rebuild it.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** One element, two elements, duplicates, already a valid max-heap.

**Interview traps**
- The answer isn't unique. **Verify the max-heap property and that the multiset is unchanged**, not an exact array.
- Don't do it by repeated extract-min/insert (that's O(n log n)).
- Same technique converts max→min: just flip the comparison.

**How to explain:** "A min-heap's order doesn't help a max-heap, so I rebuild: I run max-heapify on every non-leaf node from the last one up to the root, which takes O(n)."
