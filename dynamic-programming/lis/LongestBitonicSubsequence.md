# Longest Bitonic Subsequence

**Problem:** Longest subsequence that strictly increases then strictly decreases.

**Intuition:** `inc[i]` = LIS ending at i. `dec[i]` = longest decreasing subsequence starting at i (LIS from the right). A peak at i gives `inc[i] + dec[i] - 1` (peak counted twice).

**Brute force:** All subsequences.
**Optimised:** O(n^2) time, O(n) space.

**Edge cases:** All increasing or all decreasing (the other part is just the peak). All equal -> 1.

**Interview traps**
- Subtract 1 for the shared peak.
- Decide whether pure increasing/decreasing counts as bitonic (here yes).

**How to explain:** "Best chain going up to i plus best chain going down from i, minus the peak counted twice."
