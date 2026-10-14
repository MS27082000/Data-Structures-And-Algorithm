# Wildcard Matching (LC 44)

**Problem:** `?` matches one char, `*` matches any sequence (including empty). Does the pattern match the whole string?

**Intuition:** `dp[i][j]` = first i chars of s match first j of p. `*`: `dp[i][j-1]` (matches empty) or `dp[i-1][j]` (absorbs one more char). `?` or equal char: `dp[i-1][j-1]`. Base: `dp[0][j]` true only if p[0..j) is all `*`.

**Brute force:** Recursion with branching on `*`, exponential.
**Optimised:** O(m*n) time, O(n) space. (A greedy two-pointer solution is O(m*n) worst case, O(1) space.)

**Edge cases:** Empty string vs `***` -> true. Empty string vs `?` -> false. Pattern longer than string.

**Interview traps**
- Initialise the first row for leading `*`s.
- Unlike regex, `*` here is standalone and does not depend on the previous char.

**How to explain:** "A star either matches nothing or eats one more character, and I fill the table that way."
