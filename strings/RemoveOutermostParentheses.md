# Remove Outermost Parentheses (LC 1021)

**Problem:** A valid parentheses string is split into **primitive** groups (the smallest non-empty valid pieces, e.g. `(()())` and `(())`). Remove the outermost pair of each group.

**Brute force:** Split into primitives with a stack, then trim each → O(n) time, O(n) space.
**Optimal:** One pass with a **depth counter** → O(n) time, O(1) extra space (besides the output).

**Approach:** For `'('`: append it only if `depth > 0` (before incrementing), then `depth++`. For `')'`: `depth--` first, then append only if `depth > 0`.

**Intuition:** An outermost `(` is one seen when depth is 0, and an outermost `)` is one that brings depth back to 0. Everything else belongs inside a group.

**Complexity:** Time O(n), Space O(1) auxiliary.

**Edge cases:** `"()()"` → empty string, one deeply nested group, empty input.

**Interview traps**
- The **order** of check and update differs: for `(` check then increment; for `)` decrement then check.
- A counter is enough. You don't need a stack for matching when the input is guaranteed valid.
- Use `StringBuilder`, not `+=` on a String (O(n²)).

**How to explain:** "I track nesting depth. A parenthesis at depth zero when opening, or returning to zero when closing, is outermost and gets skipped; everything else is kept."
