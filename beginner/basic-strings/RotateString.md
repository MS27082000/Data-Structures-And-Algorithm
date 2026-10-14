# Rotate String (LC 796)

**Problem:** Can s become goal by moving some leading characters to the end?

**Intuition:** Every rotation of s is a substring of s + s, so check that goal is inside s + s and has the same length.

**Approach / complexity:** O(n) with KMP; contains() is fine in practice. Brute force O(n^2).

**Edge cases:** Different lengths, empty strings, repeated characters.

**Interview traps**
- The length check is essential: 'aa' vs 'a' would otherwise say true.

**How to explain:** "All rotations of s appear inside s concatenated with itself."
