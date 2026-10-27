# Find the Index of the First Occurrence in a String (LC 28)

**Problem:** Return the first index where `needle` appears in `haystack`, or `-1`. (Also called strStr.)
`("sadbutsad", "sad")` → `0`

**Approach (naive matching):** For every start index `i`, compare `needle` with `haystack[i .. i+m-1]` character by character. First full match wins.

**Dry run (`haystack = "abcabd"`, `needle = "abd"`):**
| start | compared | result |
|---|---|---|
| 0 | a=a, b=b, c≠d | fail |
| 1 | b≠a | fail |
| 2 | c≠a | fail |
| 3 | a=a, b=b, d=d | match → `3` |

**Complexity:** Time O(n · m) worst case (like `"aaaa...ab"` searching `"aaab"`). Space O(1).

**Edge cases:** Empty needle → `0`; needle longer than haystack → `-1`.

**Interview traps**
- Loop only while `i + m <= n`.
- `indexOf` is the one-line answer, but interviewers want the loop.
- **Follow-up:** do it in O(n + m) with KMP, which never moves back in `haystack`. See [KMPAlgorithm](../../advanced/KMPAlgorithm.md). Rabin-Karp (rolling hash) is the other option.

**Pattern:** "find a pattern in a text" → naive first, then KMP if asked to optimise.
