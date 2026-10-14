# N-Queens (LC 51)

**Problem:** Place `n` queens on an `n × n` board so no two attack each other (same row, column, or diagonal). Return all distinct boards.

**Brute force:** Try all `C(n², n)` placements → hopeless.
**Better:** **Backtracking, one queen per row.** For each row try every column; skip it if the column or a diagonal is attacked; place, recurse to the next row, remove.
**Optimal conflict check:** Three boolean arrays give O(1) checks:
- `cols[col]`
- `diag1[row + col]` (the "/" diagonal: row+col is constant)
- `diag2[row - col + n - 1]` (the "\" diagonal: row-col is constant)

**Intuition:** Putting exactly one queen per row removes row conflicts. Cells on the same diagonal share `row+col` or `row-col`, so those values identify the diagonals.

**Complexity:** Time O(n!) (heavily pruned in practice), Space O(n) for the arrays and stack.

**Edge cases:** `n = 1` (one board), `n = 2, 3` (none), `n = 4` (2 boards), `n = 8` (92 boards).

**Interview traps**
- **Don't scan the board** to check conflicts (O(n) per check). Use the three arrays.
- Remember the offset `+ n - 1` so the `row - col` index is non-negative.
- Convert the board to strings **at the base case** (a snapshot), then keep mutating the board.
- Undo all three arrays and the board cell when backtracking.
- Mention the bitmask version, which is faster and counts solutions (N-Queens II).

**How to explain:** "I place one queen per row. For each column I check in constant time whether its column or either diagonal is taken. If it's free I place it and recurse; if a row has no valid column I backtrack."
