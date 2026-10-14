# Balanced Parentheses / Valid Parentheses (LC 20)

**Problem:** A string of `()[]{}`. Is every bracket closed by the same type, in the correct order?

**Brute force:** Repeatedly delete adjacent matching pairs (`()`, `[]`, `{}`) until none remain → O(n²).
**Optimal:** A **stack**. Push each opener. For a closer, the stack must be non-empty and its top must be the matching opener; pop it. At the end the stack must be empty → O(n) time, O(n) space.

**Intuition:** The most recently opened bracket must be the first one closed. That is the last-in-first-out rule.

**Variant:** Push the **expected closer** when you see an opener (`(` pushes `)`), so checking a closer is just `stack.pop() == c`. Shorter code.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Empty string (valid), a lone closer (`"]"`), leftover openers (`"(("`), mismatched types (`"(]"`), wrong order (`"([)]"`), odd length (always invalid).

**Interview traps**
- Check **`stack.isEmpty()` before popping** on a closer.
- Return `stack.isEmpty()` at the end, not `true`.
- Quick reject: odd length → `false`.
- Follow-ups: minimum additions to make valid, longest valid parentheses (LC 32), the wildcard version ([Valid Parenthesis Checker](../greedy-algorithms/ValidParenthesisChecker.md)).
- With **only one bracket type**, a counter is enough (no stack).

**How to explain:** "I push every opening bracket. When I see a closing one it must match the bracket on top of the stack, which I pop. If I ever mismatch, or the stack isn't empty at the end, it's invalid."
