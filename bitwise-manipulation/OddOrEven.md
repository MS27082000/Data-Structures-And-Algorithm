# Check if a Number is Odd or Even

**Problem:** Decide whether an integer is odd.

**Standard:** `n % 2 != 0`.
**Bit trick:** `(n & 1) == 1`. The lowest bit of an odd number is always 1.

**Intuition:** Every bit above bit 0 represents an even amount (2, 4, 8…), so only bit 0 decides parity.

**Complexity:** Time O(1), Space O(1).

**Edge cases:** `0` (even), negative numbers (`-3` is odd), `Integer.MIN_VALUE` (even).

**Interview traps**
- **`n % 2 == 1` is wrong for negatives in Java.** `-3 % 2` is `-1`. Use `n % 2 != 0` or `(n & 1) == 1`.
- Bitwise AND works for negatives because of two's complement (`-3` ends in ...101).
- Modern compilers optimise `% 2`, so the bit trick is mostly about showing understanding.

**How to explain:** "An odd number has its last bit set, so ANDing with 1 gives 1. Unlike `% 2 == 1`, this also works correctly for negative numbers."
