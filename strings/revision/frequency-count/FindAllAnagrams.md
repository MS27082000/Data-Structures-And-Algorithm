# Find All Anagrams in a String (LC 438)

**Problem:** Return all start indices of substrings of `s` that are anagrams of `p`.
`s = "cbaebabacd"`, `p = "abc"` → `[0, 6]`

**Brute force:** Check every substring of length `|p|` with an anagram check → O(n · k).

**Key idea:** An anagram of `p` is a window of length `|p|` with the same letter counts. As the window slides by one, only two letters change: one enters, one leaves. So update the counts in O(1) instead of recounting.

**How the count array works:** Start `need[]` with `+1` per letter of `p`.
- A letter enters the window → `need[c]--`
- A letter leaves the window → `need[c]++`
- All 26 values are `0` → the window is an anagram.

**Dry run (`s = "cbaeb...", p = "abc"`):**
| i | enters | leaves | window | all zero? |
|---|---|---|---|---|
| 0 | c | - | c | no |
| 1 | b | - | cb | no |
| 2 | a | - | cba | yes → add 0 |
| 3 | e | c | bae | no |
| 4 | b | b | aeb... | no |

**Complexity:** Time O(26 · n) ≈ O(n). Space O(1).
(To make it truly O(n), track a `matches` counter instead of scanning 26 values.)

**Edge cases:** `|s| < |p|` → empty; overlapping matches (`"abab"`, `"ab"` → 0, 1, 2).

**Interview traps**
- Check only when the window is full (`i >= k - 1`).
- The leaving index is `i - k` (not `i - k + 1`).
- Add `i - k + 1` to the answer (start of window), not `i`.

**Pattern:** "anagram inside a longer string" → fixed window + count array.
