# Longest Common Subsequence (LC 1143)

**Problem:** Length of the longest subsequence common to two strings (also print it).

**Intuition:** `dp[i][j]` = LCS of the first i and first j chars. Equal chars: `1 + dp[i-1][j-1]`; else `max(dp[i-1][j], dp[i][j-1])`. To print, walk back from `dp[m][n]`.

**Brute force:** All subsequences of one string, O(2^m * n).
**Optimised:** O(m*n) time; two rows -> O(n) space (the full table is needed to print).

**Edge cases:** Empty string -> 0. No common char -> 0. Identical -> full length.

**Interview traps**
- Subsequence is **not** contiguous (that is substring).
- To print, you need the full table; with rolling rows you lose the path.

**How to explain:** "If the last chars match they belong to the LCS; if not, I drop one char from either string and take the better result."
