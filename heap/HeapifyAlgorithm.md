# Heapify Algorithm

**Problem:** A node may violate the heap property, but **both of its subtrees are already valid heaps**. Fix the heap.

**Sift down (max-heapify at index i):** Compare `a[i]` with its children. If a child is larger, **swap with the larger child** and repeat from that child's position. Stop when the node is at least as big as both children (or is a leaf) → **O(log n)** (the height).
**Min-heapify:** the mirror image: swap with the **smaller** child.

**Sift up (after inserting at the end):** Compare with the parent; swap while the node is larger (max-heap) → O(log n).

**Intuition:** The out-of-place value sinks like a stone down the tree, always swapping with the child that is "better" so that child can legally move up into the parent's slot.

**Complexity:** Time O(log n), Space O(1) (iterative; recursion would use O(log n) stack).

**Edge cases:** A leaf (nothing to do), a node with only a left child, equal values (no swap needed), the root of a one-element heap.

**Interview traps**
- Swap with the **larger** child for a max-heap (smaller for min-heap). Swapping with the wrong child breaks the other subtree.
- Check **bounds** (`l < n`, `r < n`) before reading children.
- Heapify assumes the subtrees are already heaps. For an arbitrary array use [Build Heap](BuildHeap.md).
- Sift-down is used for **extract** and **heap sort**; sift-up is used for **insert**.

**How to explain:** "I compare the node with its children and swap it with the larger child if that child is bigger, then repeat at the child's position. The value sinks until the heap property holds, in O(log n)."
