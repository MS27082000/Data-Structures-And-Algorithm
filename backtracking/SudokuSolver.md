# Sudoku Solver (LC 37)

**Problem:** Fill a 9×9 grid (empty cells are `'.'`) so each **row, column, and 3×3 box** contains digits 1-9 exactly once. A solution is guaranteed to be unique.

**Brute force:** Try all `9^(empty cells)` fillings → impossible.
**Optimal (backtracking):** Find the next empty cell; try digits `1..9`; keep a digit only if it's valid in its row, column and box; recurse; **undo** if it leads to a dead end. If no digit fits a cell, return `false` to trigger backtracking in the caller.

**Intuition:** Constraint checking at every placement prunes the search massively. In practice a standard puzzle solves in milliseconds.

**Box index trick:** For cell `(r, c)` and loop `i = 0..8`, the box cell is `(3*(r/3) + i/3, 3*(c/3) + i%3)`.

**Complexity:** Time O(9^m) worst case (m = empty cells), but heavily pruned. Space O(m) stack.

**Edge cases:** Already full board (returns true immediately), puzzles requiring deep backtracking.

**Interview traps**
- After the trial loop fails, **`return false` right away**. Do not keep scanning other cells.
- Restore `'.'` after a failed attempt.
- Return a **boolean** so the first full solution stops the search.
- Speed-ups: boolean arrays `row[9][10]`, `col[9][10]`, `box[9][10]` for O(1) validity, and pick the cell with the **fewest candidates** first (MRV heuristic).

**How to explain:** "I look for the first empty cell and try each digit that doesn't conflict. If I can solve the rest, great; otherwise I undo and try the next digit. If none work I report failure so the previous cell changes."
