# Majority Element II (LC 229)

**Problem:** Find all elements appearing more than `n/3` times.

**Brute force:** Count each element → O(n²). **Better:** HashMap → O(n) time, O(n) space.
**Optimal:** Extended Boyer-Moore with **two** candidates and two counters → O(n) time, O(1) space.

**Key fact:** At most **2** elements can appear more than n/3 times (three would need more than n elements). So we need just two candidates.

**Steps:**
1. Pass 1: if `x == candidate1` → `count1++`; else if `x == candidate2` → `count2++`; else if `count1 == 0` → set candidate1; else if `count2 == 0` → set candidate2; else `count1--, count2--`.
2. Pass 2: **recount** both candidates and keep those with count `> n/3`.

**Dry run: `[2, 2, 1, 3]`** (n/3 = 1, so we need more than 1 occurrence)

| x | candidate1 / count1 | candidate2 / count2 | action |
|---|---|---|---|
| 2 | 2 / 1 | - / 0 | take candidate1 slot |
| 2 | 2 / 2 | - / 0 | vote for candidate1 |
| 1 | 2 / 2 | 1 / 1 | take candidate2 slot |
| 3 | 2 / 1 | 1 / 0 | different from both, both counts drop |

Pass 2: `2` appears 2 times (> 1) → keep. `1` appears 1 time (not > 1) → drop. Answer `[2]`.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Fewer than 3 elements, no majority (`[1,2,3,4]` → `[]`), both candidates qualify, `Integer.MIN_VALUE` in the input.

**Interview traps**
- The verification pass is **mandatory**. Boyer-Moore only gives candidates, not guarantees.
- Check `x == cand` **before** the zero-count checks, or the same value becomes both candidates.
- Initial candidates must not clash with real values (ensure `candidate1 != candidate2`).
- Generalises: for `n/k`, keep `k-1` candidates.

**How to explain:** "Same voting idea but with two candidates, since at most two values can exceed n/3. A second pass confirms which ones really qualify."
