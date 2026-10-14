# Valid Anagram (LC 242)

**Problem:** Do the two strings have the same letters with the same counts?

**Intuition:** Count letters up for one string and down for the other; everything should return to 0.

**Approach / complexity:** O(n) time, O(1) space (26 counters). Sorting: O(n log n).

**Edge cases:** Different lengths, empty strings, same letters with different counts. For Unicode use a HashMap.

**Interview traps**
- Check the lengths first.
- Assumes lowercase letters; ask about Unicode.

**How to explain:** "Equal letter counts mean an anagram, which a single counting array verifies."
