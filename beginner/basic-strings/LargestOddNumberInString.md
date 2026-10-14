# Largest Odd Number in a String (LC 1903)

**Problem:** Return the largest odd number that is a substring of a digit string, or empty.

**Intuition:** A number is odd iff its last digit is odd, and a longer prefix is a bigger number, so take the prefix up to the rightmost odd digit.

**Approach / complexity:** O(n) time, O(1) space.

**Edge cases:** No odd digit -> empty string. Leading digits are kept as they are.

**Interview traps**
- Scan from the right.
- Return the prefix, not just the digit.

**How to explain:** "The biggest odd substring starts at index 0 and ends at the last odd digit."
