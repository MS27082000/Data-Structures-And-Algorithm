# Subset Sum Equals to Target

**Problem:** Is there a subset of non-negative numbers with sum exactly `target`?

**Intuition:** For each element: skip it or take it. `dp[s]` = can we form sum s. Iterating `s` **downwards** makes sure an element is used once.

**Brute force:** All subsets, O(2^n).
**Optimised:** O(n * target) time, O(target) space.

**Edge cases:** target = 0 -> true (empty subset). Element larger than target is skipped. All even numbers, odd target -> false.

**Interview traps**
- Iterate the sum downwards in the 1D version (upwards would allow reuse = unbounded).
- This is pseudo-polynomial: it depends on the value of the target, not the input size.

**How to explain:** "I keep a boolean array of reachable sums and, per number, mark new sums from the old ones going from high to low."
