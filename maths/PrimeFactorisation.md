# Prime Factorisation of a Number

**Problem:** Write n as a product of primes (e.g. `60 = 2 * 2 * 3 * 5`).

**Intuition:** Divide out each factor d starting from 2 while `d*d <= n`. Each time d divides n, record it and divide. If something larger than 1 is left at the end, it is a prime factor too (it has no divisor up to its square root).

**Brute force:** Check every number up to n for divisibility and primality, O(n * ...).
**Optimised (single number):** Trial division, O(sqrt(n)).
**Optimised (many queries):** Build a **smallest prime factor (SPF)** array with a sieve (O(N log log N)). Then each query divides repeatedly by `spf[x]` in O(log x).

**Edge cases:** n = 1 -> no factors. n prime -> itself. Powers of 2. n near `Integer.MAX_VALUE` (cast `d*d` to `long`).

**Interview traps**
- Forgetting the leftover prime > 1 after the loop.
- No need to check that d is prime: composite d never divides because its prime parts were already removed.
- In the SPF sieve only set `spf[m]` if it is still unset (the smallest prime wins).

**How to explain:** "Divide by the smallest possible factor repeatedly. Anything left over after the square root must itself be prime. For many queries I precompute each number's smallest prime factor."
