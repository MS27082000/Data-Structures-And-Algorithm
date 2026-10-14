# Minimum Falling Path Sum (LC 931)

**Problem:** Start anywhere in the top row; move down to the cell directly below or diagonally left/right. Minimum sum to reach the last row.

**Intuition:** `f(r,c) = matrix[r][c] + min(f(r-1,c-1), f(r-1,c), f(r-1,c+1))`. The answer is the minimum of the last row.

**Brute force:** Recursion with 3 branches, O(3^n).
**Optimised:** Row by row, O(n^2) time, O(n) space.

**Edge cases:** 1x1 matrix. Negative values. Border columns have only two parents.

**Interview traps**
- Check column bounds before reading `c-1` / `c+1`.
- The answer is the **min of the last row**, not the corner.

**How to explain:** "Every cell takes the cheapest of its three parents above. I roll two rows and finally pick the smallest total in the last row."
