# Search in Rotated Sorted Array II (LC 81)

**Problem:** Same as version I, but the array **may contain duplicates**. Return `true`/`false` if the target exists.

**Brute force:** Linear scan → O(n).
**Optimal:** Same sorted-half logic, plus a tie-breaker: if `a[low] == a[mid] == a[high]`, we can't tell which half is sorted, so do `low++; high--`.

**Intuition:** With `[1,1,1,0,1]` or `[1,0,1,1,1]`, equal ends hide where the rotation is. Shrinking both ends by one is safe because `a[mid] != target` was already checked, so the removed elements can't be the target.

**Complexity:** Time O(log n) average, **O(n) worst case** (all equal). Space O(1).

**Edge cases:** All elements equal, target absent, duplicates at the pivot, not rotated.

**Interview traps**
- The worst case degrades to O(n). Say so. It is unavoidable.
- Check `a[mid] == target` **before** the trimming step.
- Without the trim, you pick the wrong sorted half and miss the target.
- Returns boolean (not an index) in this version.

**How to explain:** "Same as the distinct version, but when low, mid, and high are all equal I can't tell which half is sorted, so I shrink both ends. Worst case O(n)."
