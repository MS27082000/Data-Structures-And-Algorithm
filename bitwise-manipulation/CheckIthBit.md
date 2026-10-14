# Check if the i-th Bit is Set

**Problem:** Given `n` and `i`, is the i-th bit of `n` equal to 1? (0-indexed from the **right**.)

**Brute force:** Convert to a binary string/list and index it → O(log n) time and extra space.
**Optimal (O(1)):**
- **Right shift:** `((n >> i) & 1) == 1`: bring bit `i` to position 0, then mask.
- **Left shift mask:** `(n & (1 << i)) != 0`: build a mask with only bit `i`.

**Related single-bit operations (same masks):**
- Set: `n | (1 << i)`
- Clear: `n & ~(1 << i)`
- Toggle: `n ^ (1 << i)`

**Intuition:** `1 << i` is a number with only bit `i` on. ANDing keeps just that bit, so the result is non-zero iff the bit was set.

**Complexity:** Time O(1), Space O(1).

**Edge cases:** `n = 0`, `i = 0` (the LSB), `i = 31` (the sign bit), negative numbers, `i` beyond the width (Java uses `i % 32`).

**Interview traps**
- **Compare with `!= 0`**, not `== 1`, for the mask version. `n & (1 << i)` equals `1 << i`, not 1.
- Check whether the problem counts bits from the **right (0-indexed)** or **left/1-indexed**.
- For `i >= 31` use `1L << i` with a `long`.
- Parenthesise `(n >> i) & 1` and compare with `== 1` separately.

**How to explain:** "I shift the number right by i so that bit becomes the last bit, then AND with 1. If it's 1 the bit was set."
