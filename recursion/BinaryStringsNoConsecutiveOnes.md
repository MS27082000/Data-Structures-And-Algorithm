# Generate Binary Strings Without Consecutive 1s

**Problem:** Generate all binary strings of length `n` that do not contain two adjacent `1`s.

**Brute force:** Generate all 2ⁿ strings and filter → O(n · 2ⁿ).
**Optimal:** **Backtracking with a constraint:** build the string position by position. `'0'` is always allowed. `'1'` is allowed only if the previous character isn't `'1'` → only valid strings are ever built.

**Intuition:** Pruning the invalid branch early avoids generating strings that would be thrown away. The number of valid strings is a Fibonacci number (`F(n+2)`): 2, 3, 5, 8 for n = 1, 2, 3, 4.

**Complexity:** Time O(n · F(n+2)), Space O(n) stack (plus output).

**Edge cases:** `n = 1` (`0`, `1`), `n = 0` (one empty string), `n = 2` (`00, 01, 10`).

**Interview traps**
- Check the **previous character**, not the next. Handle the first position (no previous).
- Undo each append (`deleteCharAt`). This is backtracking.
- Know the count is **Fibonacci**. It's a common follow-up (count them instead with DP: `dp[i] = dp[i-1] + dp[i-2]`).
- Use `StringBuilder`, not string concatenation in the recursion, for speed.

**How to explain:** "At each position I can always put a 0, and I can put a 1 only if the last character isn't a 1. That builds exactly the valid strings."
