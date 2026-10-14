# 4Sum (LC 18)

**Problem:** Find all **unique** quadruplets that sum to `target`.

**Brute force:** Four nested loops + a set to dedupe → O(n⁴).
**Better:** Fix `i`, `j`, hash the rest → O(n³) with messy dedupe.
**Optimal:** Sort, fix `i` and `j`, then two pointers on the rest → O(n³) time, O(1) extra space.

**Intuition:** Same reduction as 3Sum: every extra fixed number reduces the problem by one level (kSum = fix one, solve (k-1)Sum, base case two pointers).

**Complexity:** Time O(n³), Space O(1) (ignoring output and sort).

**Edge cases:** Fewer than 4 elements, all equal (`[2,2,2,2,2]`, target 8), negatives, large values.

**Interview traps**
- **Integer overflow:** the sum of four ints can exceed `int`. Cast to `long`.
- Skip duplicates at all four positions: `i`, `j`, `left`, `right`.
- Skip `j` duplicates with `j > i + 1`, not `j > 0`.
- Generalise: "kSum" recursion for any k.

**How to explain:** "Sort, fix two numbers with nested loops, then use two pointers for the other two. Skip duplicates at each level and use long for the sum."
