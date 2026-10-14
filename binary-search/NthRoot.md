# Nth Root of a Number

**Problem:** Given `n` and `m`, find the integer `r` with `r^n == m`, or -1 if no such integer exists.

**Brute force:** Try `r = 1, 2, …` and compute `r^n` → O(m·n).
**Optimal:** **Binary search on `r`** in `[1, m]`. Compare `r^n` with `m`: equal → answer; smaller → go right; larger → go left → O(n log m).

**Intuition:** `r^n` is strictly increasing in `r`, so it is monotonic.

**Complexity:** Time O(n log m), Space O(1).

**Edge cases:** `m = 1` (root 1), `n = 1` (answer `m`), no integer root (→ -1), large `n` where `r^n` explodes.

**Interview traps**
- **Overflow:** `r^n` can be huge. Multiply step by step and **stop early** once it exceeds `m` (use `long`).
- Don't use `Math.pow` for exact comparison. Floating point errors give wrong equality.
- Return `-1` explicitly when not found.

**How to explain:** "The power function is increasing, so I binary search r and compare r^n to m, with an early exit when the product passes m to avoid overflow."
