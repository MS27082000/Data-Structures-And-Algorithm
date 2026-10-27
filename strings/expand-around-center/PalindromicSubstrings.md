# Palindromic Substrings (LC 647)

**LeetCode:** [647](https://leetcode.com/problems/palindromic-substrings/)

**Problem:** Count all substrings of `s` that are palindromes (same substring at different positions counts separately).
`"aaa"` → `6` (`a, a, a, aa, aa, aaa`)

**Brute force:** Check all O(n²) substrings, each in O(n) → O(n³).

**Key idea:** A palindrome mirrors around its centre. There are `2n - 1` centres: `n` characters (odd length) and `n - 1` gaps (even length). From each centre, expand outward while the two ends match. **Every successful expansion is one new palindrome.**

**Dry run (`"aaa"`):**
| centre | expansions that succeed | count |
|---|---|---|
| index 0 (odd) | `a` | 1 |
| gap 0-1 (even) | `aa` | 1 |
| index 1 (odd) | `a`, `aaa` | 2 |
| gap 1-2 (even) | `aa` | 1 |
| index 2 (odd) | `a` | 1 |
| total | | 6 |

**Complexity:** Time O(n²). Space O(1). (Manacher's algorithm gives O(n) but is rarely asked.)

**Edge cases:** All same letters (worst case); no repeats (`"abc"` → 3, only single letters).

**Interview traps**
- Forgetting the even centres.
- Count each step, not just the final longest palindrome.

**Pattern:** "palindromic substring" → expand around centre. Compare with Longest Palindromic Substring, which only tracks the max length.
