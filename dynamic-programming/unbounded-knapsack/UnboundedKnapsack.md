# Unbounded Knapsack

**Problem:** Like 0/1 knapsack, but each item can be used any number of times.

**Intuition:** Same recurrence, but iterate capacity **upwards** so `dp[w - wt]` may already include the same item.

**Brute force:** Recursion with "stay on the same item" branch.
**Optimised:** O(n * W) time, O(W) space.

**Edge cases:** No item fits -> 0. W = 0.

**Interview traps**
- Direction of the capacity loop is the whole difference from 0/1.
- Greedy by ratio can fail.

**How to explain:** "When I take an item I remain on the same item, which the upward loop gives me for free."
