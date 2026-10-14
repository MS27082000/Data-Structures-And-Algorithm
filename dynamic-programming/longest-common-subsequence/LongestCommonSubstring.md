# Longest Common Substring

**Problem:** Longest **contiguous** block common to both strings.

**Intuition:** `dp[i][j]` = common substring length **ending** at i and j. Match -> `1 + dp[i-1][j-1]`; mismatch -> **0** (the run breaks). Answer = max over all cells.

**Brute force:** All substrings of one checked against the other, O(m*n*min).
**Optimised:** O(m*n) time, O(n) space.

**Edge cases:** No common char -> 0. One string empty.

**Interview traps**
- Reset to 0 on mismatch (LCS takes a max instead).
- The answer is the maximum cell, not `dp[m][n]`.

**How to explain:** "Same table as LCS, but a mismatch resets the run, and I track the largest value seen."
