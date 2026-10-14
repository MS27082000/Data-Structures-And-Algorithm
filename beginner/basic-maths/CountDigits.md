# Count All Digits of a Number

**Problem:** Count how many digits n has.

**Intuition:** Every division by 10 removes one digit; count the divisions until n is 0.

**Approach / complexity:** Loop: O(log10 n) time, O(1) space. Math: floor(log10 n) + 1 (floating point; risky at exact powers of 10).

**Edge cases:** n = 0 has 1 digit. Negative numbers (take abs). Long values.

**Interview traps**
- Special-case 0 or the loop returns 0.
- Use long for big inputs.
- log10 can be off by one near powers of 10.

**How to explain:** "I keep dividing by 10 and count the steps; zero is a special case with one digit."
