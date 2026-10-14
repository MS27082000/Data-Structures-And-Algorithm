# Count Partitions with Given Difference

**Problem:** Count ways to split the array into S1 and S2 with `S1 - S2 = d`.

**Intuition:** `S1 + S2 = total` and `S1 - S2 = d` -> `S1 = (total + d) / 2`. So count subsets with sum `(total + d) / 2`.

**Brute force:** O(2^n).
**Optimised:** O(n * target) time, O(target) space.

**Edge cases:** `total < d` or `(total + d)` odd -> 0. `d = 0` counts each split from both sides. Zeros.

**Interview traps**
- Do the validity checks first.
- Same pattern as Target Sum - say so.

**How to explain:** "Two equations give a single target sum for S1, then it is Count Subsets with Sum K."
