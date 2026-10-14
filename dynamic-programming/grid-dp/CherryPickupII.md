# Cherry Pickup II (LC 1463)

**Problem:** Two robots start at top-left and top-right. Each moves down one row at a time to col-1, col or col+1. Cherries in a shared cell are counted once. Maximise cherries.

**Intuition:** Both robots move **together row by row**, so the state is `(row, col1, col2)`. Try all 3 x 3 = 9 move pairs and add the cherries of the current cells (once if col1 == col2).

**Brute force:** Recursion, O(9^rows).
**Optimised:** O(rows * cols^2 * 9) time; bottom-up with two layers -> O(cols^2) space.

**Edge cases:** One row (just collect). One column (both always overlap). Out-of-bounds moves must be rejected.

**Interview traps**
- Do not run the robots one after another - that double-counts and ignores overlap.
- Count a shared cell once.
- Use a large negative for out-of-bounds, not 0.

**How to explain:** "One row per step for both robots, so I track both columns. From each pair of positions I try all nine moves."
