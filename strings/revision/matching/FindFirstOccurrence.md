# Find the Index of the First Occurrence in a String (LC 28)

**Problem:** Return the first index where `needle` appears in `haystack`, or -1.

**Approach:** For each start `i` (only while `i + m <= n`), compare `needle` character by character. If all `m` characters match, return `i`.

**Complexity:** Time O(n · m), Space O(1).

**Edge cases:** Empty needle → 0; needle longer than haystack → -1.

**Interview traps:** Stop the loop at `i + m <= n` to avoid out-of-bounds. In an interview, `haystack.indexOf(needle)` is not accepted as the answer.

**Follow-up:** Use KMP (O(n + m)); see [KMPAlgorithm](../../advanced/KMPAlgorithm.md).
