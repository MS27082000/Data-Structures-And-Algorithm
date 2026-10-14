# Search a 2D Matrix II (LC 240)

**Problem:** An `m x n` matrix where each row is sorted left to right and each column is sorted top to bottom. Does `target` exist?

**Brute force:** Scan everything → O(m·n).
**Better:** Binary search each row → O(m log n).
**Optimal:** **Staircase search** from the top-right corner → O(m + n).

**Approach:** Start at `(0, n-1)`. If the value is too large → `col--` (the rest of this column is even larger). If too small → `row++` (the rest of this row to the left is even smaller). Equal → found.

**Intuition:** The top-right element is the largest in its row and the smallest in its column, so each comparison eliminates an entire row or column.

**Complexity:** Time O(m + n), Space O(1).

**Edge cases:** Single row or column, target outside the range, empty matrix, target at corners.

**Interview traps**
- This is **not** Search 2D Matrix I. Rows don't chain into one sorted sequence, so flattening fails.
- Start from the **top-right** (or bottom-left). Starting from the top-left gives no decision rule (both directions increase).
- Binary search on the whole matrix doesn't work here.

**How to explain:** "From the top-right corner, a bigger value means move left and a smaller value means move down. Each step removes a row or a column, so it's O(m + n)."
