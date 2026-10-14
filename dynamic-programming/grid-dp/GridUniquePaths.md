# Grid Unique Paths (LC 62)

**Problem:** m x n grid, move only right or down from top-left to bottom-right. Count the paths.

**Intuition:** A cell is reached from above or from the left: `f(r,c) = f(r-1,c) + f(r,c-1)`. First row and column are all 1.

**Brute force:** Recursion, O(2^(m+n)).
**Optimised:** Table O(m*n); one rolling row -> O(n) space. **Maths:** every path has (m-1) downs and (n-1) rights -> `C(m+n-2, m-1)` in O(min(m,n)).

**Edge cases:** 1 x n or m x 1 -> 1 path. 1 x 1 -> 1.

**Interview traps**
- In the combination formula multiply then divide step by step to keep it exact and avoid overflow.
- With obstacles the formula no longer works - use DP (see Unique Paths II).

**How to explain:** "Each cell's count is the sum of the cell above and the cell to the left. I keep only one row."
