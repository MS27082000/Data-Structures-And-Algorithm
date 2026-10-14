# Combination Sum (LC 39)

**Problem:** Distinct positive candidates. Return all unique combinations that sum to `target`. A candidate may be used **unlimited times**.

**Brute force:** Try every multiset of any size → exponential with no pruning.
**Optimal:** **Backtracking.** At index `i` either **pick** `c[i]` and stay at `i` (reuse allowed), or **move on** to `i + 1`. Stop when `remaining == 0` (record) or `remaining < 0` (prune).

**Intuition:** Going forward only (`start`) makes each combination appear in one order (no `[2,3]` and `[3,2]` duplicates). Staying on `i` allows reuse.

**Complexity:** Time exponential, roughly O(2^(target/min)). Space O(target / min) depth.

**Edge cases:** No combination (`[2]`, target 1), target equal to one candidate, candidate larger than target, candidate 1 (deep recursion).

**Interview traps**
- Recurse with **`i`** (not `i + 1`) to allow reuse.
- Sort + `break` when `c[i] > remaining` for a big speed-up.
- Record a **copy** of `path`.
- Compare with Combination Sum II: there each element is used once and duplicates must be skipped.

**How to explain:** "At each step I pick a candidate and stay on it since reuse is allowed, or advance past it. When the remaining sum hits zero I record the combination; if it goes negative I stop that branch."
