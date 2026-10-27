# Remove All Adjacent Duplicates In String (LC 1047)

**Problem:** Repeatedly remove two equal adjacent characters until none are left. Return the result.

**Approach:** Use a stack (a `StringBuilder`). For each character: if it equals the top, pop; otherwise push.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Everything cancels (`"aa"` → empty); chain reactions (`"abba"` → empty).

**Interview traps:** Removals can create new adjacent pairs, which is exactly why a stack is needed (a single pass with an index is not enough).

**Pattern:** "cancel the latest matching thing" → stack.
