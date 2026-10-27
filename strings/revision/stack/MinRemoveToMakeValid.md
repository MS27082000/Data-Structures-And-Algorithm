# Minimum Remove to Make Valid Parentheses (LC 1249)

**Problem:** Remove the fewest `(` or `)` so the string is valid. Letters stay. Return any valid answer.
`"lee(t(c)o)de)"` → `"lee(t(c)o)de"`

**What makes a bracket extra?**
- A `)` with no open `(` before it.
- A `(` that never gets closed.

**Key idea:** One pass with a stack of **indices** of open `(`.
- `(` → push its index
- `)` → if stack is non-empty, pop (matched). Else this `)` is extra → mark it.
After the pass, whatever indices remain in the stack are unmatched `(` → mark them. Build the answer without marked positions.

**Dry run (`"a)b(c"`):**
| i | char | action |
|---|---|---|
| 1 | `)` | stack empty → mark index 1 |
| 3 | `(` | push 3 |
| end | | stack has 3 → mark index 3 |
Result `"abc"`.

**Complexity:** Time O(n). Space O(n).

**Edge cases:** Only brackets (`"))(("` → empty); no brackets at all.

**Interview traps**
- Push **indices**, not characters, because you must know *which* to delete.
- Do not forget the leftover `(` after the loop.
- Two-pass alternative (O(1) extra space apart from the output): left to right drop extra `)`, then right to left drop extra `(`.
- Only yes/no needed? A counter is enough (see Valid Parentheses).

**Pattern:** "fix brackets" → stack of indices.
