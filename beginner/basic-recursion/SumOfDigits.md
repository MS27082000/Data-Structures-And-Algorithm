# Sum of Digits (Recursive)

**Problem:** Sum the digits of a number recursively.

**Intuition:** sum(n) = n % 10 + sum(n / 10), with sum(0) = 0.

**Approach / complexity:** O(log10 n) time and stack.

**Edge cases:** 0, negatives (take abs).

**Interview traps**
- Use abs for negative inputs.

**How to explain:** "I add the last digit and recurse on the number without it."
