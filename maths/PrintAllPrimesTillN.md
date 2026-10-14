# Print All Primes Till N (Sieve of Eratosthenes)

**Problem:** List every prime number from 1 to N.

**Intuition:** Assume every number is prime. Take the smallest unmarked number p (it is prime), then cross out all its multiples. Repeat. What stays unmarked is prime. Start crossing at `p*p`, because smaller multiples like `2p`, `3p` were already crossed out by smaller primes. Stop when `p*p > N`.

**Brute force:** Trial division of each number up to its square root, O(N * sqrt(N)).
**Optimised:** Sieve, O(N log log N) time, O(N) space (a boolean array; a bitset or odd-only sieve saves memory).

**Edge cases:** N < 2 -> empty. N = 2 -> `[2]`. 1 is not prime. Large N (10^7+) needs the boolean array, not a list of Integers.

**Interview traps**
- Start the inner loop at `p*p` and use `long` for `p*p` when N is near `Integer.MAX_VALUE`.
- Outer loop runs only to `sqrt(N)`.
- Do not mark `p` itself as composite.

**How to explain:** "Cross out multiples of each prime starting from its square. Every composite has a prime factor up to its square root, so it gets crossed out before I finish."
