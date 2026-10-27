# String Compression (LC 443)

**LeetCode:** [443](https://leetcode.com/problems/string-compression/)

**Problem:** Compress runs of equal characters in place: `aabbccc` → `a2b2c3`. A run of length 1 is written as just the character. Return the new length.

**Key idea:** Two pointers.
- **read** finds the end of each run of equal characters.
- **write** puts the character, then the run length (only if > 1) digit by digit.
`write` never overtakes `read`, so it is safe to overwrite in place.

**Dry run (`a a b b b`):**
| run | read after | write |
|---|---|---|
| `aa` | 2 | `a`, `2` → write = 2 |
| `bbb` | 5 | `b`, `3` → write = 4 |
Result `a2b3`, return `4`.

**Complexity:** Time O(n). Space O(1).

**Edge cases:** Single character (`["a"]` → 1); a run of 12 is written as `'1'`, `'2'` (two cells); no repeats (unchanged).

**Interview traps**
- Counts of 10 or more take several cells; write each digit separately.
- Do not write the count when it is 1.
- Use `read - start` for the run length (no separate counter needed).

**Pattern:** "in-place rewrite" → reader/writer two pointers (same as Remove Duplicates, Move Zeroes).
