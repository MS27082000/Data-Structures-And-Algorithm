# Longest Increasing Subsequence (LC 300)

**Problem:** Length of the longest strictly increasing subsequence.

**Intuition (O(n^2)):** `dp[i]` = LIS ending at i = 1 + max `dp[j]` for `j < i` with `a[j] < a[i]`.
**Intuition (O(n log n)):** Keep `tails[k]` = the smallest possible tail of an increasing subsequence of length k+1. For each x, binary search the first tail `>= x` and replace it; append if none. Answer = size of `tails`.

**Brute force:** All subsequences, O(2^n).
**Optimised:** O(n log n) time, O(n) space.

**Edge cases:** Empty array, all equal (answer 1 because strict), strictly decreasing (1).

**Interview traps**
- `tails` is **not** the actual LIS, only its length is right.
- Use lower bound (first `>= x`) for strict increase; upper bound would give non-decreasing.

**How to explain:** "A smaller tail is always better for extending later, so I keep the best tail for each length and update it with binary search."
