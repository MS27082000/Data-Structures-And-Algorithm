# Sum of Beauty of All Substrings (LC 1781)

**Problem:** The **beauty** of a string is (highest character frequency) - (lowest frequency among characters that appear). Return the sum of beauty over all substrings.

**Brute force:** For every substring build a frequency map from scratch → O(n³).
**Optimal:** For each start `i`, extend `j` and **update a 26-size frequency array incrementally**. Compute max and min by scanning the 26 slots → O(26 · n²) time, O(1) space.

**Intuition:** Substrings sharing a start only differ by one added character, so the frequency array updates in O(1). Only the max/min scan costs 26.

**Complexity:** Time O(26 · n²) ≈ O(n²), Space O(1).

**Edge cases:** Single character (0), all distinct (0), all the same (0), `"aabcb"` → 5.

**Interview traps**
- The **min must ignore letters with frequency 0**. Otherwise the beauty is always `max - 0`.
- Reset `freq` for each new start `i`.
- Don't use a HashMap here, since the fixed array is faster and simpler.
- An O(n²) total is expected, as there is no known simple O(n) solution.

**How to explain:** "For each starting index I grow the substring one character at a time, keep letter counts in an array of 26, and add max minus min (over present letters) to the total."
