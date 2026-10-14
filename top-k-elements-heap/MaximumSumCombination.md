# Maximum Sum Combination

**Problem:** Two arrays `A` and `B` of size `n`. Consider all `n²` sums `A[i] + B[j]`. Return the **K largest** sums in descending order.

**Brute force:** Compute all `n²` sums, sort, take K → O(n² log n).
**Optimal:** **Sort both arrays in descending order.** The largest sum is `(0, 0)`. From a pair `(i, j)` the next-best candidates are `(i + 1, j)` and `(i, j + 1)`.
Use a **max-heap** of `{sum, i, j}` as a frontier and a **visited set** so each pair is pushed once. Pop K times → **O(n log n + K log K)**.

**Intuition:** It is a k-way merge over the implicit sorted rows `A[i] + B[0..n−1]`, or a best-first search over the grid of pairs where sums only decrease as indices grow.

**Complexity:** Time O(n log n + K log K), Space O(K).

**Edge cases:** `K = 1`, `K = n²` (all sums), negatives, duplicates in the arrays.

**Interview traps**
- **Visited set is required.** Without it the pair `(i+1, j+1)` is reached from two parents and duplicated.
- Encode the pair as a single key (`i·n + j`, in `long`).
- Both arrays **must be sorted descending** for the frontier logic to be valid.
- Related: **Find K Pairs with Smallest Sums** (LC 373) is the ascending version.

**How to explain:** "After sorting both arrays descending, the best sum is the first pair. I keep a max-heap of candidate pairs and, each time I pop one, push its two neighbours that I haven't seen, which yields the sums in decreasing order."
