# Z Function

**Problem:** For a string s build `z[i]` = length of the longest substring starting at i that is also a **prefix** of s. Use it for pattern matching.

**Intuition:** Keep a window `[l, r)`, the rightmost segment that matched a prefix. For an index i inside the window, the answer starts from the already known `z[i - l]` (capped by `r - i`); then extend by direct comparison. Each extension moves `r` forward, so the whole thing is linear.

**Pattern matching:** Build `z` for `pattern + '#' + text`. Any position with `z == m` is a match at `i - m - 1`.

**Brute force:** Compare from every index, O(n^2).
**Optimised:** O(n) time, O(n) space.

**Edge cases:** `z[0]` is conventionally 0 (or n). All equal letters (`aaaaa` -> `0 4 3 2 1`). The separator must not appear in either string.

**Interview traps**
- Use `min(r - i, z[i - l])`, not just `z[i - l]`.
- Update `[l, r)` only when `i + z[i] > r`.
- Without a separator, matches could run across the pattern/text boundary.

**How to explain:** "I reuse what I already know inside the current matching window, so I only compare characters beyond its right edge - each character is compared once overall."
