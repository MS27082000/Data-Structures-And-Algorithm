# Maximum Nesting Depth of the Parentheses (LC 1614)

**Problem:** Given a valid parentheses string (with other characters mixed in), return the maximum nesting depth.

**Brute force:** Use a stack and record its maximum size → O(n) time, O(n) space.
**Optimal:** A single **counter** → O(n) time, O(1) space.

**Approach:** `(` → `depth++` and update `max`; `)` → `depth--`; ignore everything else.

**Intuition:** The stack size at any moment equals the current depth, and for valid input we never need the actual characters on the stack, so a number is enough.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** No parentheses (0), empty string, everything at depth 1, fully nested.

**Interview traps**
- Update `max` **after** incrementing, on `(` only.
- Ignore non-parenthesis characters (digits, operators).
- If the input might be invalid, ask. Then you'd also need to validate (depth never negative, ends at 0).

**How to explain:** "A counter goes up on every open bracket and down on every close bracket. The largest value it reaches is the depth."
