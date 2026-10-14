# Shortest Common Supersequence (LC 1092)

**Problem:** Shortest string containing both strings as subsequences.

**Intuition:** Length = `m + n - LCS` (common part written once). To build it, walk the LCS table back: on a match write the char once and go diagonal; otherwise write the char of the string you step away from. Flush the leftovers at the end.

**Brute force:** Try all merges.
**Optimised:** O(m*n) time and space.

**Edge cases:** One string empty -> the other. Identical -> same string. No common chars -> concatenation.

**Interview traps**
- Many valid answers exist; any shortest one is accepted.
- The leftover loops after the main walk.
- Reverse the builder at the end.

**How to explain:** "Overlap the LCS and write everything else around it, following the DP table backwards."
