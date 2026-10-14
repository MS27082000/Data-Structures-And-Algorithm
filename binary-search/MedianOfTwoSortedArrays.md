# Median of Two Sorted Arrays (LC 4)

**Problem:** Two sorted arrays of sizes `m` and `n`. Return the median of the combined sorted array in **O(log(min(m, n)))**.

**Brute force:** Merge both and take the middle → O(m + n) time, O(m + n) space.
**Better:** Merge with two pointers up to the middle only → O(m + n) time, O(1) space.
**Optimal:** **Binary search the partition** of the smaller array.

**Approach:** Take `i` elements from `a` and `j = (m + n + 1)/2 - i` from `b` as the combined left half. The partition is valid when
`a[i-1] <= b[j]` and `b[j-1] <= a[i]`.
- If `a[i-1] > b[j]` → took too many from `a` → `high = i - 1`.
- Else if `b[j-1] > a[i]` → took too few → `low = i + 1`.
- Odd total → `max(a[i-1], b[j-1])`. Even → average of that max and `min(a[i], b[j])`.

**Intuition:** The median splits the merged data into two equal halves where everything on the left is `<=` everything on the right. Choosing `i` determines `j`, so we binary search only `i`.

**Complexity:** Time O(log min(m, n)), Space O(1).

**Edge cases:** One array empty, total odd vs even, all equal, `i = 0` or `i = m` (use ±∞ sentinels), very large values (use `double`, and cast before adding to avoid overflow).

**Interview traps**
- **Always binary search the smaller array**, which also keeps `j` in range.
- Use `Integer.MIN_VALUE` / `MAX_VALUE` sentinels for empty sides.
- `half = (m + n + 1) / 2` makes the left side the larger one for odd totals.
- Average of two ints: add as `double` to avoid overflow.

**How to explain:** "I binary search how many elements to take from the smaller array for the left half, so that the max of the left side is at most the min of the right side. The median comes from those boundary values."
