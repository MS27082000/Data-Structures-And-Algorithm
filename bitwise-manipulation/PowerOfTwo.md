# Check if a Number is a Power of 2 (LC 231)

**Problem:** Is `n` equal to `2^k` for some integer `k >= 0`?

**Brute force:** Keep dividing by 2 while `n % 2 == 0`; powers of two end at 1 → O(log n).
**Optimal:** `n > 0 && (n & (n - 1)) == 0` → O(1).

**Intuition:** A power of two has **exactly one set bit** (`1000`). Subtracting 1 flips that bit to 0 and all lower bits to 1 (`0111`), so AND gives 0. Any number with two or more set bits keeps its higher set bit after `n & (n-1)`, so the result is non-zero.

**Alternatives:** `Integer.bitCount(n) == 1`, or `(n & -n) == n`, or `(1 << 30) % n == 0` for positive ints.

**Complexity:** Time O(1), Space O(1).

**Edge cases:** `1` (2⁰, true), `0` (false), **negatives** (false), `Integer.MIN_VALUE` (a single set bit but negative, so false), `2³⁰` (the largest int power of two).

**Interview traps**
- **`n > 0` is required.** `0 & -1 == 0` would wrongly say true, and `MIN_VALUE & (MIN_VALUE - 1)` is 0 too.
- Parenthesise: `(n & (n - 1)) == 0` (precedence of `==` over `&`).
- Related follow-ups: power of four (`n & 0x55555555 != 0` as well), count set bits, "next power of two".

**How to explain:** "A power of two has one set bit. `n & (n-1)` removes the lowest set bit, so the result is zero exactly when there was only one. I also check that n is positive."
