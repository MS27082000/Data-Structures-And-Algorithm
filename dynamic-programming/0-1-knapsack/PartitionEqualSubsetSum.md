# Partition Equal Subset Sum (LC 416)

**Problem:** Can the array be split into two subsets with equal sum?

**Intuition:** Total must be even; then find a subset with sum `total/2` (subset sum).

**Brute force:** All subsets, O(2^n).
**Optimised:** O(n * total/2) time, O(total/2) space. Exit early once the target is reachable.

**Edge cases:** Odd total -> false. One element -> false. Total even but no such subset (e.g. `[2,2,3,5]`).

**Interview traps**
- Check parity first - it is an instant answer.
- Downward loop over sums.

**How to explain:** "Equal halves means each half is total/2, so I just ask whether some subset reaches total/2."
