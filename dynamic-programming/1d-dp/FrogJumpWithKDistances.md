# Frog Jump with K Distances

**Problem:** Same as Frog Jump, but from i the frog may jump to any of i+1 ... i+k.

**Intuition:** `f(i) = min over j in 1..k of f(i-j) + |h[i] - h[i-j]|`. Same recurrence, just a loop over k previous stairs.

**Brute force:** Recursion with k branches, O(k^n).
**Optimised:** Tabulation, O(n * k) time, O(n) space.

**Edge cases:** k larger than n (limit j to i). n = 1 -> 0. k = 1 means no choice.

**Interview traps**
- Bound the inner loop: `i - j >= 0`.
- If k = 2 it reduces to the normal Frog Jump - mention this link.

**How to explain:** "I try every one of the last k stairs as the previous stop and take the cheapest total."
