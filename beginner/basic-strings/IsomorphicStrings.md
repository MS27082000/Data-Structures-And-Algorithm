# Isomorphic Strings (LC 205)

**Problem:** Can the characters of s be consistently replaced to get t, with no two characters mapping to the same one?

**Intuition:** Keep a map from s to t AND from t to s; both must stay consistent.

**Approach / complexity:** O(n) time, O(1) space (arrays of 256).

**Edge cases:** Different lengths, 'ab' vs 'aa' (needs the reverse map), repeated characters.

**Interview traps**
- A single forward map misses 'badc' vs 'baba'.
- Do not use 0 as 'unmapped' if a character could map to the null character.

**How to explain:** "I maintain mappings in both directions and fail on any conflict."
