# Word Ladder I (LC 127)

**Problem:** Transform `beginWord` into `endWord` changing **one letter at a time**; every intermediate word must be in `wordList`. Return the **number of words** in the shortest sequence (including both ends), or 0.

**Approach (BFS on an implicit graph):** Words are nodes; two words are connected if they differ in exactly one position. Shortest path with unit edges → **BFS**.
To find neighbours quickly, instead of comparing against every word (O(N·L) per word), **generate all `L × 26` one-letter variants** of the current word and check them in a `HashSet`. **Remove a word from the set when it is first reached** (that is the visited marker) → **O(N · L · 26)** time.

**Intuition:** The first time BFS reaches `endWord` is along a shortest ladder.

**Complexity:** Time O(N · L · 26) (N = words, L = length), Space O(N · L).

**Edge cases:** `endWord` not in the list (0), `beginWord` not in the list (allowed), adjacent words (answer 2), no connecting chain (0).

**Interview traps**
- **`endWord` must be in the list**, otherwise return 0 immediately.
- The answer counts **words**, not transformations (`hit→hot→dot→dog→cog` = 5).
- Remove words from the set instead of keeping a separate `visited`.
- Optimisation for large inputs: **bidirectional BFS**.

**How to explain:** "It's a shortest path between words, so BFS. To get neighbours I try every letter in every position and keep the results that are in the dictionary, deleting them from the dictionary so I never revisit a word."
