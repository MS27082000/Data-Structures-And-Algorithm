# Count Square Submatrices with All Ones (LC 1277)

**Problem:** Count all square sub-matrices that contain only 1s.

**Intuition:** `dp[i][j]` = side of the largest all-ones square with its **bottom-right corner** at (i,j) = `1 + min(top, left, top-left)`. A corner with side k is the corner of exactly k squares (sizes 1..k), so the answer is the **sum of all dp values**.

**Brute force:** Check every square, O(m*n*min(m,n)^2).
**Optimised:** O(m*n) time, O(m*n) space (O(n) possible).

**Edge cases:** All zeros -> 0. First row/column cells are 1 if the cell is 1.

**Interview traps**
- Sum all dp cells, not just the maximum (that would be Maximal Square).
- The `min` of three neighbours - not the sum.

**How to explain:** "dp at a cell is the biggest square ending there; it also equals the number of squares ending there, so I add them all."
