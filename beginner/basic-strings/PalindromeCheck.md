# Palindrome Check (also LC 125)

**Problem:** Does the string read the same backwards? LC 125 ignores case and non-alphanumeric characters.

**Intuition:** Two pointers from both ends; for LC 125 skip non-alphanumeric characters.

**Approach / complexity:** O(n) time, O(1) space.

**Edge cases:** Empty string, a single character, only punctuation.

**Interview traps**
- Skip invalid characters with inner while loops that also check l < r.
- Compare lower-cased characters.
- Do not build a reversed copy if O(1) space is required.

**How to explain:** "Two pointers compare from the outside in, skipping characters that do not count."
