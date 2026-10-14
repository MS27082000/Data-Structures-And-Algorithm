# Heap Sort

**Problem:** Sort an array in ascending order using a heap.

**Algorithm (in place):**
1. **Build a max-heap** from the array in O(n).
2. For `end = n−1` down to `1`: **swap `a[0]` (the maximum) with `a[end]`**, shrink the heap size to `end`, and **sift the new root down** (heapify on the first `end` elements).
The sorted region grows from the **back** of the array.

**Intuition:** The max-heap always exposes the largest remaining element at the root. Swapping it to the end places it in its final position, and the rest remains a heap after one sift-down.

**Complexity:**
| | Time | Space |
|---|---|---|
| Best / Average / **Worst** | **O(n log n)** | **O(1)** |
**Stable?** No (the swaps jump over equal elements).

**Heap sort vs others**
- vs **Merge sort:** same O(n log n) worst case, but O(1) space (merge sort needs O(n)); merge sort is stable, heap sort is not.
- vs **Quick sort:** guaranteed O(n log n) (quick sort can degrade to O(n²)), but quick sort is faster in practice (better cache behaviour, fewer swaps).

**Edge cases:** Empty and one-element arrays, duplicates, already sorted, reverse sorted.

**Interview traps**
- **Max-heap** for an ascending sort (a min-heap would sort descending in place, or need an extra array).
- Heapify on the **reduced size** `end`, not `n`. Otherwise you pull sorted elements back into the heap.
- Not stable and not cache-friendly. Say so if asked "why isn't it the default?".
- Used in **introsort** as the fallback when quick sort recursion gets too deep.

**How to explain:** "I build a max-heap, then repeatedly swap the root, which is the largest, to the end of the array and restore the heap on what's left. That sorts in place in O(n log n) with no extra memory."
