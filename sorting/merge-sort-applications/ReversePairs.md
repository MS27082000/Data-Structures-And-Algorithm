# Reverse Pairs (LC 493)

**Problem:** Count pairs `(i, j)` with `i < j` and `nums[i] > 2 * nums[j]`.

**Brute force:** All pairs → O(n²).
**Optimal:** **Merge sort**, with a **separate counting pass before merging**. For each `i` in the left half, move `j` forward in the right half while `nums[i] > 2*nums[j]`. The right half is sorted, so `j` never goes backwards. Add `j - (mid+1)`. Then merge normally → O(n log n) time, O(n) space.

**Intuition:** Same as Count Inversions, but the condition is `> 2×`, which isn't the same as the merge comparison. So you can't count while merging. Count first (two-pointer sweep), merge after.

**Complexity:** Time O(n log n), Space O(n).

**Edge cases:** Overflow (`2 * Integer.MAX_VALUE`), negatives (`[-5, -5]` → 1), duplicates, empty array.

**Interview traps**
- **Cast to long:** `(long) a[i] > 2L * a[j]`. `2 * a[j]` overflows `int`.
- Don't try to count inside the merge loop, since the condition differs.
- Know the BIT / ordered-set alternative (O(n log n)), and the difference from Count Inversions.

**How to explain:** "Merge sort again. Before merging each pair of halves, a two-pointer sweep counts pairs where left is more than twice the right. Both halves are sorted, so the sweep is linear."
