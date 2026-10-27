# First Unique Character in a String (LC 387)

**LeetCode:** [387](https://leetcode.com/problems/first-unique-character-in-a-string/)

**Problem:** Return the index of the first character that appears exactly once, or `-1`.
`"loveleetcode"` → `2` (the `v`)

**Brute force:** For each character, scan the whole string for another copy → O(n²).

**Key idea:** Counting needs a full pass, but *order* is only known from the original string. So: pass 1 counts, pass 2 walks in order and returns the first with count 1.

**Dry run (`"leetcode"`):**
- counts: l=1, e=3, t=1, c=1, o=1, d=1
- walk: `l` → count 1 → return `0`

**Complexity:** Time O(n). Space O(1).

**Edge cases:** All repeated (`"aabb"`) → `-1`; single char → `0`.

**Interview traps**
- Second pass must go over the **string**, not the count array. The array has no order.
- Follow-up (stream of characters): keep a `LinkedHashMap` or a queue of candidates.

**Pattern:** "first / earliest with a property" → count first, then scan in original order.
