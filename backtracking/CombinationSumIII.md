# Combination Sum III (LC 216)

**Problem:** Find all combinations of exactly `k` **distinct** numbers from `1..9` that sum to `n`. Each number is used at most once.

**Brute force:** Check all `2⁹ = 512` subsets → fine here (only 9 numbers), but the backtracking is the expected pattern.
**Optimal:** Backtracking over `num = start..9`, recursing with `num + 1`. Record when `path.size() == k && remaining == 0`.

**Pruning:** If `num > remaining`, break (numbers only grow). Stop when the path already has `k` elements.

**Intuition:** Choosing in increasing order gives unique combinations (no permutations), and picking only from 1..9 keeps the search tiny.

**Complexity:** Time O(C(9, k) · k), Space O(k) stack.

**Edge cases:** No answer (`k = 4, n = 1`), `n` too large for `k` numbers (`k = 2, n = 18`), `k = 9, n = 45` (all digits).

**Interview traps**
- **Exactly `k` numbers**: check the size, not just the sum.
- Recurse with `num + 1` (no reuse).
- Don't forget to stop at the size limit, otherwise the recursion keeps adding numbers.
- It's the "k elements, fixed pool, no reuse" version of the combination-sum family.

**How to explain:** "I pick increasing numbers from 1 to 9. When I have k numbers I check whether they sum to n; I prune early when the number alone exceeds the remaining sum."
