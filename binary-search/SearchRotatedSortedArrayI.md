# Search in Rotated Sorted Array I (LC 33)

**Problem:** A sorted array of **distinct** values was rotated at an unknown pivot (`[4,5,6,7,0,1,2]`). Find `target`'s index in O(log n).

**Brute force:** Linear scan → O(n).
**Two-pass:** Find the pivot (minimum) with binary search, then binary search the correct half → O(log n), two searches.
**Optimal (one pass):** At every step **at least one half is sorted**. Decide which, check if the target lies in it, and go there or to the other half.

**Steps:** If `a[low] <= a[mid]` the left half is sorted: if `a[low] <= target < a[mid]` → go left else right. Otherwise the right half is sorted: if `a[mid] < target <= a[high]` → go right else left.

**Intuition:** Rotation breaks the order in only one place, so any window `[low, high]` has a sorted half you can reason about with plain comparisons.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** Not rotated, size 1 or 2 (`[3,1]` needs `<=` in `a[low] <= a[mid]`), target absent, target at the pivot.

**Interview traps**
- Use `a[low] <= a[mid]` (with `=`) to handle a 2-element window.
- Range checks need the right mix of `<=` and `<` (the target can equal `a[low]` or `a[high]` but `a[mid]` was already checked).
- Duplicates break this logic. That's Search in Rotated Sorted Array II.

**How to explain:** "One half is always sorted. I see which, check whether the target falls inside it, and discard the other half."
