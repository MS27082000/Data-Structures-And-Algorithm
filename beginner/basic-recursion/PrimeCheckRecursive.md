# Check if a Number is Prime (Recursive)

**Problem:** Test primality with recursion.

**Intuition:** Try divisors d = 2, 3, ... recursively until d*d > n (prime) or one divides n (not prime).

**Approach / complexity:** O(sqrt n) time and stack.

**Edge cases:** n < 2, n = 2.

**Interview traps**
- Handle n < 2 first.
- Stop at d*d > n, not at n.

**How to explain:** "I recurse over possible divisors and stop at the square root."
