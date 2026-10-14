# Set the Rightmost Unset Bit

**Problem:** Turn the lowest `0` bit of `n` into `1`. If `n` is all ones (like `1111`), return `n` unchanged. (`n = 0` → `1`.)

**Brute force:** Scan bits from the right until a 0 is found, then set it with `n | (1 << i)` → O(log n).
**Optimal (O(1)):** `n | (n + 1)`.

**Why it works:** Adding 1 to `n` flips all trailing 1s to 0 and the **first 0** to 1:
`1011 + 1 = 1100`. OR-ing with the original restores the trailing 1s and keeps the new 1:
`1011 | 1100 = 1111`. Only the rightmost 0 changed.

**All-ones check:** `n & (n + 1) == 0` means `n` is of the form `2ᵏ - 1` (all ones), so there is no unset bit below the top; return `n`.

**Complexity:** Time O(1), Space O(1).

**Edge cases:** `0` (→ 1), all ones (`7`, `15`), a single set bit (`8` → `9`), a 0 in the middle (`101` → `111`).

**Interview traps**
- Clarify the all-ones rule. Mathematically the next unset bit is just above the top, but this problem says to return `n`.
- Don't confuse with **clearing** the rightmost set bit (`n & (n-1)`) or **isolating** it (`n & -n`).
- `n + 1` can overflow only for `Integer.MAX_VALUE`, which is handled by the all-ones check.

**How to explain:** "Adding 1 flips the trailing ones to zeros and the first zero to one. OR-ing that with n keeps the trailing ones and sets exactly the rightmost zero."
