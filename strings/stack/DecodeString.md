# Decode String (LC 394)

**LeetCode:** [394](https://leetcode.com/problems/decode-string/)

**Problem:** Decode `k[encoded]` where the inside is repeated `k` times. Brackets can nest.
`"3[a2[c]]"` → `"accaccacc"`

**Key idea:** When you meet `[`, you go one level deeper, so **save the outer state** (the string built so far and the repeat count). When you meet `]`, come back out: repeat the inner result and glue it to the saved outer string.

**Rules**
| char | action |
|---|---|
| digit | `k = k * 10 + digit` (counts can be multi-digit) |
| `[` | push `k` and `cur`; `cur = new`, `k = 0` |
| `]` | pop `prev` and `times`; `cur = prev + cur × times` |
| letter | append to `cur` |

**Dry run (`"3[a2[c]]"`):**
| char | cur | counts stack | prev stack |
|---|---|---|---|
| 3 | "" | | |
| `[` | "" | [3] | [""] |
| a | a | [3] | [""] |
| 2 | a | [3] | [""] |
| `[` | "" | [3,2] | ["", "a"] |
| c | c | | |
| `]` | acc | [3] | [""] |
| `]` | accaccacc | [] | [] |

**Complexity:** Time and space O(length of the output).

**Edge cases:** `10[a]` (two-digit count); letters outside brackets (`2[abc]3[cd]ef`).

**Interview traps:** Reset `k = 0` after `[`. Don't treat the count as a single digit.
**Alternative:** Recursion, one call per `[`.

**Pattern:** "nested structure" → stack that saves the outer state going in and restores it coming out.
