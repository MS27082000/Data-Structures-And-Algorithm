# Factorial of a Given Number (Recursive)

**Problem:** Compute n! using recursion.

**Intuition:** n! = n * (n-1)!, with 0! = 1! = 1.

**Approach / complexity:** O(n) time, O(n) stack.

**Edge cases:** 0 and 1; overflow from 21! in long.

**Interview traps**
- Base case n <= 1.
- Overflow.

**How to explain:** "Factorial of n is n times factorial of n-1, ending at 1."
