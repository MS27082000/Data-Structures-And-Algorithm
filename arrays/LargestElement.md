# Largest Element in an Array

**Problem:** Return the maximum element.

**Brute force:** Sort and take the last → O(n log n). Unnecessary.
**Optimal:** One pass tracking the max so far → O(n) time, O(1) space.

**Intuition:** The max of the first i elements is either the previous max or `a[i]`.

**Edge cases:** All negatives, a single element, duplicates of the max.

**Interview traps**
- **Don't initialise max to 0.** An all-negative array returns the wrong answer. Use `a[0]` or `Integer.MIN_VALUE`.
- Ask about the empty array. Here we assume at least one element.

**How to explain:** "Keep a running maximum starting from the first element and update it as I scan. One pass."
