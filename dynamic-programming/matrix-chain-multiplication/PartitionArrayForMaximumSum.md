# Partition Array for Maximum Sum (LC 1043)

**Problem:** Split into contiguous pieces of length at most k; each piece is replaced by its maximum repeated. Maximise the total.

**Intuition:** Front-partition DP: `dp[i]` = best for the first i elements. Try the last piece length `len = 1..k`; its value is `len * (max of that piece)`.

**Brute force:** All partitions, exponential.
**Optimised:** O(n*k) time, O(n) space.

**Edge cases:** k = 1 -> sum unchanged. k >= n -> n * max.

**Interview traps**
- Maintain the running max as len grows instead of recomputing.
- Remember `len <= i`.

**How to explain:** "I choose how long the last block is, up to k, and add its length times its maximum."
