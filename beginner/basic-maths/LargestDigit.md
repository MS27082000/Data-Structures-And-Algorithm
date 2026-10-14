# Return the Largest Digit in a Number

**Problem:** Find the biggest digit of n.

**Intuition:** Peel digits with % 10 and keep a running maximum.

**Approach / complexity:** O(log10 n) time, O(1) space. Stop early on a 9.

**Edge cases:** 0 -> 0. Negative numbers.

**Interview traps**
- Take abs first.
- Initialise max to 0, not to the number.

**How to explain:** "I scan the digits once, keeping the maximum seen."
