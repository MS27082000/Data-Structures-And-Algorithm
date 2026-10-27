# Minimum Remove to Make Valid Parentheses (LC 1249)

**Problem:** Remove the fewest `(` or `)` so the string becomes valid. Return any valid result.

**Approach:** One pass with a stack of indices. On `(` push the index. On `)` pop if the stack has one, else this `)` is extra, so mark it. After the pass, whatever is left in the stack is an unmatched `(`, so mark those too. Build the answer skipping marked positions.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Only brackets (`"))(("` → empty); letters between brackets stay.

**Interview traps:** Store **indices**, not characters, so you know what to delete. Don't forget the leftover `(` after the loop.

**Pattern:** "fix / validate brackets" → stack of indices. If only a yes/no is needed, a counter is enough.
