# Hashing in Strings (Theory)

**Idea:** Turn a string into a number so that equal strings give equal numbers and comparison becomes O(1).

**Polynomial rolling hash:** `hash(s) = s[0]*B^(k-1) + ... + s[k-1]` (mod M). Build a prefix array: `prefix[i+1] = prefix[i]*B + s[i]`. The hash of any substring `[l, r)` is `prefix[r] - prefix[l] * B^(r-l)` (mod M). So after O(n) preprocessing every substring hash is O(1).

**Uses:** Rabin-Karp matching, comparing substrings, counting distinct substrings, palindrome checks (hash vs reverse hash), duplicate-substring problems.

**Collisions:** Different strings can share a hash. Reduce the risk with a large prime modulus (1e9+7), a base larger than the alphabet, double hashing (two moduli), and verify the match when the answer matters.

**Edge cases:** Negative values after subtraction (add M before the final mod). Use `long`, not `int`, to avoid overflow in `prefix * B`.

**Interview traps**
- Order matters in a polynomial hash (a plain character sum would make `abc` equal to `acb`).
- Do not use base 26 with value 0 for `a` (then `a` and `aa` collide); use `char` values or 1-based.
- Hash equality is probabilistic; mention verification or double hashing.

**How to explain:** "A rolling hash lets me compare substrings in O(1) after one pass, at the cost of a small collision risk that I control with a large modulus or a second hash."
