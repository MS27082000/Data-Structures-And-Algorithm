# Two Sum (LC 1)

**Problem:** Unsorted array; return the **indices** of two numbers that add up to `target` (exactly one answer, no element used twice).

**Brute force:** Check all pairs → O(n²) time, O(1) space.
**Better (sorted + two pointers):** Sorting loses the original indices (you'd have to carry them) → O(n log n).
**Optimal:** HashMap `value → index`. For each `x`, look for `target - x` among earlier elements → O(n) time, O(n) space.

**Intuition:** Instead of searching for a partner (O(n)), remember what you've seen and look up the partner in O(1).

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Duplicates (`[3,3]`, 6), negatives, zero, the target made of the same element twice (`[3,2,4]`, 6 must give `[1,2]`, not index 0 twice).

**Interview traps**
- **Check the complement before inserting the current element.** That prevents using one element twice.
- Compare with Two Sum II (sorted): there, two pointers give O(1) space. Mention the trade-off.
- Return indices, not values.

**How to explain:** "One pass with a hashmap of seen values. For each number I check whether its complement is already in the map. O(n) time, O(n) space."
