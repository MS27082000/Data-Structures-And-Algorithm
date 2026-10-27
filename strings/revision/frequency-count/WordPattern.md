# Word Pattern (LC 290)

**Problem:** Does the sentence `s` follow `pattern`? Each letter maps to exactly one word and each word to exactly one letter.

**Approach:** Same as Isomorphic Strings, with words instead of characters. Keep two maps (char → word, word → char) and check both directions on every position.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Different lengths → false; `"abba"` with `"dog dog dog dog"` → false (two letters, one word).

**Interview traps**
- One map is not enough. The check must be both ways.
- Compare words with `.equals`, not `==`.
- Use `!= c` on `Character` only because `c` is a primitive here. Otherwise use `.equals`.

**Pattern:** "one-to-one mapping" → two maps (or two last-seen arrays).
