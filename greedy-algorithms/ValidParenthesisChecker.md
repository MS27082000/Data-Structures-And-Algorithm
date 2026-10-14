# Valid Parenthesis Checker with Wildcards (LC 678)

**Problem:** A string of `(`, `)` and `*`, where `*` can be `(`, `)` or an empty string. Is the string valid?

**Brute force:** Try all 3 choices for each `*` → O(3ⁿ). **DP:** O(n²) / O(n³).
**Two-stack approach:** One stack for `(` indices and one for `*` indices, then match leftover `(` with later `*` → O(n) time, O(n) space.
**Optimal (greedy, O(1) space):** Track the **range of possible open-bracket counts** `[lo, hi]`:
- `(`: `lo++, hi++`
- `)`: `lo--, hi--`
- `*`: `lo--` (treat as `)`), `hi++` (treat as `(`)
- If `hi < 0` → too many `)` even in the best case → `false`.
- Clamp `lo = max(lo, 0)` (we can't have negative open brackets).
- At the end the string is valid iff `lo == 0`.

**Intuition:** `hi` is the best case (every `*` opens), `lo` is the worst case (every `*` closes). Any count between them is achievable, so `0` is achievable iff `lo == 0` at the end.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty string, only stars, `")("` (false), `"(((**"` (not enough closers), `"(*))"`.

**Interview traps**
- **Clamp `lo` at 0**: a `*` used as `)` when nothing is open should just be empty.
- Check `hi < 0` **inside** the loop (immediately), not only at the end. `")("` must fail.
- The final check is `lo == 0`, not `hi == 0`.
- Know the two-stack alternative.

**How to explain:** "I keep the minimum and maximum number of open brackets the string could have at each point, treating each star as the best and worst case. If the max ever goes negative it's invalid, and at the end the minimum must be able to reach zero."
