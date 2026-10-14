# Count Palindromic Subsequences

**Problem:** Count all non-empty palindromic subsequences of a string (by position; equal text from different positions counts separately).

**Intuition:** `dp[i][j]` for the range `s[i..j]`: `dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]` (inclusion-exclusion). If `s[i] == s[j]`, also add `dp[i+1][j-1] + 1` (wrap every inner palindrome, plus the pair itself).

**Brute force:** All subsequences, O(2^n * n).
**Optimised:** O(n^2) time and space.

**Edge cases:** Single char -> 1. All same letters (`aaa` -> 7). Empty -> 0. Answer can be large - use `long` or a modulo in other variants.

**Interview traps**
- Confirm the counting convention: positions vs distinct strings (LC 730 counts distinct and is much harder).
- Subtract the overlap term.

**How to explain:** "Count what happens without the left end, without the right end, remove the double count, and if the ends match add everything that can be wrapped by them."
