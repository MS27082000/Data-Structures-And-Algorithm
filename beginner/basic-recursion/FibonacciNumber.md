# Fibonacci Number (LC 509)

**Problem:** F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2).

**Intuition:** Two recursive calls per level repeat the same sub-problems, so cache them or iterate.

**Approach / complexity:** Plain recursion O(2^n). Memoised O(n) time and space. Iterative with two variables: O(n) time, O(1) space.

**Edge cases:** n = 0 and 1. long overflows after F(92).

**Interview traps**
- Plain recursion is exponential; say so.
- This is the doorway to dynamic programming.

**How to explain:** "Fibonacci repeats sub-problems, so I memoise or keep just the last two values."
