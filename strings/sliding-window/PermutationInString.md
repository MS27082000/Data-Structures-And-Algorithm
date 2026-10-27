# Permutation in String (LC 567)

**LeetCode:** [567](https://leetcode.com/problems/permutation-in-string/)

**Problem:** Does `s2` contain a permutation of `s1` as a substring?
`("ab", "eidbaooo")` → `true` (`"ba"`), `("ab", "eidboaoo")` → `false`

**Key idea:** A permutation of `s1` is a *substring of the same length* with the same letter counts. So slide a fixed window of size `|s1|` over `s2` and compare counts. It is Find All Anagrams, but return at the first hit.

**Count trick:** `need[]` starts as the counts of `s1`. Letter enters → `need[c]--`. Letter leaves → `need[c]++`. All zeros → match.

**Dry run (`s1 = "ab"`, `s2 = "eidba"`):**
| window | change | zeros? |
|---|---|---|
| ei | - | no |
| id | e leaves, d enters | no |
| db | i leaves, b enters | no (a still +1) |
| ba | d leaves, a enters | yes → `true` |

**Complexity:** Time O(26 · n). Space O(1).

**Edge cases:** `|s1| > |s2|` → `false`.

**Interview traps**
- It must be contiguous. Do not confuse with a subsequence.
- Do not sort each window (O(n · k log k)); update counts instead.

**Pattern:** "permutation / anagram inside a longer string" → fixed window + count array.
