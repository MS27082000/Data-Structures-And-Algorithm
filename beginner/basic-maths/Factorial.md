# Factorial of a Given Number

**Problem:** Compute n! = 1 * 2 * ... * n.

**Intuition:** Multiply the numbers from 2 to n. 0! and 1! are 1.

**Approach / complexity:** Loop: O(n) time, O(1) space. long holds up to 20!; use BigInteger beyond that or a modulo when asked.

**Edge cases:** n = 0, n = 1, overflow at 21!.

**Interview traps**
- Silent overflow in int/long.
- 0! = 1, not 0.
- Recursive version uses O(n) stack.

**How to explain:** "I multiply from 2 to n; for large n I switch to BigInteger or work modulo a prime."
