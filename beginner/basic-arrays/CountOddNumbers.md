# Count of Odd Numbers in an Array

**Problem:** Count the odd values.

**Intuition:** A number is odd when its last bit is 1.

**Approach / complexity:** O(n) time, O(1) space.

**Edge cases:** Negative numbers, empty array, zero.

**Interview traps**
- -3 % 2 is -1 in Java, so x % 2 == 1 misses negative odds; use x % 2 != 0 or (x & 1) == 1.

**How to explain:** "I test the lowest bit of each element and count the ones that are set."
