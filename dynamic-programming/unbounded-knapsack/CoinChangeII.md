# Coin Change II (LC 518)

**Problem:** Number of **combinations** of coins that make `amount` (order does not matter).

**Intuition:** `dp[a] += dp[a - c]` with the **coins loop outside** and amounts inside. Each coin type is processed once in a fixed order, so `1+2` and `2+1` count as the same combination.

**Brute force:** Recursion, exponential.
**Optimised:** O(coins * amount) time, O(amount) space.

**Edge cases:** amount = 0 -> 1. No way -> 0.

**Interview traps**
- Swapping the loops counts **permutations** (that is Combination Sum IV).
- `dp[0] = 1` (one way: use nothing).

**How to explain:** "Coins outer, amounts inner, so every combination is built in one canonical order."
