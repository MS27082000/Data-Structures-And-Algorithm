# Ransom Note (LC 383)

**LeetCode:** [383](https://leetcode.com/problems/ransom-note/)

**Problem:** Can `ransomNote` be made from letters of `magazine`, using each magazine letter at most once?
`("aa", "aab")` → `true`, `("aa", "ab")` → `false`

**Key idea:** The magazine is a *supply*, the note is a *demand*. Count the supply, then spend it. If you ever need a letter you don't have, it is impossible.

**Dry run (`note = "aa"`, `magazine = "ab"`):**
- supply: a=1, b=1
- need `a` → a=0 (ok)
- need `a` → a=-1 → below 0 → `false`

**Complexity:** Time O(n + m). Space O(1) (26 counters).

**Edge cases:** Empty note → `true`; note longer than magazine → `false` (can return early).

**Interview traps**
- Count the **magazine**, consume with the **note**. Reversing them gives wrong answers on unequal inputs.
- Not an anagram check: the magazine may have extra letters.

**Pattern:** "can A be built from B" → count B, subtract A, any negative → no.
