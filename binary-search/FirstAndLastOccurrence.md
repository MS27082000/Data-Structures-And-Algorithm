# First and Last Occurrence (LC 34)

**Problem:** In a sorted array (with duplicates) return `[first, last]` index of `target`, or `[-1, -1]`.

**Brute force:** Scan once → O(n). It's fine for small arrays, but fails the O(log n) requirement.
**Optimal:** Two binary searches: `first = lowerBound(x)` (check that `a[first] == x`), `last = upperBound(x) - 1`.

**Intuition:** All copies of `x` sit in one block. Lower bound lands on its left edge and upper bound just past its right edge.

**Alternative:** A modified binary search that, on `a[mid] == x`, records the answer and keeps going left (for first) or right (for last).

**Complexity:** Time O(log n), Space O(1).

**Edge cases:** Target absent, empty array, single element, all elements equal to target, target only at the ends.

**Interview traps**
- After `lowerBound`, **verify** `first < n && a[first] == x` before trusting it.
- Don't find one occurrence and then expand linearly. That's O(n) worst case.
- `count = last - first + 1` is the follow-up (see Count Occurrences).

**How to explain:** "Two binary searches: one for the first index not less than x, one for the first index greater than x, minus one. If the first isn't actually x, return -1."
