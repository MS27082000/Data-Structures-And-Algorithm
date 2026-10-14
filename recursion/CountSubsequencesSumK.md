# Count All Subsequences with Sum K

**Problem:** Count the subsequences whose sum equals `K`.

**Brute force / standard:** Take / not-take recursion returning `take + notTake` → O(2ⁿ).
**Optimised:** **Memoise** on `(index, remaining)` → O(n · K) time and space. This is the Subset Sum Count DP (and the start of the Dynamic Programming topic).

**Approach:** `count(index, remaining)`:
- Base case `index == n`: return `1` if `remaining == 0`, else `0`.
- Return `count(index+1, remaining - a[index]) + count(index+1, remaining)`.

**Intuition:** Every leaf of the recursion tree is one subsequence. A leaf contributes 1 if its sum matched, so summing the leaves counts them.

**Complexity:** Plain: Time O(2ⁿ), Space O(n). Memoised: O(n·K).

**Edge cases:** `K = 0` (the empty subsequence counts, and each zero doubles the count), empty array (1 when `K = 0`), no match.

**Interview traps**
- **Return `1` or `0` only at the end** (`index == n`). Returning 1 as soon as `remaining == 0` undercounts when zeros remain (they create extra subsequences).
- **Existence returns a boolean; counting returns an int.** Mixing them up is the common error.
- Memoisation needs non-negative values (so `remaining` is a valid index). With negatives use a `HashMap` key.
- Say that this overlaps with the DP topic, and that memoisation is the fix when asked to optimise.

**How to explain:** "Same take / not-take recursion, but each branch returns a count and I add them. Memoising on index and remaining sum brings it down from exponential to O(n·K)."
