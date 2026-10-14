# Sum of First N Numbers

**Problem:** Compute 1 + 2 + ... + N.

**Intuition:** sum(n) = n + sum(n - 1), with sum(0) = 0.

**Approach / complexity:** Recursion O(n) time and stack. Formula n(n+1)/2 is O(1) time.

**Edge cases:** n = 0, large n (use long).

**Interview traps**
- Mention the closed-form formula as the better answer.
- Stack depth for large n.

**How to explain:** "Each call adds n and delegates the rest to n-1; the formula n(n+1)/2 does it in constant time."
