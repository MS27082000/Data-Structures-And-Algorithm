# Count Primes in Range [L, R]

**Problem:** Count primes between L and R, usually for many queries.

**Intuition:** Sieve once up to the largest R, then build a prefix array `prefix[i]` = number of primes `<= i`. Each query is `prefix[R] - prefix[L-1]`.

**Brute force:** Primality test every number in the range per query, O(q * (R-L) * sqrt(R)).
**Optimised:** Sieve + prefix counts: O(N log log N) preprocessing, O(1) per query.
**Huge R (e.g. 10^12) with a small range:** **Segmented sieve** - find primes up to `sqrt(R)` first, then cross out their multiples only inside `[L, R]`. Memory is O(sqrt(R) + (R - L)).

**Edge cases:** `L < 2` (clamp to 2). `R < 2` -> 0. `L > R`. L = R prime.

**Interview traps**
- `prefix[L-1]` with L = 0 or 1 needs a clamp.
- In the segmented sieve start at `max(p*p, first multiple of p >= L)` so the prime p itself is not crossed out.
- Use `long` for values and indices once R exceeds the int range.

**How to explain:** "One sieve plus a running count answers every range in constant time; if R is too big to sieve, I sieve only the window using the primes up to its square root."
