# Pow(x, n) (LC 50)

**Problem:** Compute `x^n` for a double `x` and an integer `n` (which may be negative).

**Brute force:** Multiply `x` by itself `n` times → O(n). Too slow for `n` up to 2³¹.
**Optimal:** **Fast (binary) exponentiation** → O(log n).

**Idea:** `x^n = (x^(n/2))²` if `n` is even; `(x^(n/2))² · x` if odd. Each call halves `n`.
**Negative `n`:** compute `(1/x)^(-n)`.

**Iterative form (O(1) space):** Read the bits of `n`. If the bit is 1, multiply the result by the current `x`; then square `x` and shift `n`.

**Complexity:** Time O(log n), Space O(log n) recursive or O(1) iterative.

**Edge cases:** `n = 0` (1), `n` negative, `x = 0` with a positive `n`, `x = 1` or `-1`, **`n = Integer.MIN_VALUE`**.

**Interview traps**
- `-Integer.MIN_VALUE` overflows `int`. **Convert `n` to `long` first.**
- Compute `power(x, n/2)` **once** and store it. Calling it twice makes it O(n) again.
- `x = 0` with negative `n` is undefined (division by zero). Ask how to handle it.

**How to explain:** "I halve the exponent each step and square the result, multiplying by x when the exponent is odd. That's O(log n) instead of O(n)."
