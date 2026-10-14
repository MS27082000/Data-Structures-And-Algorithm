# Minimum Subset Sum Difference

**Problem:** Split into two subsets so that the absolute difference of their sums is minimum.

**Intuition:** If one side has sum s, the difference is `total - 2s`. Find all reachable sums (subset-sum table) and take the one closest to `total/2` (the largest reachable `s <= total/2`).

**Brute force:** All subsets, O(2^n).
**Optimised:** O(n * total) time, O(total) space.

**Edge cases:** One element -> that element. Zeros. Perfect split -> 0.

**Interview traps**
- Only look at sums up to `total/2` (the other side is symmetric).
- The dp table is over the whole total, not a given target.

**How to explain:** "I compute every achievable subset sum, then pick the one nearest half the total."
