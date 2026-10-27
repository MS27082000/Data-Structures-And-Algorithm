# Reverse Vowels of a String (LC 345)

**LeetCode:** [345](https://leetcode.com/problems/reverse-vowels-of-a-string/)

**Problem:** Reverse only the vowels (both cases). Other characters stay where they are.
`"leetcode"` → `"leotcede"`

**Key idea:** Same as reversing a string with two pointers, except each pointer first *skips* non-vowels.

**Dry run (`"hello"`):**
| left | right | action | string |
|---|---|---|---|
| 0 (h) → 1 (e) | 4 (o) | both on vowels, swap | holle |
| 2 | 3 | `l` skipped on both sides, pointers cross, stop | holle |

**Complexity:** Time O(n). Space O(n) (Java strings are immutable, so use a `char[]`).

**Edge cases:** No vowels; uppercase vowels (`"aA"` → `"Aa"`); single character.

**Interview traps**
- Keep `left < right` inside the inner skip loops, or the pointers run past each other.
- Include `AEIOU`. Missing uppercase is the usual bug.
- After a swap, move both pointers.

**Pattern:** "act only on some characters, from both ends" → two pointers that skip the rest.
