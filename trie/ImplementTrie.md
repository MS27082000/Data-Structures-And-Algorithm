# Implement Trie / Prefix Tree (LC 208)

**Problem:** Build a structure with `insert(word)`, `search(word)` (exact word) and `startsWith(prefix)`.

**Intuition:** A tree where each node has up to 26 children (one per letter) and an `isEnd` flag. A word is a path from the root; shared prefixes share nodes.

**Brute force:** A list or hash set of words. `search` is O(1) in a hash set, but `startsWith` needs a scan of every word, O(n * L).
**Optimised:** Trie - every operation is O(L), independent of how many words are stored. Space O(total characters * 26) with arrays.

**Edge cases:** Empty prefix -> true. A word that is a prefix of another (`app` vs `apple`) - this is what `isEnd` is for. Searching a longer word than any stored.

**Interview traps**
- `search("app")` must be false when only `apple` was inserted: the path exists but `isEnd` is false.
- Use a `HashMap` child map for large alphabets; an array for lowercase letters.
- Space is the cost of a trie; mention it.

**How to explain:** "Each letter is an edge. Insert follows or creates edges; search follows edges and checks the end flag; startsWith only needs the path to exist."
