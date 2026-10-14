# Count the Number of Odd Digits

**Problem:** Count the odd digits in a number.

**Intuition:** Peel the last digit with % 10, test if it is odd, then divide by 10.

**Approach / complexity:** O(log10 n) time, O(1) space.

**Edge cases:** n = 0 -> 0. Negative numbers (use abs).

**Interview traps**
- Take abs first, otherwise % gives negative digits.
- Test with d % 2 == 1 only after the digit is non-negative.

**How to explain:** "I extract each digit with modulo 10 and count the odd ones."
