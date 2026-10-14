# Unique Paths II (LC 63)

**Problem:** Same grid walk, but cells marked 1 are obstacles.

**Intuition:** Same recurrence; an obstacle cell has **0** paths through it.

**Brute force:** Recursion, exponential.
**Optimised:** One rolling row: O(m*n) time, O(n) space.

**Edge cases:** Start or end blocked -> 0. Single row/column with an obstacle blocks everything after it.

**Interview traps**
- Initialise `dp[0]` from the start cell (0 if it is an obstacle), not blindly 1.
- Reset the cell to 0 when you meet an obstacle - the old value belongs to the cell above.

**How to explain:** "Same as Unique Paths, but any blocked cell gets zero ways, which propagates naturally."
