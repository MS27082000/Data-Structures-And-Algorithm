# Remove All Adjacent Duplicates In String (LC 1047)

**LeetCode:** [1047](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)

**Problem:** Repeatedly delete two equal adjacent characters until none are left.
`"abbaca"` → `"ca"`

**Key idea:** Each new character may cancel the *most recent surviving* character. "Most recent" is exactly what a stack gives. After a cancel, the new top is exposed, so chain reactions (like `abba`) happen automatically.

**Dry run (`"abbaca"`):**
| char | top | action | stack |
|---|---|---|---|
| a | - | push | a |
| b | a | push | ab |
| b | b | pop | a |
| a | a | pop | (empty) |
| c | - | push | c |
| a | c | push | ca |
Result `"ca"`.

**Complexity:** Time O(n). Space O(n).
In Java use a `StringBuilder` as the stack: `charAt(len-1)`, `deleteCharAt(len-1)`, `append`.

**Edge cases:** Everything cancels (`"aa"`, `"abba"`) → empty string.

**Interview traps:** A single left-to-right pass without a stack misses chain reactions.
**Variant:** Remove K adjacent duplicates (LC 1209) → store `(char, count)` in the stack.

**Pattern:** "cancel the latest matching thing" → stack.
