# Count of Prime Numbers Till N (LC 204)

**Problem:** Count the primes up to N. LeetCode 204 counts primes strictly less than n.

**Intuition:** Cross out multiples of each prime starting at p*p (Sieve of Eratosthenes).

**Approach / complexity:** Brute force O(n sqrt n). Sieve O(n log log n) time, O(n) space.

**Edge cases:** n < 2 -> 0. Inclusive versus strictly-less-than.

**Interview traps**
- Start crossing at p*p and use long for it.
- Check whether the question is inclusive.

**How to explain:** "I mark composites with a sieve and count the numbers left unmarked."
