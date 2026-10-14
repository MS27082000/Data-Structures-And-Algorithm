# Divisors of a Number

**Problem:** List all divisors of n.

**Intuition:** Divisors pair up as (d, n/d), so loop to sqrt(n), add both and sort.

**Approach / complexity:** Brute force O(n). Optimised O(sqrt n + k log k) time, O(k) space.

**Edge cases:** n = 1 -> [1]. Perfect squares. Primes -> [1, n].

**Interview traps**
- Skip the duplicate when d == n/d.
- The paired divisors come out unsorted.

**How to explain:** "I find every divisor up to the square root and add its partner n/d."
