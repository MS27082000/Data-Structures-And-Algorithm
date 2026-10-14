# Find a Peak Element II (LC 1901)

**Problem:** An `m x n` grid where no two adjacent cells are equal. Find **any** cell strictly greater than its 4 neighbours (outside the grid counts as -1). Must be O(m log n) or O(n log m).

**Brute force:** Check every cell → O(m·n).
**Optimal:** **Binary search on columns.**
1. Take the middle column `mid`.
2. Find the row `r` with the **maximum** value in that column.
3. Compare `mat[r][mid]` with its left and right neighbours. If it's greater than both → peak.
4. Otherwise move toward the larger neighbour (`left > cur` → `high = mid - 1`, else `low = mid + 1`).

**Intuition:** The max of a column already beats its top and bottom neighbours, so only left/right matter. Moving toward a bigger neighbour keeps a peak inside the remaining columns, the same slope argument as the 1D problem.

**Complexity:** Time O(m log n), Space O(1).

**Edge cases:** Single cell, a single row or column, the peak at the border, multiple peaks (any is valid).

**Interview traps**
- Use the **column maximum**, not just `mat[mid][...]`. Otherwise vertical neighbours may be larger.
- Treat the out-of-grid neighbour as -1 (all values are non-negative).
- Don't confuse with the 1D version. Explain why the max-of-column trick reduces 2D to 1D.
- Returning any peak is fine, so different outputs from different valid approaches are acceptable.

**How to explain:** "I binary search over columns. In the middle column I take the largest element, so up and down are already smaller. Then I look left and right and move toward the larger neighbour, which always keeps a peak in range."
