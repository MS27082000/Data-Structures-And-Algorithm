# Set Matrix Zeroes (LC 73)

**Problem:** If a cell is 0, set its entire row and column to 0, in place.

**Brute force:** For every 0, immediately zero its row and column. This cascades and zeroes too much. Use a marker like `-1` for new zeros, then convert at the end → O(m·n·(m+n)).
**Better:** Two arrays `rowZero[m]`, `colZero[n]` → O(m·n) time, O(m+n) space.
**Optimal:** Use the **first row and first column as the marker arrays** → O(m·n) time, O(1) space.

**Steps:**
1. Remember separately whether the first row and first column originally contain a 0.
2. For cells `(1..,1..)` that are 0, mark `m[i][0] = 0` and `m[0][j] = 0`.
3. Zero every inner cell whose row or column marker is 0.
4. Finally zero the first row and first column if their flags were set.

**Intuition:** The first row and column are free storage. They just need their own original state saved separately.

**Complexity:** Time O(m·n), Space O(1).

**Edge cases:** Zero in the first row or column, a single row or column, all zeros, no zeros.

**Interview traps**
- Handle the first row and column **last**. If you do them early, you destroy your markers.
- Don't zero cells immediately while scanning, or newly created zeros trigger more zeroing.
- Start with the O(m+n) solution and then optimise. Interviewers like to see the progression.

**How to explain:** "I store the 'this row/column must be zero' flags inside the matrix's own first row and column, saving the first row/column's original state in two booleans."
