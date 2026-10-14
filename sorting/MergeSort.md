# Merge Sort

**Idea:** Divide and conquer. Split in half, sort each half, merge the two sorted halves.

**Steps:**
1. If `low >= high` → return (base case).
2. `mid = low + (high-low)/2`; sort left half, sort right half.
3. Merge: two pointers `i`, `j` pick the smaller front element into a temp array, then copy back.

**Intuition:** Merging two sorted lists takes O(n). The array is halved log n times, so total O(n log n).

**Complexity:** Time O(n log n) in **all** cases. Space O(n) for the temp array (+ O(log n) stack).
**Stable?** Yes, if you take from the left half on ties (`<=`).

**When to use:** Guaranteed O(n log n), stability needed, linked lists (merges in O(1) extra space), external sorting. It's also the base for counting inversions.

**Edge cases:** Empty, single element, duplicates, negatives, already sorted.

**Interview traps**
- `mid = (low+high)/2` can overflow. Use `low + (high-low)/2`.
- Allocate the temp array **once**, not inside every recursive call.
- `<=` in merge for stability.
- Not in-place for arrays. Say so when asked.

**How to explain:** "Recursively halve, then merge sorted halves with two pointers. Always O(n log n), stable, but needs O(n) extra space."
