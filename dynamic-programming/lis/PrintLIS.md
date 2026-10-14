# Print the Longest Increasing Subsequence

**Problem:** Return one actual LIS, not just its length.

**Intuition:** Run the O(n^2) DP and store `parent[i]` = the previous index that gave `dp[i]`. Start at the index with the largest `dp`, follow parents back, then reverse.

**Brute force:** Generate all subsequences.
**Optimised:** O(n^2) time, O(n) space.

**Edge cases:** Empty array, decreasing array (any single element), several valid answers (say which one you return).

**Interview traps**
- Track the best **ending index**, not just the max length.
- Do not forget to reverse.
- The O(n log n) tails array cannot be printed directly.

**How to explain:** "Length DP plus a parent pointer per element; I walk the pointers back from the best end."
