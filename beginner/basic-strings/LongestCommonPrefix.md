# Longest Common Prefix (LC 14)

**Problem:** Longest prefix shared by every string in the array.

**Intuition:** Compare column by column against the first word; stop on the first mismatch or the end of any word.

**Approach / complexity:** O(total characters) time, O(1) space. Sorting alternative: compare only the first and last word.

**Edge cases:** Empty array, one string, an empty string in the array, a word that is a prefix of another.

**Interview traps**
- Check each word's length before charAt.
- Return the prefix of the first word.

**How to explain:** "I check one character position at a time across all words and stop at the first disagreement."
