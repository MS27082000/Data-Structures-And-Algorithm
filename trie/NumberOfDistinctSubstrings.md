# Number of Distinct Substrings in a String

**Problem:** Count the distinct substrings of a string.

**Intuition:** Every substring is a prefix of some suffix. Insert **all suffixes** into a trie; each time a **new node** is created, a new distinct substring has been found. The answer is the number of nodes (excluding the root).

**Brute force:** Put every substring in a hash set, O(n^3) time and space.
**Optimised:** Suffix trie, O(n^2) time and space. (Suffix array + LCP does O(n log n); a suffix automaton does O(n) - mention as follow-ups.)

**Edge cases:** All same letters (`aaa` -> 3). Empty string -> 0. Some versions also count the empty substring (+1) - clarify.

**Interview traps**
- Clarify whether the empty substring is counted.
- Count **new nodes**, not words.
- n is limited by the O(n^2) memory.

**How to explain:** "Each suffix path adds only the substrings that are new; I count a new substring whenever I create a new trie node."
