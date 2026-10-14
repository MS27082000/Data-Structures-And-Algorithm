# Highest Occurring Element in an Array

**Problem:** Find the element with the highest frequency (ties: the smaller value).

**Intuition:** Count frequencies with a hash map, then pick the best count.

**Approach / complexity:** O(n) time, O(n) space. If values are small, a count array is faster.

**Edge cases:** Ties, single element, negative numbers.

**Interview traps**
- State the tie rule.
- Iterating a HashMap gives no order, so compare values explicitly.

**How to explain:** "I count occurrences in a map and keep the element with the largest count."
