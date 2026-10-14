# Rotate Matrix by 90 Degrees (LC 48)

**Problem:** Rotate an `n x n` matrix 90° clockwise **in place**.

**Brute force:** New matrix with `res[j][n-1-i] = m[i][j]` → O(n²) time, O(n²) space.
**Optimal:** **Transpose** (swap `m[i][j]` with `m[j][i]`), then **reverse each row** → O(n²) time, O(1) space.

**Intuition:** Clockwise rotation maps `(i, j) → (j, n-1-i)`. Transposing gives `(j, i)`, and reversing each row turns the column index `i` into `n-1-i`.

**Complexity:** Time O(n²), Space O(1).

**Edge cases:** 1x1, 2x2, odd vs even `n`.

**Interview traps**
- In the transpose loop start `j` at `i+1`. Otherwise you swap every pair twice and undo it.
- **Anticlockwise:** transpose, then reverse each *column* (or reverse each row first, then transpose).
- Know the 4-way cycle swap alternative, which is harder to write but one pass.

**How to explain:** "Rotating clockwise is a transpose followed by reversing every row. Both steps are in place."
