# Square Root of a Number (LC 69)

**Problem:** Return `floor(sqrt(x))` without using the built-in sqrt.

**Brute force:** Try `i = 1, 2, 3…` until `i*i > x` → O(√x).
**Optimal:** **Binary search on the answer** in `[1, x/2]`. Keep the largest `mid` with `mid*mid <= x` → O(log x).

**Intuition:** `mid*mid <= x` is `true … true false … false` as `mid` grows. We want the last true.

**Complexity:** Time O(log x), Space O(1).

**Edge cases:** `x = 0` and `1`, perfect squares, `Integer.MAX_VALUE` (overflow!), non-perfect squares like 8.

**Interview traps**
- `mid * mid` **overflows** `int`. Compare `mid <= x / mid`, or use `long`.
- Return the **floor**, so record `ans = mid` when feasible and keep searching right.
- Mention the alternative, Newton's method, which converges in O(log log x) iterations.

**How to explain:** "Binary search the answer between 1 and x/2. If mid squared is at most x it's a candidate and I try larger, otherwise I go smaller. I avoid overflow by dividing."
