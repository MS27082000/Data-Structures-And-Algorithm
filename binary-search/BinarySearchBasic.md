# Search X in a Sorted Array (Binary Search, LC 704)

**Problem:** Find the index of `target` in a sorted array, or -1.

**Brute force:** Linear scan → O(n).
**Optimal:** Binary search → O(log n) time, O(1) space (iterative).

**Approach:** Keep `[low, high]`. Look at `mid`: equal → found; `a[mid] < target` → search right (`low = mid + 1`); else left (`high = mid - 1`).

**Intuition:** Sorted order means each comparison discards half of the remaining elements.

**Complexity:** Time O(log n), Space O(1) (O(log n) stack if recursive).

**Edge cases:** Empty array, single element, target smaller or larger than everything, target at the ends.

**Interview traps**
- `mid = low + (high - low) / 2`, **not** `(low + high) / 2` (can overflow).
- `while (low <= high)` with `mid ± 1` updates. Mixing styles causes infinite loops.
- Requires **sorted** input. State that assumption.
- With duplicates it returns *some* index, not necessarily the first (use lower bound for that).

**How to explain:** "Compare with the middle, throw away the half that can't contain the target, repeat. O(log n)."
