# Sort a K-Sorted Array

**Problem:** Each element of the array is at most `k` positions away from its position in the sorted order. Sort the array efficiently.

**Brute force:** Sort normally → O(n log n).
**Optimal:** The element that belongs at index `i` is among `a[i .. i + k]`. Keep a **min-heap of size `k + 1`**: after inserting `a[i]`, once the heap has `k + 1` elements, **poll the minimum**. It is guaranteed to be the next element of the sorted output. Finally drain the heap → **O(n log k)** time, O(k) space.

**Intuition:** Because nobody is more than `k` places from home, the smallest of any window of `k + 1` consecutive unsorted elements must be the next sorted value.

**Complexity:** Time O(n log k), Space O(k). Better than O(n log n) when `k` is small.

**Edge cases:** `k = 0` (already sorted), `k ≥ n` (reduces to heap sort, O(n log n)), empty array, duplicates.

**Interview traps**
- Heap size is **`k + 1`**, not `k`.
- **Drain the remaining elements** after the loop.
- Ask: "k-sorted" can mean "within k positions" (as here) or "k-sorted lists to merge". Don't confuse the two.
- This is insertion sort's best case generalised: insertion sort is O(nk) here, the heap makes it O(n log k).

**How to explain:** "The next smallest element must be within the next k + 1 positions, so I keep a min-heap of that many elements, repeatedly output the minimum, and slide the window forward."
