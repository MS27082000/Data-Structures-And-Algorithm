# Longest Palindromic Subsequence (LC 516)

**Problem:** Length of the longest palindromic subsequence.

**Intuition:** A palindrome equals its reverse, so `LPS(s) = LCS(s, reverse(s))`. Or interval DP: ends equal -> `2 + dp[i+1][j-1]`; else `max(dp[i+1][j], dp[i][j-1])`.

**Brute force:** All subsequences.
**Optimised:** O(n^2) time, O(n) space (LCS version).

**Edge cases:** Single char -> 1. All distinct -> 1. Empty -> 0.

**Interview traps**
- Subsequence vs substring (Longest Palindromic **Substring** is a different problem).
- Mention both approaches; the reverse trick is shortest.

**How to explain:** "The longest palindrome I can keep is the longest subsequence shared by the string and its reverse."
