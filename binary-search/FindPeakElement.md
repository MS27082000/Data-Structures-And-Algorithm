# Find Peak Element (LC 162)

**Problem:** Return the index of **any** element strictly greater than its neighbours (treat `a[-1]` and `a[n]` as -∞). Adjacent elements are never equal. Must be O(log n).

**Brute force:** Linear scan comparing neighbours → O(n).
**Optimal:** Binary search following the **upward slope**.

**Approach:** `while (low < high)`: if `a[mid] < a[mid+1]` we're on an uphill, so a peak exists to the right → `low = mid + 1`. Else a peak exists at `mid` or to the left → `high = mid`.

**Intuition:** Walking uphill you must eventually reach a peak, since the array ends at -∞. So you can discard the side you're sure to find one on... without sorting.

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** Single element (index 0), two elements, strictly increasing (last index), strictly decreasing (index 0), multiple peaks (any is valid).

**Interview traps**
- This works **even though the array isn't sorted**. Explain the "slope" argument.
- The boundary condition (-∞ outside) guarantees a peak always exists.
- Compare with `mid + 1` (safe because `mid < high`).
- The 2D version (Find Peak Element II) extends this to a grid.

**How to explain:** "If the next element is bigger, a peak must lie to the right. Otherwise one lies at mid or to the left. I narrow toward the uphill direction."
