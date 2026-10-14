# Subsets II (LC 90)

**Problem:** Array that may contain **duplicates**. Return all **unique** subsets.

**Brute force:** Generate all subsets (as in Subsets I) and dedupe with a `Set` of sorted lists → O(n·2ⁿ) with extra memory and sorting cost.
**Optimal:** **Sort**, then skip duplicates at the **same recursion level**: `if (i > start && nums[i] == nums[i-1]) continue;`

**Intuition:** After sorting, equal elements are adjacent. At one level of the recursion, choosing the second `2` as the first element of a branch would recreate the same subsets as choosing the first `2`. Skipping it avoids the repeats, while still allowing `[2, 2]` (second `2` chosen deeper, in the next level).

**Complexity:** Time O(n · 2ⁿ), Space O(n) stack.

**Edge cases:** All elements equal (`[2,2,2]`), no duplicates, empty array, negatives.

**Interview traps**
- **`i > start`, not `i > 0`.** With `i > 0` you also wrongly forbid `[2, 2]` (using the second 2 deeper in the same path).
- **Sorting is required**, or duplicates aren't adjacent.
- This "same level skip" trick is reused in Combination Sum II and Permutations II.

**How to explain:** "I sort so duplicates sit together. At each level I only use the first of a run of equal numbers as a branch start, which stops identical subsets from being generated twice."
