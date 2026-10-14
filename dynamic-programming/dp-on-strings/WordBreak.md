# Word Break (LC 139)

**Problem:** Can the string be split into words from a dictionary (words reusable)?

**Intuition:** `dp[i]` = prefix of length i can be segmented. `dp[0] = true`. `dp[i]` is true if some `j < i` has `dp[j]` and `s[j..i)` is in the dictionary. Only look back up to the longest word length.

**Brute force:** Recursion trying every prefix, exponential.
**Optimised:** O(n * L^2) time (L = max word length), O(n) space.

**Edge cases:** Repeated words allowed. No valid split (`catsandog`). Single character.

**Interview traps**
- Put the dictionary in a hash set.
- Greedy longest-prefix fails (`abcd` with `a, abc, b, cd`).
- Word Break II (return all sentences) needs backtracking + memo.

**How to explain:** "A prefix is breakable if a shorter breakable prefix plus one dictionary word reaches it."
