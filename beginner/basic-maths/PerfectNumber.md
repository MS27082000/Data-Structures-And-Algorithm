# Check for Perfect Number

**Problem:** A number is perfect if it equals the sum of its proper divisors (6 = 1 + 2 + 3).

**Intuition:** Divisors come in pairs (d, n/d), so scan only up to sqrt(n) and add both, taking care of a repeated square root.

**Approach / complexity:** Brute force O(n). Optimised O(sqrt n) time, O(1) space.

**Edge cases:** 1 is not perfect. Perfect squares (do not double-count the root). n <= 1.

**Interview traps**
- Exclude n itself.
- Do not add d and n/d twice when they are equal.

**How to explain:** "I add each divisor and its partner up to the square root and compare the sum with n."
