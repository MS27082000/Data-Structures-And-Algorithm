# Check if the Number is Armstrong

**Problem:** A number is Armstrong if the sum of its digits, each raised to the number of digits, equals the number (153 = 1^3 + 3^3 + 5^3).

**Intuition:** Count the digits k, then sum d^k over every digit and compare.

**Approach / complexity:** O(k * log k) time, O(1) space.

**Edge cases:** Single digits are Armstrong. 0 is Armstrong. Negatives are not.

**Interview traps**
- The power is the number of digits, not always 3.
- Do not use Math.pow with doubles for exact comparison; use an integer power loop.

**How to explain:** "I count the digits, raise each digit to that count, add them up and compare."
