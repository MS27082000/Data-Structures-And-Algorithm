# Distinct Subsequences (LC 115)

**Problem:** Number of subsequences of `s` equal to `t`.

**Intuition:** `dp[i][j]` = ways for the first i chars of s to form the first j chars of t. `dp[i][0] = 1`. If `s[i-1] == t[j-1]`: use it (`dp[i-1][j-1]`) plus skip it (`dp[i-1][j]`); else only skip. 1D version iterates j **downwards**.

**Brute force:** All subsequences of s, O(2^m).
**Optimised:** O(m*n) time, O(n) space.

**Edge cases:** `t` longer than `s` -> 0. Empty `t` -> 1.

**Interview traps**
- Count by position, so equal letters at different positions are different subsequences.
- Use `long` for the intermediate counts.
- Downward loop in 1D.

**How to explain:** "When letters match I can either spend this letter of s on this letter of t, or leave it unused; otherwise I must leave it."
