# Reverse a String (Recursive)

**Problem:** Reverse a string using recursion.

**Intuition:** Swap the two ends of a char array and recurse on the inside; stop when the pointers meet.

**Approach / complexity:** Two-pointer recursion: O(n) time, O(n) stack. The substring version is easier to read but O(n^2).

**Edge cases:** Empty string, single character.

**Interview traps**
- Strings are immutable in Java; use a char array.
- Base case l >= r.

**How to explain:** "Swap the outer characters and reverse what is in between."
