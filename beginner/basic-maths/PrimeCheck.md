# Check for Prime Number

**Problem:** Is n prime (exactly two divisors: 1 and n)?

**Intuition:** A composite number has a divisor <= sqrt(n), so trial division can stop there.

**Approach / complexity:** Brute force O(n). Optimised O(sqrt n); skip evens to halve the work.

**Edge cases:** 0, 1 and negatives are not prime. 2 and 3 are prime. Large primes near Integer.MAX_VALUE.

**Interview traps**
- 1 is not prime.
- Use long for d*d to avoid overflow.
- For many queries use a sieve.

**How to explain:** "I only test divisors up to the square root, since any factor pair has one member below it."
