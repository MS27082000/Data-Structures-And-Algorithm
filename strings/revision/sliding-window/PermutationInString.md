# Permutation in String (LC 567)

**Problem:** Return true if `s2` contains any permutation of `s1` as a substring.

**Approach:** Same as Find All Anagrams, but stop at the first match. Fixed window of size `|s1|`, one 26-array of counts, all zeros means a permutation.

**Complexity:** Time O(26 · n), Space O(1).

**Edge cases:** `s1` longer than `s2` → false.

**Interview traps:** The permutation must be a contiguous substring, so a window is needed (not a subsequence).

**Pattern:** "permutation / anagram inside a longer string" → fixed window + frequency array.
