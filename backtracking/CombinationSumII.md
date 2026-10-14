# Combination Sum II (LC 40)

**Problem:** Candidates may contain **duplicates**; each element can be used **at most once**. Return all **unique** combinations that sum to `target`.

**Brute force:** Generate all subsets, filter by sum, dedupe with a set → O(2ⁿ · n) plus memory.
**Optimal:** **Sort** + backtracking with `i + 1` (each element once) + skip same-level duplicates (`i > start && c[i] == c[i-1]`) + break when `c[i] > remaining`.

**Intuition:** Same dedupe trick as Subsets II: among equal numbers at the same level, only the first may start a branch.

**Complexity:** Time O(2ⁿ), Space O(n) stack.

**Edge cases:** All elements equal (`[1,1,1]`, 2 → `[[1,1]]`), no valid combination, a candidate larger than the target.

**Interview traps**
- **Recurse with `i + 1`**: elements can't be reused. (Combination Sum I uses `i`.)
- **`i > start`**, not `i > 0`, for the duplicate skip.
- Sorting is required for both the skip and the early `break`.
- Common mix-up: "unique combinations" means unique as value lists, not unique index sets.

**How to explain:** "Sort, then pick elements in increasing order, using each at most once. To avoid repeated combinations I skip an element equal to the previous one at the same level."
