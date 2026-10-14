# Count Good Numbers (LC 1922)

**Problem:** A digit string of length `n` is **good** if digits at **even** indices are even (0,2,4,6,8) and digits at **odd** indices are prime (2,3,5,7). Count good strings of length `n`, modulo 10⁹+7. (`n` up to 10¹⁵.)

**Brute force:** Generate all digit strings → impossible.
**Optimal:** Pure counting. Even indices: **5** choices each, there are `ceil(n/2)` of them. Odd indices: **4** choices each, `floor(n/2)` of them. Answer = `5^ceil(n/2) · 4^floor(n/2) mod M`.

**Method:** Fast modular exponentiation → O(log n).

**Intuition:** Every position is independent, so by the multiplication principle you multiply the number of options per position.

**Complexity:** Time O(log n), Space O(1) (iterative) or O(log n).

**Edge cases:** `n = 1` (5), `n = 2` (20), very large `n` (use `long`).

**Interview traps**
- `n` is up to 10¹⁵, so use **`long`** for it.
- **Reduce mod after every multiplication** and multiply in `long` (product of two values below 10⁹+7 fits in `long`).
- Index 0 is even, so the even-index count is `(n+1)/2`.
- Applying the modulus only at the end overflows.

**How to explain:** "Each even slot has five choices and each odd slot has four, so the answer is 5 to the number of even slots times 4 to the number of odd slots, computed with fast modular power."
