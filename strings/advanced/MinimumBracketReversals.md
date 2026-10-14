# Minimum Number of Bracket Reversals

**Problem:** A string of only `{` and `}`. Minimum number of single-bracket flips to make it balanced; -1 if impossible.

**Intuition:** An odd length can never balance. Cancel every matched `{}` pair (stack or two counters). What is left is always `}}}...{{{` - `a` unmatched closes then `b` unmatched opens. Flipping handles two at a time: `ceil(a/2) + ceil(b/2)`. If both counts are odd, the two leftovers `}{` need 2 flips, which the formula already gives.

**Brute force:** Try flipping subsets of brackets, O(2^n).
**Optimised:** O(n) time, O(1) space with counters (O(n) with a stack).

**Edge cases:** Odd length -> -1. Empty string -> 0. Already balanced -> 0.

**Interview traps**
- Check the odd-length case first.
- Count unmatched closes when `open == 0`; do not push them on a stack of opens only.
- `(x + 1) / 2` is the integer ceiling.

**How to explain:** "After removing matched pairs I am left with some closes followed by some opens. Two closes cost one flip, two opens cost one flip, and an odd leftover pair costs two."
