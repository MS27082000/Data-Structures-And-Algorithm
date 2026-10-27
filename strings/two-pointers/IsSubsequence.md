# Is Subsequence (LC 392)

**LeetCode:** [392](https://leetcode.com/problems/is-subsequence/)

**Problem:** Can `s` be made by deleting some characters of `t` without reordering?
`("abc", "ahbgdc")` → `true`, `("axc", "ahbgdc")` → `false`

**Subsequence vs substring:** subsequence keeps order but can skip characters. Substring must be contiguous.

**Key idea:** Greedy. Walk through `t`. Every time `t[j]` equals the character of `s` we are waiting for (`s[i]`), take it and move `i`. Taking the earliest match never hurts.

**Dry run (`s = "abc"`, `t = "ahbgdc"`):**
| j (t) | s[i] wanted | match? | i |
|---|---|---|---|
| a | a | yes | 1 |
| h | b | no | 1 |
| b | b | yes | 2 |
| g, d | c | no | 2 |
| c | c | yes | 3 = len(s) → `true` |

**Complexity:** Time O(|t|). Space O(1).

**Edge cases:** Empty `s` → `true`; empty `t` with non-empty `s` → `false`.

**Interview traps**
- The answer is `i == s.length()`, not "loop finished".
- **Follow-up** (millions of `s` queries against one `t`): store the indices of each letter of `t`, then for each query binary search the next index after the previous one.

**Pattern:** "order matters, gaps allowed" → one pointer per string, advance `s` only on a match.
