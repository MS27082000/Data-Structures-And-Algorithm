# 0/1 Knapsack

**Problem:** Items with weight and value, capacity W, each item at most once. Maximise value.

**Intuition:** For each item: skip it, or take it if it fits: `dp[i][w] = max(dp[i-1][w], val + dp[i-1][w - wt])`. In 1D iterate `w` **downwards**.

**Brute force:** All subsets, O(2^n).
**Optimised:** O(n * W) time, O(W) space (2D table if you need to print chosen items).

**Edge cases:** Item heavier than W. W = 0. Value 0.

**Interview traps**
- Greedy by value/weight ratio is wrong for 0/1 (right only for fractional knapsack).
- Wrong loop direction turns it into unbounded knapsack.
- O(n*W) is pseudo-polynomial.

**How to explain:** "For each item I decide take or skip; the DP stores the best value for every capacity, and I update capacities from high to low."
