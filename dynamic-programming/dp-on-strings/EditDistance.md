# Edit Distance (LC 72)

**Problem:** Minimum insert / delete / replace operations to turn word1 into word2.

**Intuition:** `dp[i][j]` = answer for the first i and j chars. Equal -> `dp[i-1][j-1]`. Else `1 + min(delete dp[i-1][j], insert dp[i][j-1], replace dp[i-1][j-1])`. Base: `dp[i][0] = i`, `dp[0][j] = j`.

**Brute force:** Recursion with 3 branches, O(3^max).
**Optimised:** O(m*n) time, O(n) space.

**Edge cases:** Either string empty -> the other length. Identical -> 0.

**Interview traps**
- Be able to say which neighbour means which operation.
- Do not forget the base row and column.

**How to explain:** "If the last letters match I move on for free; otherwise I pay one for the cheapest of delete, insert or replace."
