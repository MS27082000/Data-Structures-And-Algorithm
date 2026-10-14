# Reverse String II (LC 541)

**Problem:** For every 2k characters, reverse the first k. If fewer than k remain reverse them all; if between k and 2k remain reverse the first k. (Assumption: the sheet's Reverse a String II is LC 541.)

**Intuition:** Jump 2k at a time and reverse each [i, min(i+k, n)-1] segment with two pointers.

**Approach / complexity:** O(n) time, O(n) space for the char array.

**Edge cases:** k larger than the string, string shorter than k, empty string.

**Interview traps**
- Clamp the right end with min(i + k - 1, n - 1).
- Step by 2k, not k.

**How to explain:** "I walk in blocks of 2k and reverse the first k characters of each block."
