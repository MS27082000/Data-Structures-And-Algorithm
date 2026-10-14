# Longest String Chain (LC 1048)

**Problem:** `w1 -> w2` if w2 is w1 with one extra letter anywhere. Longest chain of words.

**Intuition:** Sort by length. `dp[word]` = 1 + max `dp[word with one char removed]` (look up in a map). Or run LIS with a `isPredecessor` check.

**Brute force:** Try all orderings.
**Optimised:** O(n * L^2) time (L deletions, each building a string of length L), O(n * L) space.

**Edge cases:** No pairs -> 1. Duplicate words. Words of equal length are never connected.

**Interview traps**
- Sort by **length**, not alphabetically.
- Removal check is simpler than the two-pointer insertion check.

**How to explain:** "For each word I try deleting each letter; if the shorter word is known, I extend its chain."
