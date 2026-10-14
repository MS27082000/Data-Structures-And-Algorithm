# Rabin-Karp Algorithm

**Problem:** Find all occurrences of a pattern (length m) in a text (length n).

**Intuition:** Compare hashes instead of characters. Compute the pattern hash and the hash of the first text window of length m. Slide the window by one: remove the leading character, multiply by the base, add the new one - O(1). When the hashes match, compare the actual strings to rule out a collision.

**Brute force:** Compare the pattern at every position, O(n * m).
**Optimised:** Average O(n + m). Worst case O(n * m) if many windows collide (or many real matches, e.g. `aaaa` vs `aa` with verification).

**Edge cases:** Pattern longer than text, empty pattern, overlapping matches (`aa` in `aaaaa`), negative values after subtracting the leading char.

**Interview traps**
- Always verify on a hash match (false positives exist).
- Precompute `B^(m-1)`, the weight of the leading character.
- Keep everything `long` and add MOD before the final `%`.
- For worst-case guarantees use KMP or the Z-function.

**How to explain:** "I keep a rolling hash of the current window; if it equals the pattern hash I confirm with a direct comparison, so most positions cost O(1)."
