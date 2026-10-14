# Divide Two Integers Without Multiplication or Division (LC 29)

**Problem:** Compute `dividend / divisor` without using `*`, `/`, or `%`. Truncate toward zero. Clamp to the 32-bit range.

**Brute force:** Subtract the divisor repeatedly and count → O(dividend / divisor), far too slow (`2³¹ / 1`).
**Optimal:** **Repeated doubling with shifts.** For the remaining dividend `a`, find the largest `divisor << k` that is `<= a`. Subtract it and add `2^k` to the quotient. Repeat → O(log² n).

**Intuition:** Any quotient is a sum of powers of two. This is long division in binary: each step removes the biggest chunk possible.

**Steps:**
1. Handle the overflow case `MIN_VALUE / -1` → return `MAX_VALUE`.
2. Remember the sign, then work with absolute values in **`long`**.
3. While `a >= b`: grow `temp = b << k` while `a >= (temp << 1)`; `a -= temp`; `quotient += 1 << k`.
4. Apply the sign.

**Complexity:** Time O(log² n) (O(log n) with a precomputed list of doublings), Space O(1).

**Edge cases:** Negative operands (`7 / -3 = -2`, truncation), `MIN_VALUE / -1` (overflow), `MIN_VALUE / 1`, `0 / x`, `x / x`, `|divisor| > |dividend|`.

**Interview traps**
- **`Math.abs(Integer.MIN_VALUE)` is still negative.** Convert to `long` **before** taking the absolute value.
- Truncation toward zero (not floor). Compute on magnitudes, then apply the sign.
- The sign is `(dividend < 0) != (divisor < 0)`.
- The only result that doesn't fit in an `int` is `MIN_VALUE / -1`.

**How to explain:** "I do binary long division: double the divisor as far as it still fits into the remaining dividend, subtract it, and add the matching power of two to the quotient, until what's left is smaller than the divisor."
