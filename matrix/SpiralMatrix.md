# Spiral Matrix (LC 54)

**Problem:** Return all elements of an `m x n` matrix in spiral order.

**Brute force:** Simulate with a `visited` matrix and a direction change on hitting a wall or visited cell → O(m·n) time, O(m·n) space.
**Optimal:** Four shrinking boundaries `top, bottom, left, right` → O(m·n) time, O(1) extra space.

**Steps (per layer):** go left→right on the top row, `top++`; top→bottom on the right column, `right--`; right→left on the bottom row, `bottom--`; bottom→top on the left column, `left++`.

**Intuition:** Each loop peels one outer ring. The boundaries tell you exactly where the next ring starts.

**Complexity:** Time O(m·n), Space O(1) (excluding the output).

**Edge cases:** Single row, single column, 1x1, non-square (`3x4`), empty matrix.

**Interview traps**
- After the first two sides, **re-check `top <= bottom` and `left <= right`** before the last two. Otherwise a single row or column gets added twice.
- Loop condition uses `<=` on both boundaries.
- Common follow-up: generate the spiral matrix (LC 59), the same boundary idea.

**How to explain:** "I walk the outer layer in four directions, shrink the boundaries, and repeat. The only subtle part is guarding the last two sides for leftover single rows or columns."
