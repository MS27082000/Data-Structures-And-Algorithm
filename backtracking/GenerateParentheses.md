# Generate Parentheses (LC 22)

**Problem:** Given `n` pairs, generate all well-formed parentheses strings.

**Brute force:** Generate all `2^(2n)` strings of `(` and `)` and validate each → O(2^(2n) · n).
**Optimal:** **Backtracking with two counters.** Add `(` if `open < n`; add `)` if `close < open`. Only valid strings are ever built.

**Intuition:** A string is well-formed iff at every prefix the number of `)` never exceeds the number of `(`, and the totals are equal. Those two rules are exactly the two conditions above.

**Complexity:** Time O(4ⁿ / √n) (the n-th **Catalan number** of results, times n to build each). Space O(n) stack.

**Edge cases:** `n = 1` (`()`), `n = 0`, larger `n` (n = 3 gives 5, n = 4 gives 14).

**Interview traps**
- Condition for `)` is `close < open`, **not** `close < n`.
- Undo the append after each recursive call (`deleteCharAt`).
- Know the count is the Catalan number (1, 2, 5, 14, 42…).
- Don't generate-then-filter. Constrained generation is the expected answer.

**How to explain:** "I build the string character by character, adding an open bracket while I have some left and a close bracket only when there's an unmatched open one. That guarantees every string is valid."
