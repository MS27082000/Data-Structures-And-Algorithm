# Reverse Words in a String (LC 151)

**Problem:** Reverse the order of the words. Remove leading/trailing spaces and collapse multiple spaces between words to one.

**Intuition:** Words are separated by runs of spaces. Take the words, output them from last to first, joined by a single space.

**Brute force / simple:** `trim().split("\\s+")`, then join from the end. O(n) time, O(n) space.
**Scan version:** Walk from the right, skip spaces, find a word's boundaries, append it. No split needed.
**In-place version (O(1) extra):** reverse the whole char array, reverse each word back, then squeeze out extra spaces with a read/write pointer.

**Edge cases:** All spaces -> empty string. Single word. Leading/trailing/multiple spaces.

**Interview traps**
- `split(" ")` creates empty strings for repeated spaces; use `\\s+` after trimming.
- Do not leave a trailing space.
- Ask whether the string is mutable; the in-place trick is the follow-up.

**How to explain:** "Reverse the whole string, then reverse each word to fix its letters, while compacting the spaces. Or just collect words from the right."
