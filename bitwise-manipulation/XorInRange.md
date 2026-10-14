# XOR of Numbers in a Given Range [L, R]

**Problem:** Compute `L ^ (L+1) ^ … ^ R`.

**Brute force:** Loop from `L` to `R` → O(R − L).
**Optimal (O(1)):** Use the pattern of the XOR of `1..n`, which repeats every 4 numbers:

| `n % 4` | XOR of 1..n |
|---|---|
| 0 | `n` |
| 1 | `1` |
| 2 | `n + 1` |
| 3 | `0` |

Then `xor(L..R) = xor(1..R) ^ xor(1..L-1)`: the common prefix `1..L-1` cancels.

**Why the pattern:** Every group of four consecutive numbers starting at a multiple of 4 (`4k, 4k+1, 4k+2, 4k+3`) XORs to 0 (the lower two bits cancel and the higher bits are equal in pairs). So only the leftover `n % 4` numbers matter.

**Intuition:** It's a prefix-XOR idea (like prefix sums), where XOR is its own inverse, so `prefix[R] ^ prefix[L-1]` gives the range.

**Complexity:** Time O(1), Space O(1).

**Edge cases:** `L = 1` (`xorUpTo(0)` must be 0, and `0 % 4 == 0` returns 0, which is right), `L == R`, `L = 0`, large values (`n + 1` can overflow at `MAX_VALUE`).

**Interview traps**
- The formula is for `1..n` (or `0..n`, same result). It's **not** `n` for every case.
- Subtract using `xorUpTo(L - 1)`, not `L`.
- Mention the brute-force check in tests. It is easy to verify.
- Related: XOR of an arbitrary array range with a **prefix XOR array** (O(1) per query after O(n) setup).

**How to explain:** "The XOR from 1 to n cycles through n, 1, n+1, 0 depending on n mod 4. For a range I XOR the prefix up to R with the prefix up to L−1, so the shared part cancels."
