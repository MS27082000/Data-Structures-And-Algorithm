# Build a Heap from a Given Array

**Problem:** Turn an arbitrary array into a heap (in place).

**Naive:** Insert the elements one at a time with sift-up → **O(n log n)**.
**Optimal (Floyd's bottom-up):** Heapify every **internal** node, from the **last internal node `n/2 − 1` down to the root `0`**. Leaves are already heaps of size 1 → **O(n)** time, O(1) space.

**Why O(n), not O(n log n):** The cost of heapifying a node is proportional to its **height**, not to log n. About n/2 nodes have height 0 (leaves, free), n/4 have height 1, n/8 have height 2, … The sum `Σ (n / 2^(h+1)) · h` converges to **O(n)**.

**Intuition:** Going bottom-up guarantees that when you heapify a node its two subtrees are already heaps, which is exactly the precondition of heapify.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty array, one element, already a heap, reverse-sorted input (maximum work).

**Interview traps**
- Start at `n/2 − 1`, **not** at `n − 1` or at 0. Going top-down breaks the precondition.
- The loop runs **downwards** (`i--`).
- Two different valid heaps can come from the same input (build-by-insertion vs bottom-up), so don't compare outputs directly. Check the heap property.
- This is the first step of **heap sort**.

**How to explain:** "I heapify each non-leaf node from the last one up to the root, so every subtree is already a heap when I process its parent. Most nodes are near the bottom and sink only a little, which makes the total O(n)."
