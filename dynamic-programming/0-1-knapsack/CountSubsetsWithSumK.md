# Count Subsets with Sum K

**Problem:** Count subsets whose sum is K.

**Intuition:** `dp[s]` = ways to reach s. For each element `dp[s] += dp[s - x]`, going downwards. Take-or-skip counting.

**Brute force:** O(2^n).
**Optimised:** O(n * K) time, O(K) space.

**Edge cases:** K = 0 -> at least 1 (empty subset). **Zeros** double the count since each zero can be in or out. Element > K is skipped.

**Interview traps**
- Counting by index, not by value: `[1,2,2,3]` gives two different `{1,2}` subsets.
- The loop `s >= x` also works for x = 0 and doubles counts - that is correct, do not "fix" it.
- Large answers need a modulo.

**How to explain:** "Like subset sum but I count ways instead of storing true/false."
