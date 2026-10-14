# Palindrome Number (LC 9)

**Problem:** Is the integer the same when its digits are reversed?

**Intuition:** Reverse and compare. Better: reverse only half the digits and compare the halves, which can never overflow.

**Approach / complexity:** Full reverse O(log n) time, O(1) space. Half reverse: stop when reversed >= remaining.

**Edge cases:** Negative numbers are not palindromes. Numbers ending in 0 (10) are not, except 0. Odd length: drop the middle with rev / 10.

**Interview traps**
- Reject negatives and trailing zeros first.
- Odd versus even length in the final comparison.
- Converting to a string works but uses extra space.

**How to explain:** "I reverse the second half and compare it with the first half; no overflow is possible."
