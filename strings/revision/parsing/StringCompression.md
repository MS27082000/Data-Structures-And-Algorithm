# String Compression (LC 443)

**Problem:** Compress runs of repeated characters in place (`aabbccc` → `a2b2c3`). Counts of 1 are not written. Return the new length.

**Approach:** Reader/writer pointers. The reader finds the end of the current run. The writer writes the character, then the run length as digits if it is more than 1.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Single character; run of 10 or more (count has several digits, `"12"` is written as `'1','2'`); no repeats.

**Interview traps:** Write the count digit by digit. The write pointer never passes the read pointer, so in-place is safe.

**Pattern:** "in-place rewrite" → reader/writer two pointers.
