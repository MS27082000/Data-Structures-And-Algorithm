# Is Subsequence (LC 392)

**Problem:** Can `s` be formed by deleting some characters of `t` without changing the order?

**Approach:** Pointer `i` on `s`, pointer `j` scanning `t`. When the characters match, move `i`. At the end, `i == s.length()` means yes.

**Complexity:** Time O(|t|), Space O(1).

**Edge cases:** Empty `s` → true; empty `t` with non-empty `s` → false.

**Interview traps:** Subsequence keeps order but need not be contiguous (that is a substring). Follow-up with many `s` queries → store the positions of each letter in `t` and binary search.

**Pattern:** "order preserved, gaps allowed" → one pointer per string, advance the first only on a match.
