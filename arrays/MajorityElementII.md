# Majority Element II (LC 229)

**Problem:** Find all elements appearing more than `n/3` times.

**Brute force:** Count each element → O(n²). **Better:** HashMap → O(n) time, O(n) space.
**Optimal:** Extended Boyer-Moore with **two** candidates and two counters → O(n) time, O(1) space.

**Key fact:** At most **2** elements can appear more than n/3 times (three would need more than n elements). So we need just two candidates.

**Steps:**
1. Pass 1: if `x == cand1` → `c1++`; else if `x == cand2` → `c2++`; else if `c1 == 0` → set cand1; else if `c2 == 0` → set cand2; else `c1--, c2--`.
2. Pass 2: **recount** both candidates and keep those with count `> n/3`.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Fewer than 3 elements, no majority (`[1,2,3,4]` → `[]`), both candidates qualify, `Integer.MIN_VALUE` in the input.

**Interview traps**
- The verification pass is **mandatory**. Boyer-Moore only gives candidates, not guarantees.
- Check `x == cand` **before** the zero-count checks, or the same value becomes both candidates.
- Initial candidates must not clash with real values (ensure `n1 != n2`).
- Generalises: for `n/k`, keep `k-1` candidates.

**How to explain:** "Same voting idea but with two candidates, since at most two values can exceed n/3. A second pass confirms which ones really qualify."
