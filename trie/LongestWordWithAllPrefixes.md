# Longest Word with All Prefixes (Complete String) (LC 720)

**Problem:** From a list of words, find the longest word such that **every prefix** of it is also in the list. Ties go to the lexicographically smallest. Return an empty string if none.

**Intuition:** Insert all words in a trie. A word is valid if **every node on its path is marked as a word end**. Pick the longest (then smallest) valid one.

**Brute force:** For each word, check every prefix in a hash set, O(n * L^2).
**Optimised:** Trie, O(total characters) time and space. Another option: sort the words and keep a set of the words built so far, O(n log n * L).

**Edge cases:** No single-letter word -> nothing can start a chain (empty answer). Ties on length. Duplicates.

**Interview traps**
- The prefix of length 1 must itself be a word.
- Tie-breaking: smaller lexicographic order, not first seen.
- Check `isEnd` on **each** node of the path, not just the last.

**How to explain:** "A word counts only if the whole path is made of complete words. I check that in the trie and keep the longest, smallest one."
