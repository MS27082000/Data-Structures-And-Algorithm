# Palindrome Partitioning II (LC 132)

**Problem:** Minimum cuts so that every piece is a palindrome.

**Intuition:** Precompute `pal[i][j]` (is `s[i..j]` a palindrome) in O(n^2). Then `cuts[i]` = 0 if the whole prefix is a palindrome, else min over `j` of `cuts[j-1] + 1` where `s[j..i]` is a palindrome.

**Brute force:** Try every partition, O(2^n).
**Optimised:** O(n^2) time and space.

**Edge cases:** Already a palindrome -> 0. All distinct letters -> n-1. Single char -> 0.

**Interview traps**
- Without the precomputed table the check makes it O(n^3).
- Palindrome Partitioning I (list all partitions) is backtracking; II asks only for the minimum count.

**How to explain:** "I know instantly which substrings are palindromes, then do a front-partition DP choosing the last piece."
