# Find Minimum in Rotated Sorted Array (LC 153)

**Problem:** A sorted array of distinct values was rotated. Find the minimum in O(log n).

**Brute force:** Scan → O(n).
**Optimal:** Binary search comparing `a[mid]` with `a[high]`.

**Approach:** `while (low < high)`: if `a[mid] > a[high]` the minimum is in the right part → `low = mid + 1`; else `mid` could be the minimum → `high = mid`. Return `a[low]`.

**Intuition:** If the middle is larger than the last element, the "drop" (rotation point) lies to its right. Otherwise the right part is sorted and the minimum is `mid` or to its left.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** Not rotated (`low` ends at 0), one element, two elements, minimum at the last index.

**Interview traps**
- Compare with `a[high]`, **not** `a[low]`. Comparing with `a[low]` is ambiguous when the array isn't rotated.
- `high = mid` (not `mid - 1`) and `low < high`, or you could skip the answer.
- **Duplicates (LC 154):** when `a[mid] == a[high]`, do `high--`. Worst case O(n).

**How to explain:** "If mid is bigger than the right end, the minimum is to the right; otherwise it's at mid or to the left. I narrow until one element remains."
