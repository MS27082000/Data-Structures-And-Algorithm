# Sum of Array Elements

**Problem:** Add up all numbers in an array.

**Intuition:** One pass with an accumulator.

**Approach / complexity:** O(n) time, O(1) space.

**Edge cases:** Empty array -> 0. Large values overflow int.

**Interview traps**
- Use a long accumulator.
- Empty input.

**How to explain:** "I walk the array once and keep a running total in a long."
