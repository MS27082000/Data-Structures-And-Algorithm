# Implement Trie II (Advanced Operations)

**Problem:** Support `insert`, `countWordsEqualTo(word)`, `countWordsStartingWith(prefix)` and `erase(word)` (duplicates allowed).

**Intuition:** Replace the boolean flag with counters per node: `endCount` (words ending here) and `prefixCount` (words passing through here). Insert increments along the path; erase decrements the same path.

**Brute force:** Scan a list of all words for every query, O(n * L).
**Optimised:** O(L) per operation.

**Edge cases:** Duplicate insertions. Erasing a word that is not present (guard it). Prefix equal to a whole word.

**Interview traps**
- Update `prefixCount` on every node of the path, but `endCount` only on the last one.
- Erase decrements the counts - you do not need to delete nodes.
- Verify the word exists before decrementing or the counts go negative.

**How to explain:** "Each node remembers how many words pass through it and how many end at it, so both counts are a single path walk."
