# Minimum Coins / Coin Change (LC 322)

**Problem:** Fewest coins (unlimited supply) to make `amount`; -1 if impossible.

**Intuition:** `dp[a] = 1 + min(dp[a - c])` over coins `c <= a`, `dp[0] = 0`.

**Brute force:** Recursion over coins, exponential.
**Optimised:** O(amount * coins) time, O(amount) space.

**Edge cases:** amount = 0 -> 0. Unreachable -> -1. Single coin larger than amount.

**Interview traps**
- **Greedy fails** for general coin sets (`[1,3,4]`, amount 6 -> 3+3, not 4+1+1).
- Use "infinity" as `amount + 1`, not `Integer.MAX_VALUE` (overflow when adding 1).

**How to explain:** "The best way to make a is one coin plus the best way to make the remainder, so I try every coin."
